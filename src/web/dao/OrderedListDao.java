package web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import web.entity.OrderedList;
import web.util.HibernateUtil;

public class OrderedListDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<OrderedList> findAll() {

		List<OrderedList> lists = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			lists = session.createCriteria(OrderedList.class).list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return lists;
	}
	
	public List<OrderedList> findByAuthor(int authorId) {

		List<OrderedList> lists = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();
			
			lists = session.createQuery("from OrderedList where author=:id")
					.setInteger("id", authorId)
					.list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return lists;
	}
	
	public OrderedList find(int id) {

		OrderedList list = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			list = (OrderedList) session.createQuery("from OrderedList where id=:id")
					.setInteger("id", id)
					.uniqueResult();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return list;
	}
	
	public Integer create(OrderedList orderedList) {

		Integer id = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			id = (Integer) session.save(orderedList);
			
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
