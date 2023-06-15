package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
			dispatcher.forward(request, response);
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String values = request.getParameter("values");
		System.out.println(values);

		if(values.equals("スケジュール表示")) {
			// 検索処理を行う
			Schedule_listDAO sDao = new Schedule_listDAO();
			List<Schedule> scheduleList = sDao.select();

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("scheduleList", scheduleList);
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_list.jsp");
		dispatcher.forward(request, response);
	}
}
