package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
		//request.getAttribute("schedule_id");
		System.out.println(schedule_id);
		String values = request.getParameter("edit");
		System.out.println(values);

		Schedule_editDAO editDao = new Schedule_editDAO();

		if(values.equals("編集")) {
			Schedule sche = editDao.selectschedule(schedule_id);
			System.out.println(sche);
			request.setAttribute("sche", sche);

			//スケジュール編集画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
			dispatcher.forward(request, response);
		}


		if(values.equals("編集を完了")) {
			String user_name = (String)session.getAttribute("user_name");
			String schedule_name = request.getParameter("schedule_name");
			String start_date = request.getParameter("start_date");
			String start_time= request.getParameter("start_time");
			String finish_date = request.getParameter("finish_date");
			String finish_time= request.getParameter("finish_time");
			int color_id = Integer.parseInt(request.getParameter("color_id"));
			String content= request.getParameter("content");

			//更新処理
			if(editDao.update(new Schedule(
					schedule_id, user_name, schedule_name, start_date, start_time, finish_date, finish_time, color_id, content))) {
				//登録成功
				session.setAttribute("sessionresultmessage", "編集が完了しました。");
				session.removeAttribute("registOK");
				response.sendRedirect("/Esan/Schedule_listServlet");
				return;
			}else{
				//登録失敗
				//response.sendRedirect("Schedule_editServlet");
				//request.setAttribute("sche", sche);
				System.out.println("編集失敗");
				request.setAttribute("resultmessage", "編集ができませんでした。");
				Schedule sche = editDao.selectschedule(schedule_id);
				request.setAttribute("sche", sche);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
				dispatcher.forward(request, response);
			}
		}

		//スケジュール編集画面にフォワード
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
		//dispatcher.forward(request, response);

	}
}
