package pl.edu.agh.bd.bootcamp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.dao.OrderDao;
import pl.edu.agh.bd.bootcamp.model.Customer;
import pl.edu.agh.bd.bootcamp.model.Order;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateTestSupport;

public class OrderTest extends CustomHibernateTestSupport {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private OrderDao orderDao;

	@Before
	public void setUp() {
		Customer c1 = new Customer();
		c1.setContactName("Wojciech");
		Order order = new Order();
		order.setShipName("Kraków");
		c1.addOrder(order);
		customerDao.save(c1);
	}

	@Test
	@Transactional
	public void testGetAll() {
		assertEquals(1, orderDao.getAll().size());
	}

	@Test
	@Transactional
	public void testSaveThenAdd() {
		Order order = new Order();
		order.setShipName("Warszawa");
		orderDao.save(order);
		assertEquals(2, orderDao.getAll().size());
		Customer cust = customerDao.getAll().get(0);
		cust.addOrder(order);
		customerDao.save(cust);
		assertEquals(2, orderDao.getAll().size());
	}
}