package servlet;

import java.io.IOException;
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list2.jsp");
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
		String date = request.getParameter("date");
		System.out.println(date);
		request.setAttribute("date", date);

		//スケジュールをすべて取得
		if(values != null) {
			if(values.equals("スケジュール表示")) {
				// 検索処理を行う
				Schedule_listDAO sDao = new Schedule_listDAO();
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list2.jsp");
				dispatcher.forward(request, response);
			}
		}

		if(values.equals("削除")) {
			request.setCharacterEncoding("UTF-8");
			String user_name = request.getParameter("user_name");
			String schedule_name = request.getParameter("schedule_name");

			Schedule_listDAO sDao = new Schedule_listDAO();
			if (sDao.delete(user_name, schedule_name)) {	// 削除成功
				request.setAttribute("result","レコードを削除しました。");
			}
			else {						// 削除失敗
				request.setAttribute("result","レコードを削除できませんでした。");
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		}
	}
}
