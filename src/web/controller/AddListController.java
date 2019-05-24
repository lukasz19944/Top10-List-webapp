package web.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.ItemDao;
import web.dao.OrderedListDao;
import web.dao.UserDao;
import web.entity.Item;
import web.entity.OrderedList;
import web.entity.User;

@WebServlet("/addList")
public class AddListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddListController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			request.getRequestDispatcher("list/add_list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("list/access_denied.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		UserDao userDao = new UserDao();
		OrderedListDao orderedListDao = new OrderedListDao();
		ItemDao itemDao = new ItemDao();

		String username = session.getAttribute("username").toString();
		User user = userDao.find(username);

		List<Item> items = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			String itemName = request.getParameter("item" + (i + 1) + "_name");
			String itemDescription = request.getParameter("item" + (i + 1) + "_description");

			items.add(new Item(itemName, itemDescription));
		}

		OrderedList list = new OrderedList();
		list.setName(request.getParameter("list_name"));
		list.setDescription(request.getParameter("list_description"));
		list.setPublishDate(LocalDate.now());
		list.setAuthor(user);

		orderedListDao.create(list);

		for (Item item : items) {
			item.setList(list);

			itemDao.create(item);
		}

		list.setItems(items);

		response.sendRedirect("list");

	}

}
