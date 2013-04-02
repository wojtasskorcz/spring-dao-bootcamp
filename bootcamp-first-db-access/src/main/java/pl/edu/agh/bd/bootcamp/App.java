package pl.edu.agh.bd.bootcamp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.model.Customer;

public class App {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"config/BeanLocations.xml");

		CustomerDao customerDao = (CustomerDao) appContext
				.getBean("customerDao");

		Customer c1 = new Customer();
		c1.setContactName("Piotr");
		Customer c2 = new Customer();
		c2.setContactName("Wojciech");
		customerDao.save(c1);
		customerDao.save(c2);

		List<Customer> customers = customerDao.getAll();

		for (Customer c : customers) {
			System.out.println(c);
		}
	}
}
