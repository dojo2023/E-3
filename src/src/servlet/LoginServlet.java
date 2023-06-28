package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Login;
import model.Login_user;
import model.Result;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String un = request.getParameter("user_name");
		String pw = request.getParameter("password");

		if (un.equals("") && pw.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※未入力の項目があります", "/Esan/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if (un.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※ユーザーネームを入力してください", "/Esan/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if (pw.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※パスワードを入力してください", "/Esan/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// ログイン処理を行う
		LoginDAO logDao = new LoginDAO();
		if (logDao.isLoginOK(new Login(un, pw))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("un", new Login_user(un));
			session.setAttribute("user_name", un);

		// スケジュール管理画面にリダイレクトする
		response.sendRedirect("/Esan/Schedule_listServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("※ユーザネームとパスワードが一致しません。", "/Esan/LoginServlet"));

			// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}
