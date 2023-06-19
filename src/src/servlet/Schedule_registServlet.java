package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Schedule_registDAO;
import model.Schedule;

/**
 * Servlet implementation class Schedule_registServlet
 */
@WebServlet("/Schedule_registServlet")
public class Schedule_registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/Esan/LoginServlet");
//			return;
//		}

		//スケジュール登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//もしログインしてなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if(session.getAttribute("id") == null){
//			response.sendRedirect("/Esan/LoginServlet");
//			return;
//		}
//		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String schedule_name = request.getParameter("schedule_name");
		String start_date = request.getParameter("start_date");
		String start_time= request.getParameter("start_time");
		String finish_date = request.getParameter("finish_date");
		String finish_time= request.getParameter("finish_time");
		String color_id = request.getParameter("color_id");
		String content= request.getParameter("content");

		//登録処理
		Schedule_registDAO registDAO = new Schedule_registDAO();
		if(registDAO.insert(new Schedule(user_name,schedule_name,start_date,start_time,finish_date,finish_time,color_id,content))) {
			//登録成功
			response.sendRedirect("Schedule_listServlet");
			return;
		}else{
			//登録失敗
			response.sendRedirect("Schedule_registServlet");
		}

	}
}
