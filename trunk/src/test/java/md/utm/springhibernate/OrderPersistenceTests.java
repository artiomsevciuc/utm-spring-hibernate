package md.utm.springhibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import md.utm.springhibernate.dao.OrderPersistenceDAO;
import md.utm.springhibernate.entity.Order;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {
	@Autowired
	private OrderPersistenceDAO orderPersistenceDao;
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		Order order = orderPersistenceDao.saveOrderWithItems();
		assertNotNull(order.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		Order order = orderPersistenceDao.saveAndGet();
		Order other = (Order) sessionFactory.getCurrentSession().get(
				Order.class, order.getId());
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		orderPersistenceDao.saveAndFind();
		Order other = (Order) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select o from Order o join o.items i where i.product=:product")
				.setString("product", "foo").uniqueResult();
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

}
