package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.UserDao;
import web.entity.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("login")) {
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("signup")) {
			request.getRequestDispatcher("user/signup.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("signup")) {
			doPostSignUp(request, response);
		} else if (action.equalsIgnoreCase("login")) {
			doPostLogin(request, response);
		}
		
	}
	
	protected void doPostLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userDao.login(username, password);
		
		if (user == null) {
			request.setAttribute("error", "Invalid username or password");
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("list");
		}
	}

	protected void doPostSignUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
			request.setAttribute("error", "Invalid username or password");
			request.getRequestDispatcher("user/signup.jsp").forward(request, response);
	
		} else {
			UserDao userDao = new UserDao();
			
			User user = new User();
			
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			
			userDao.create(user);
			
			response.sendRedirect("user?action=login");
		}
	}

}
