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
import model.Message;
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

		//ペットの画像を取得
		List<Pet> petList = pDao.selectpet(userdata);
		request.setAttribute("petList", petList);

		//きせかえ画像を取得
		List<Closet> closetList = pDao.selectcloset(user_name);
		request.setAttribute("closetList", closetList);
		//System.out.println(closetList);

		//メッセージを取得
		List<Message> messageList = pDao.selectmessage(userdata);
		request.setAttribute("messageList", messageList);

		//List<Closet> lastclosetList = pDao.selectlastcloset(user_name);
		//request.setAttribute("closetList", lastclosetList);
		//System.out.println(closetList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pet_home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user_name = (String)session.getAttribute("user_name");

		request.setCharacterEncoding("UTF-8");
		//変更するきせかえ画像IDを取得
		String hatcloset_img_id  = request.getParameter("hatimg");
		String dresscloset_img_id  = request.getParameter("dressimg");
		String shoescloset_img_id  = request.getParameter("shoesimg");
		String accessorycloset_img_id  = request.getParameter("accessoryimg");
		String backgroundcloset_img_id  = request.getParameter("backgroundimg");

		//request.getAttribute("closet_img_id");

		Pet_homeDAO pDao = new Pet_homeDAO();
		//Dressup dressup = pDao.selectcl(closet_img_id);
		//System.out.println(dressup);
		//request.setAttribute("dressup", dressup);

		//最終きせかえをすべて消す last_closet=false
		boolean dellast = pDao.updatedeletelastcloset(user_name);

		//最終きせかえの登録
		boolean truelast = pDao.updatetrue(hatcloset_img_id, user_name);
		System.out.println(truelast);
		truelast = pDao.updatetrue(dresscloset_img_id, user_name);
		System.out.println(truelast);
		truelast = pDao.updatetrue(shoescloset_img_id, user_name);
		System.out.println(truelast);
		truelast = pDao.updatetrue(accessorycloset_img_id, user_name);
		System.out.println(truelast);
		truelast = pDao.updatetrue(backgroundcloset_img_id, user_name);
		System.out.println(truelast);


		//ユーザ情報を取得
		User userdata = pDao.selectuser(user_name);
		request.setAttribute("userdata", userdata);

		//ペットの画像を取得
		List<Pet> petList = pDao.selectpet(userdata);
		request.setAttribute("petList", petList);

		//きせかえ画像を取得
		List<Closet> closetList = pDao.selectcloset(user_name);
		request.setAttribute("closetList", closetList);

		//メッセージを取得
		List<Message> messageList = pDao.selectmessage(userdata);
		request.setAttribute("messageList", messageList);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pet_home.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
