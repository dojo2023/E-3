package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InquiryDAO;
import model.Inquiry;
import model.Result;

/**
 * Servlet implementation class InquiryServlet
 */
@WebServlet("/InquiryServlet")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// お問い合わせ画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// フォームの値を受け取る
     	String un = request.getParameter("user_name");
		String em = request.getParameter("email");
		String co = request.getParameter("inquiry_content");

		if (em.equals("") && co.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※未入力の項目があります", "/Esan/SignupServlet"));
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
			dispatcher.forward(request, response);
			return;
		}

		else if (em.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※メールアドレスを入力してください", "/Esan/SignupServlet"));
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
			dispatcher.forward(request, response);
			return;
		}

		else if (co.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※お問い合わせ内容を入力してください", "/Esan/SignupServlet"));
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//お問い合わせ
		InquiryDAO iqDao = new InquiryDAO();
		if (iqDao.insertIq(new Inquiry(un, em, co)).equals("true")) {	// 登録成功
			request.setAttribute("result",
			new Result("お問い合わせ内容を送信しました。", "/Esan/InquiryServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("お問い合わせ内容を送信できませんでした。", "/Esan/InquiryServlet"));
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
