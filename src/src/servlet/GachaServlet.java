package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GachaDAO;
import model.Gacha;

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int randomint = (int)Math.ceil(Math.random() * 10);
		int rarity = 0;
		String closet_id = null;

		if(randomint<6) {
			rarity=1;
		}else if(6<=randomint&&randomint<9) {
			rarity=2;
		}else {
			rarity=3;
		}

		int randomint2 = (int)Math.ceil(Math.random() * 5);
		if(randomint==1){
			closet_id="hat";
		}else if(randomint==2){
			closet_id="dress";
		}else if(randomint==3){
			closet_id="shoes";
		}else if(randomint==4){
			closet_id="accessory";
		}else if(randomint==5){
			closet_id="bg";
		}

		int closetnum = (int)Math.ceil(Math.random() * 1);//後で3にする

		request.setCharacterEncoding("UTF-8");

		String gacharesult = closet_id+closetnum+"-"+rarity;

		GachaDAO gDao = new GachaDAO();
		Gacha gachadata = gDao.selectgacha(gacharesult);

		request.setAttribute("gachadata", gachadata);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
		dispatcher.forward(request, response);
	}

}

