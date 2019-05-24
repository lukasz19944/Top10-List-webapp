package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import web.entity.ListVote;
import web.entity.OrderedList;
import web.util.HibernateUtil;

public class ListVoteDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer create(ListVote listVote) {

		Integer id = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			id = (Integer) session.save(listVote);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return id;
	}

	public Integer update(ListVote listVote) {

		Integer id = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			session.update(listVote);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return id;
	}

	public ListVote getByUserAndList(int userId, int listId) {

		Session session = null;
		Transaction transaction = null;

		ListVote listVote = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			listVote = (ListVote) session.createQuery("from ListVote where user=:userId and list=:listId")
					.setInteger("userId", userId).setInteger("listId", listId).uniqueResult();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listVote;
	}


	public long getVoteCount(int listId, String voteType) {

		Session session = null;
		Transaction transaction = null;

		long count = 0l;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			count = ((Long) session.createQuery("select count(*) from ListVote "
					+ "where list=:listId and vote=:vote")
					.setInteger("listId", listId)
					.setString("vote", voteType)
					.uniqueResult()).intValue();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;
	}
	
}
