package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.ListVoteDao;
import web.dao.OrderedListDao;
import web.dao.UserDao;
import web.entity.ListVote;
import web.entity.OrderedList;
import web.entity.User;

@WebServlet("/rateList")
public class RateListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RateListController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {

			String vote = request.getParameter("vote");

			doPostVote(request, response, vote);

			request.getRequestDispatcher("list").forward(request, response);

		} else {
			request.getRequestDispatcher("list/access_denied.jsp").forward(request, response);
		}

	}

	protected void doPostVote(HttpServletRequest request, HttpServletResponse response, String vote)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		UserDao userDao = new UserDao();
		OrderedListDao orderedListDao = new OrderedListDao();
		ListVoteDao listVoteDao = new ListVoteDao();

		String username = session.getAttribute("username").toString();
		User user = userDao.find(username);

		Integer id = Integer.parseInt(request.getParameter("id"));
		OrderedList list = orderedListDao.find(id);

		ListVote listVote = listVoteDao.getByUserAndList(user.getId(), id);

		if (listVote == null) {

			listVote = new ListVote();
			listVote.setVote(vote);
			listVote.setUser(user);
			listVote.setList(list);

			listVoteDao.create(listVote);

		} else {
			listVote.setVote(vote);
			listVoteDao.update(listVote);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
