package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoinDAO2;
import dao.GachaDAO;
import dao.Schedule_listDAO;
import model.Gacha;
import model.ScheduleUser;

/**
 * Servlet implementation class GachaServlet
 */
@WebServlet("/GachaServlet")
public class GachaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("user_name", "ユーザ名");
		String user_name = (String)session.getAttribute("user_name");

		//DAO宣言 スケジュールリスト コイン
		Schedule_listDAO sDao = new Schedule_listDAO();
		//CoinDAO2 cDao = new CoinDAO2(); //後で消す
		//後で消す
		//cDao.coinplus50(user_name);

		//ユーザ情報を取得(パスワード、メアドなし)
		ScheduleUser userdata = sDao.selectuser(user_name);

		request.setAttribute("userdata", userdata);



		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String user_name = (String)session.getAttribute("user_name");

		//DAO宣言 スケジュールリスト コイン
		Schedule_listDAO sDao = new Schedule_listDAO();
		CoinDAO2 cDao = new CoinDAO2();

		//ユーザ情報を取得(パスワード、メアドなし)
		ScheduleUser userdata = sDao.selectuser(user_name);

		if(userdata.getCoin_cnt() < 10) {
			request.setAttribute("alert", 1);
			request.setAttribute("userdata", userdata);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
			dispatcher.forward(request, response);
		}else {
			boolean coinminus = cDao.coinminus10(user_name);
			int coin = cDao.selectcoin(user_name);
			userdata.setCoin_cnt(coin);
		}

		//レアリティを決める
		int randomint = (int)Math.ceil(Math.random() * 10);
		int rarity = 0;
		String closet_id = null;

		if(randomint < 6) {
			rarity = 1;
		}else if(randomint >= 6 && randomint < 9) {
			rarity = 2;
		}else {
			rarity = 3;
		}

		//きせかえ種類を決める
		int randomint2 = (int)Math.ceil(Math.random() * 5);
		if(randomint2 == 1){
			closet_id = "hat";
		}else if(randomint2 == 2){
			closet_id = "dress";
		}else if(randomint2 == 3){
			closet_id = "shoes";
		}else if(randomint2 == 4){
			closet_id = "accessory";
		}else if(randomint2 == 5){
			closet_id = "bg";
		}

		//きせかえ種類の中のどれかを決める
		int closetnum = (int)Math.ceil(Math.random() * 3);

		//データベースに送るcloset_img_id
		String gacharesult = closet_id + userdata.getPet_id() + "-" + closetnum;
		String result = "OK";

		GachaDAO gDao = new GachaDAO();
		Gacha gachadata = gDao.selectgacha(gacharesult);


		//クローゼットテーブルにインサートする
		if(gachadata != null) {
			boolean insertOK = gDao.insertcloset(gachadata, user_name);
			if(insertOK) {
				System.out.println("インサート完了");
			}else {
				System.out.println("インサートできませんでした");
			}
		}else {
			System.out.println("そのきせかえは存在しません");
		}

		request.setAttribute("gachadata", gachadata);
		request.setAttribute("userdata", userdata);
		request.setAttribute("result", result);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
		dispatcher.forward(request, response);
	}

}

