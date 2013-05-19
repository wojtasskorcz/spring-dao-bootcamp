package pl.edu.agh.bd.bootcamp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.generation.DataGenerator;
import pl.edu.agh.bd.bootcamp.model.Customer;
import pl.edu.agh.bd.bootcamp.model.CustomerDemographics;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateTestSupport;

public class LazyLoadingTest extends CustomHibernateTestSupport {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private DataGenerator dataGenerator;
	@Autowired
	private SessionFactory sessionFactory;

	@Before
	public void setUp() {
	}

	@Test
	@Transactional
	public void testGetAllDependencies() {
		dataGenerator.generateCustomerDemographics(10);
		int ncustomers = 300;
		int nToGet = 300;
		dataGenerator.generateCustomers(ncustomers, 3);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		System.out.println("~~~~~~~~~~~~~~~~~~");
		List<Integer> baseIndices = new ArrayList<Integer>();
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < ncustomers; i++) {
			baseIndices.add(i);
		}
		for (int i = 0; i < nToGet; i++) {
			indices.add(baseIndices.remove(random.nextInt(baseIndices.size())));
		}
		long startTime = System.currentTimeMillis();
		List<Customer> customers = customerDao.getAll();
		for (Integer i : indices) {
			List<CustomerDemographics> cds = customers.get(i).getCustomerDemographics();
			cds.get(cds.size() - 1).getCustomerDesc();
		}
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("Duration of all: " + duration);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	@Test
	@Transactional
	public void testGetSomeDependencies() {
		dataGenerator.generateCustomerDemographics(1000);
		int ncustomers = 10;
		int nToGet = 2;
		dataGenerator.generateCustomers(ncustomers, 1000);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		System.out.println("~~~~~~~~~~~~~~~~~~");
		List<Integer> baseIndices = new ArrayList<Integer>();
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < ncustomers; i++) {
			baseIndices.add(i);
		}
		for (int i = 0; i < nToGet; i++) {
			indices.add(baseIndices.remove(random.nextInt(baseIndices.size())));
		}
		long startTime = System.currentTimeMillis();
		List<Customer> customers = customerDao.getAll();
		for (Integer i : indices) {
			List<CustomerDemographics> cds = customers.get(i).getCustomerDemographics();
			cds.get(cds.size() - 1).getCustomerDesc();
		}
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("Duration of some: " + duration);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	private Random random = new Random();
}