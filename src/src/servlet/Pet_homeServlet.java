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
import model.Pet;


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
		session.setAttribute("user_name", "ユーザ名");
		String user_name = (String)session.getAttribute("user_name");
		Pet_homeDAO pDao = new Pet_homeDAO();
		List<Pet> petList = pDao.selectpet();
		request.setAttribute("petList", petList);


		List<Closet> closetList = pDao.selectcloset(user_name);
		request.setAttribute("closetList", closetList);
		System.out.println(closetList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pet_home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
