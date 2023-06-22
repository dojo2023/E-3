package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoinDAO2;
import dao.Schedule_listDAO;
import model.Coin;
import model.Schedule;
import model.ScheduleUser;

/**
 * Servlet implementation class Schedule_listServlet
 */
@WebServlet("/Schedule_listServlet")
public class Schedule_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("user_name") == null) {
			response.sendRedirect("/Esan/LoginServlet");
			return;
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}*/

		HttpSession session = request.getSession();
		session.setAttribute("user_name", "ユーザ名");
		String user_name = (String)session.getAttribute("user_name");

		//DAO宣言 スケジュールリスト コイン
		Schedule_listDAO sDao = new Schedule_listDAO();
		CoinDAO2 cDao = new CoinDAO2();

		//ユーザ情報を取得(パスワード、メアドなし)
		ScheduleUser userdata = sDao.selectuser(user_name);
		request.setAttribute("userdata", userdata);


		//今日の日付を取得
		long miliseconds = System.currentTimeMillis();
        Date today = new Date(miliseconds);

        //今日の日付のスケジュールを取得
		List<Schedule> scheduleList = sDao.selectdate(today);

		//最終ログイン日を確認 コイン追加1枚
		Date last_login_date = null;
		boolean updateresult = false;
		if(userdata.getLast_login_date() == null) {
			Coin coinplus = cDao.coinplus50(user_name);
			request.setAttribute("coinplus", coinplus);
			int coin = cDao.selectcoin(user_name);
			userdata.setCoin_cnt(coin);
			updateresult = sDao.updatelast_login_date(user_name, today);
		}else {
			last_login_date = Date.valueOf(userdata.getLast_login_date());
			if(!last_login_date.toString().equals(today.toString()) && last_login_date.before(today)) {
				Coin coinplus= cDao.coinplus1(user_name);
				request.setAttribute("coinplus", coinplus);
				int coin = cDao.selectcoin(user_name);
				userdata.setCoin_cnt(coin);
				updateresult = sDao.updatelast_login_date(user_name, today);
			}
		}


		//最終ログイン日を更新
		//boolean updateresult = sDao.updatelast_login_date(user_name, today);

		//時間の文字列を加工 秒を削除
		for(Schedule e: scheduleList) {
			e.setStart_time(e.getStart_time().substring(0, 5));
			e.setFinish_time(e.getFinish_time().substring(0, 5));
			e.setStart_hour(e.getStart_time().substring(0, 2));
			e.setFinish_hour(e.getFinish_time().substring(0, 2));
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scheduleList", scheduleList);
		request.setAttribute("date", today);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String values = request.getParameter("values");
		System.out.println(values);

		Schedule_listDAO sDao = new Schedule_listDAO();
		CoinDAO2 cDao = new CoinDAO2();

		//ユーザ情報を取得(パスワード、メアドなし)
		HttpSession session = request.getSession();
		String user_name = (String)session.getAttribute("user_name");
		ScheduleUser userdata = sDao.selectuser(user_name);
		request.setAttribute("userdata", userdata);

		//スケジュールをすべて取得
		if(values != null) {
			if(values.equals("スケジュール表示")) {
				// 検索処理を行う
				List<Schedule> scheduleList = sDao.selectall();
				//List<Schedule> scheduleList = sDao.select();

				for(Schedule e: scheduleList) {
					e.setStart_time(e.getStart_time().substring(0, 5));
					e.setFinish_time(e.getFinish_time().substring(0, 5));
					e.setStart_hour(e.getStart_time().substring(0, 2));
					e.setFinish_hour(e.getFinish_time().substring(0, 2));
				}
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("scheduleList", scheduleList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
				dispatcher.forward(request, response);
			}
		}

		//カレンダーで選択した日付のスケジュールを取得
		if(values.equals("date")) {
			String strdate = request.getParameter("date");
			strdate = strdate.replaceAll("/", "-");
			Date date= Date.valueOf(strdate);

			List<Schedule> scheduleList = sDao.selectdate(date);

			for(Schedule e: scheduleList) {
				e.setStart_time(e.getStart_time().substring(0, 5));
				e.setFinish_time(e.getFinish_time().substring(0, 5));
				e.setStart_hour(e.getStart_time().substring(0, 2));
				e.setFinish_hour(e.getFinish_time().substring(0, 2));
			}

			// スケジュールの検索結果と表示する日付をリクエストスコープに格納する
			request.setAttribute("scheduleList", scheduleList);
			request.setAttribute("date", date);
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}

		//削除処理
		if(values.equals("削除")) {
			int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));

			if (sDao.delete(schedule_id)) {	// 削除成功
				request.setAttribute("result","スケジュールを削除しました。");
			}
			else {						// 削除失敗
				request.setAttribute("result","スケジュールを削除できませんでした。");
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}

		//タスク完了処理
		if(values.equals("完了")) {
			int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));

			sDao.updatedone(schedule_id);

			String strdate = request.getParameter("senddate");
			strdate = strdate.replaceAll("/", "-");
			Date date= Date.valueOf(strdate);

			List<Schedule> scheduleList = sDao.selectdate(date);

			for(Schedule e: scheduleList) {
				e.setStart_time(e.getStart_time().substring(0, 5));
				e.setFinish_time(e.getFinish_time().substring(0, 5));
				e.setStart_hour(e.getStart_time().substring(0, 2));
				e.setFinish_hour(e.getFinish_time().substring(0, 2));
			}

			Coin coinplus= cDao.coinplus1(user_name);
			request.setAttribute("coinplus", coinplus);
			int coin = cDao.selectcoin(user_name);
			userdata.setCoin_cnt(coin);

			// スケジュールの検索結果と表示する日付をリクエストスコープに格納する
			request.setAttribute("scheduleList", scheduleList);
			request.setAttribute("date", date);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}
	}
}
