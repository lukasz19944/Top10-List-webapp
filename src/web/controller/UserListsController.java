package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.OrderedListDao;
import web.dao.UserDao;
import web.entity.User;

@WebServlet("/userLists")
public class UserListsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserListsController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") != null) {
		
			UserDao userDao = new UserDao();
			String username = session.getAttribute("username").toString();
			User user = userDao.find(username);
			
			OrderedListDao orderedListDao = new OrderedListDao();
	
			request.setAttribute("my_lists", orderedListDao.findByAuthor(user.getId()));
			request.getRequestDispatcher("list/mylists.jsp").forward(request, response);
			
		} else {
			request.getRequestDispatcher("list/access_denied.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
