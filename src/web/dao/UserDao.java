package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import web.entity.User;
import web.util.HibernateUtil;

public class UserDao {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer create(User user) {

		Integer id = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			id = (Integer) session.save(user);
			
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return id;
	}
	
	public User login(String username, String password) {

		User user = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			user = (User) session.createQuery("from User where username = :username and password = :password")
					.setString("username", username)
					.setString("password", password)
					.uniqueResult();
			
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return user;
	}
	
	public User find(String username) {

		User user = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			user = (User) session.createQuery("from User where username = :username")
					.setString("username", username)
					.uniqueResult();
			
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return user;
	}
}
