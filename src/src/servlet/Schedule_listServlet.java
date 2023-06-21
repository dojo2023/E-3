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

import dao.CoinDAO;
import dao.Schedule_listDAO;
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
		CoinDAO cDao = new CoinDAO();

		//ユーザ情報を取得(パスワード、メアドなし)
		ScheduleUser userdata = sDao.selectuser(user_name);
		request.setAttribute("userdata", userdata);


		//今日の日付を取得
		long miliseconds = System.currentTimeMillis();
        Date today = new Date(miliseconds);
        System.out.println(today);

        //今日の日付のスケジュールを取得
		List<Schedule> scheduleList = sDao.selectdate(today);

		//最終ログイン日を確認
		Date last_login_date = Date.valueOf(userdata.getLast_login_date());
		if(last_login_date.before(today)) {
			System.out.println("yes");
		}

		//boolean updateresult = sDao.updatelast_login_date(user_name, today);

		//時間の文字列を加工 秒を削除
		for(Schedule e: scheduleList) {
			e.setStart_time(e.getStart_time().substring(0, 5));
			e.setFinish_time(e.getFinish_time().substring(0, 5));
			e.setStart_hour(e.getStart_time().substring(0, 2));
			e.setFinish_hour(e.getFinish_time().substring(0, 2));
		}

		//コインの増加するか確認
		//if(userdata.)

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scheduleList", scheduleList);

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

		//削除処理
		if(values.equals("削除")) {
			int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));

			if (sDao.delete(schedule_id)) {	// 削除成功
				request.setAttribute("result","レコードを削除しました。");
			}
			else {						// 削除失敗
				request.setAttribute("result","レコードを削除できませんでした。");
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}

		if(values.equals("date")) {
			String strdate = request.getParameter("date");
			Date date= Date.valueOf(strdate);
			System.out.println(date);

			List<Schedule> scheduleList = sDao.selectdate(date);

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
}
