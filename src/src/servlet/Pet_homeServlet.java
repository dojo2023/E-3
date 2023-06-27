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

import dao.Pet_homeDAO;
import model.Closet;
import model.Dressup;
import model.Pet;
import model.User;


/**
 * Servlet implementation class Pet_homeServlet
 */
@WebServlet("/Pet_homeServlet")
public class Pet_homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Pet_homeDAO pDao = new Pet_homeDAO();
		session.setAttribute("user_name", "ユーザ名");
		String user_name = (String)session.getAttribute("user_name");
		//ユーザ情報を取得
		User userdata = pDao.selectuser(user_name);
		request.setAttribute("userdata", userdata);

		List<Pet> petList = pDao.selectpet(userdata);
		request.setAttribute("petList", petList);




		List<Closet> closetList = pDao.selectcloset(user_name);
		request.setAttribute("closetList", closetList);
		//System.out.println(closetList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pet_home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//変更するきせかえ画像IDを取得
		String closet_img_id  = request.getParameter("image");
		System.out.println(closet_img_id);
		//request.getAttribute("closet_img_id");

		Pet_homeDAO clDao = new Pet_homeDAO();
		Dressup dressup = clDao.selectcl(closet_img_id);
		//System.out.println(dressup);
		request.setAttribute("dressup", dressup);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pet_home.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
