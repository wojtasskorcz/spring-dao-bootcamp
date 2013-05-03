package pl.edu.agh.bd.bootcamp.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.model.Customer;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateTestSupport;

public class CustomerTest extends CustomHibernateTestSupport {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Before
	public void setUp() {
		Customer c1 = new Customer();
		c1.setContactName("Wojciech");
		Customer c2 = new Customer();
		c2.setContactName("Piotr");
		Customer c3 = new Customer();
		c3.setContactName("Wojciech");
		customerDao.save(c1);
		customerDao.save(c2);
		customerDao.save(c3);
	}
	
	@Test
	@Transactional
	public void testGetAll() {
		assertEquals(customerDao.getAll().size(), 3);
	}
	
	@Test
	@Transactional
	public void testGetByContactName() {
		assertEquals(customerDao.getByContactName("Wojciech").size(), 2);
	}
	
	@Test
	@Transactional
	public void testEmptyGetByContactName() {
		assertEquals(customerDao.getByContactName("Jan").isEmpty(), true);
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		List<Customer> customers = customerDao.getByContactName("Piotr");
		assertEquals(customers.size(), 1);
		Customer piotr = customers.get(0);
		piotr.setContactName("Jan");
		customerDao.update(piotr);
		assertEquals(customerDao.getByContactName("Piotr").isEmpty(), true);
		assertEquals(customerDao.getByContactName("Jan").size(), 1);
	}
	
	@Test
	@Transactional
	public void testDelete() {
		List<Customer> customers = customerDao.getByContactName("Wojciech");
		assertEquals(customers.size(), 2);
		Customer wojciech1 = customers.get(0);
		Customer wojciech2 = customers.get(1);
		customerDao.delete(wojciech1);
		customers = customerDao.getByContactName("Wojciech");
		assertEquals(customers.size(), 1);
		Customer newWojciech = customers.get(0);
		assertEquals(wojciech2.getCustomerId(), newWojciech.getCustomerId());
	}

}
