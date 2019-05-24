package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.OrderedListDao;

@WebServlet("/list")
public class OrderedListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderedListController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			doGetFindAll(request, response);
		} else if (action.equalsIgnoreCase("detail")) {
			doGetDetail(request, response);
		}
		
	}
	
	protected void doGetFindAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderedListDao orderedListDao = new OrderedListDao();

		request.setAttribute("lists", orderedListDao.findAll());
		request.getRequestDispatcher("list/index.jsp").forward(request, response);
	}

	protected void doGetDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrderedListDao orderedListDao = new OrderedListDao();
		
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("list", orderedListDao.find(id));
		request.getRequestDispatcher("list/detail.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
