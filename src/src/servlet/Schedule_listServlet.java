package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Schedule_listDAO;
import model.Schedule;

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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/BCM/LoginServlet");
			return;
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}*/

		HttpSession session = request.getSession();
		session.setAttribute("id", "ユーザ名");
		session.setAttribute("pet", "1");
		session.setAttribute("coin", "52");

		Calendar cl = Calendar.getInstance();

        //日付をyyyyMMddの形で出力する
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        String today = sdf1.format(cl.getTime());
        today = today.replace("/", "-");
        System.out.println(today);

        Schedule_listDAO sDao = new Schedule_listDAO();
		List<Schedule> scheduleList = sDao.selectdate(today);

		for(Schedule e: scheduleList) {
			e.setStart_time(e.getStart_time().substring(0, 5));
			e.setFinish_time(e.getFinish_time().substring(0, 5));
			e.setStart_hour(e.getStart_time().substring(0, 2));
			e.setFinish_hour(e.getFinish_time().substring(0, 2));
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scheduleList", scheduleList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list4.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String values = request.getParameter("values");
		System.out.println(values);
		String user = request.getParameter("userid");

		Schedule_listDAO sDao = new Schedule_listDAO();

		//スケジュールをすべて取得
		if(values != null) {
			if(values.equals("スケジュール表示")) {
				// 検索処理を行う
				List<Schedule> scheduleList = sDao.selectcolor_code();
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list4.jsp");
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list4.jsp");
			dispatcher.forward(request, response);
		}

		if(values.equals("date")) {
			String date = request.getParameter("date");
			date = date.replaceAll("/", "-");
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list4.jsp");
			dispatcher.forward(request, response);
		}
	}
}
