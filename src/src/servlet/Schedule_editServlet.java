package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Schedule_editDAO;
import model.Schedule;

/**
 * Servlet implementation class Schedule_editServlet
 */
@WebServlet("/Schedule_editServlet")
public class Schedule_editServlet extends HttpServlet {
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

		//リクエストスコープから取得
		request.getAttribute("schedule_id");

		//スケジュール編集画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	//もしログインしてなかったらログインサーブレットにリダイレクトする
//	HttpSession session = request.getSession();
//	if(session.getAttribute("id") == null){
//		response.sendRedirect("/Esan/LoginServlet");
//		return;
//	}
	//リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			String user_name = (String)request.getAttribute("user_name");
			String schedule_name = (String)request.getAttribute("schedule_name");
			String start_date = (String)request.getAttribute("start_date");
			String start_time= (String)request.getAttribute("start_time");
			String finish_date = (String)request.getAttribute("finish_date");
			String finish_time= (String)request.getAttribute("finish_time");
			String color_id = (String)request.getAttribute("color_id");
			String content= (String)request.getAttribute("content");

			//更新処理
			Schedule_editDAO editDao = new Schedule_editDAO();
			if(request.getParameter("submit").equals("編集を完了")) {
				if(editDao.update(new Schedule(
						user_name,schedule_name,start_date,start_time,finish_date,finish_time,color_id,content))) {
					//登録成功
					response.sendRedirect("Schedule_listServlet");
					return;
				}else{
					//登録失敗
					response.sendRedirect("Schedule_editServlet");
				}
			}
	}
}
