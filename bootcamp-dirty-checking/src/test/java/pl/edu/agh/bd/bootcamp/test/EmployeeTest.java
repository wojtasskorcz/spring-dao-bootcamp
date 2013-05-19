package pl.edu.agh.bd.bootcamp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.EmployeeDao;
import pl.edu.agh.bd.bootcamp.dao.TerritoryDao;
import pl.edu.agh.bd.bootcamp.model.Employee;
import pl.edu.agh.bd.bootcamp.model.Territory;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateTestSupport;

public class EmployeeTest extends CustomHibernateTestSupport {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private TerritoryDao territoryDao;

	@Before
	public void setUp() {
		Employee e1 = new Employee();
		e1.setFirstName("Andrzej");
		employeeDao.save(e1);

		Employee e2 = new Employee();
		e2.setFirstName("Michał");
		employeeDao.save(e2);

		Employee e3 = new Employee();
		e3.setFirstName("Drzewiej");
		employeeDao.save(e3);
	}

	@Test
	@Transactional
	public void testGetAll() {
		assertEquals(3, employeeDao.getAll().size());
	}

	@Test
	@Transactional
	public void testTerritoryJoinTableOnTheFlySave() {
		Employee e = employeeDao.getAll().get(0);
		Territory t = new Territory();
		t.setTerritoryDescription("Kraków - dawna stolica Polaków");
		assertEquals(0, territoryDao.getAll().size());
		e.getTerritories().add(t);
		assertEquals(1, territoryDao.getAll().size());
		employeeDao.save(e);
		assertEquals(1, territoryDao.getAll().size());
	}

	@Test
	@Transactional
	public void testRelationWithSelf() {
		Employee e = employeeDao.getAll().get(0);
		e.setSupervisor(e);
		assertEquals(3, employeeDao.getAll().size());
		employeeDao.save(e);
		assertEquals(3, employeeDao.getAll().size());
	}

}