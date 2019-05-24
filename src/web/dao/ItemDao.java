package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import web.entity.Item;
import web.util.HibernateUtil;

public class ItemDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer create(Item item) {

		Integer id = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			id = (Integer) session.save(item);

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
}
