package md.utm.springhibernate.dao;

import md.utm.springhibernate.entity.Item;
import md.utm.springhibernate.entity.Order;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public class OrderPersistenceDAO {

	private SessionFactory currentSessionFactory;

	public Order saveOrderWithItems() throws Exception {
		Session session = currentSessionFactory.getCurrentSession();
		Order order = new Order();
		order.getItems().add(new Item());
		session.save(order);
		session.flush();
		return order;
	}

	public Order saveAndGet() throws Exception {
		Session session = currentSessionFactory.getCurrentSession();
		Order order = new Order();
		order.getItems().add(new Item());
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		return order;
	}

	public Order saveAndFind() throws Exception {
		Session session = currentSessionFactory.getCurrentSession();
		Order order = new Order();
		Item item = new Item();
		item.setProduct("foo");
		order.getItems().add(item);
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		return order;
	}

	public SessionFactory getCurrentSessionFactory() {
		return currentSessionFactory;
	}

	public void setCurrentSessionFactory(SessionFactory currentSessionFactory) {
		this.currentSessionFactory = currentSessionFactory;
	}

}
