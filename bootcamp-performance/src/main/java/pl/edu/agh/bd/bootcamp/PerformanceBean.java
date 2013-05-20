package pl.edu.agh.bd.bootcamp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.dao.ShipperDao;
import pl.edu.agh.bd.bootcamp.model.Category;
import pl.edu.agh.bd.bootcamp.model.Customer;
import pl.edu.agh.bd.bootcamp.model.Employee;
import pl.edu.agh.bd.bootcamp.model.Order;
import pl.edu.agh.bd.bootcamp.model.OrderDetails;
import pl.edu.agh.bd.bootcamp.model.Product;
import pl.edu.agh.bd.bootcamp.model.Region;
import pl.edu.agh.bd.bootcamp.model.Shipper;
import pl.edu.agh.bd.bootcamp.model.Territory;

@Service("performanceBean")
@Transactional
public class PerformanceBean {
	
	@Autowired
	private ShipperDao shipperDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public void shippersCategories() {
		List<Shipper> res = new ArrayList<Shipper>();
		
		long t1 = System.currentTimeMillis();
		for(Shipper shipper : shipperDao.getAll()) {
			nextShipper:
			for (Order order : shipper.getOrders()) {
				for (OrderDetails od : order.getOrderDetails()) {
					Product product = od.getProduct();
					Category category = product.getCategory();
					if (category.getCategoryName().equals("Lhgyuljwosezeg")) {
						res.add(shipper);
						break nextShipper;
					}
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		for (Shipper shipper : res) {
			System.out.println(shipper.getShipperId() + " " + shipper.getCompanyName());
		}
	}
	
	@Transactional
	public void customersEmployeesRegions() {
		List<Customer> res = new ArrayList<Customer>();
		
		long t1 = System.currentTimeMillis();
		for(Customer customer : customerDao.getAll()) {
			nextCustomer:
			for (Order order : customer.getOrders()) {
				Employee employee = order.getEmployee();
				for (Territory territory : employee.getTerritories()) {
					Region region = territory.getRegion();
					if (region.getRegionId() == 1) {
						res.add(customer);
						break nextCustomer;
					}
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		for (Customer customer : res) {
			System.out.println(customer.getCustomerId() + " " + customer.getContactName());
		}
	}
}
