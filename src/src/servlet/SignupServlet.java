package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignupDAO;
import model.Result;
import model.Signup;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規登録画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
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
		String pw = request.getParameter("password");
		String em = request.getParameter("email");
		String pn = request.getParameter("pet_name");
		int pi = Integer.parseInt(request.getParameter("pet_id"));

		if ((un.equals("") && pw.equals("") && em.equals("") && pn.equals("")) || (un.equals("") && pw.equals("")) || (pw.equals("") && em.equals("")) || (em.equals("") && pn.equals(""))){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("未入力の項目があります", "/Esan/SignupServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if (un.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("ユーザーネームを入力してください", "/Esan/SignupServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if (pw.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("パスワードを入力してください", "/Esan/SignupServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if (em.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("メールアドレスを入力してください", "/Esan/SignupServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if (pn.equals("")){
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("ペット名を入力してください", "/Esan/SignupServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 登録処理を行う
		SignupDAO logDao = new SignupDAO();
		if (logDao.insert(new Signup(un, pw, em, pn, pi)).equals("true")) {	// 登録成功
			request.setAttribute("result", new Result("新規登録しました。", "/Esan/SignupServlet"));
		}
			else if(logDao.insert(new Signup(un, pw, em, pn, pi)).equals("false")) {
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("新規登録できませんでした。", "/Esan/SignupServlet"));
		}
			else if(logDao.insert(new Signup(un, pw, em, pn, pi)).equals("dup")) {
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("そのユーザーネームはすでに使われています！", "/Esan/SignupServlet"));
		}
			else if(logDao.insert(new Signup(un, pw, em, pn, pi)).equals("don")) {
			// リクエストスコープにメッセージ、戻り先を格納する
			request.setAttribute("result", new Result("そのメールアドレスはすでに使われています！", "/Esan/SignupServlet"));
		}
			// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
