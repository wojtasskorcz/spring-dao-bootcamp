package pl.edu.agh.bd.bootcamp.generation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CategoryDao;
import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.dao.CustomerDemographicsDao;
import pl.edu.agh.bd.bootcamp.dao.EmployeeDao;
import pl.edu.agh.bd.bootcamp.dao.OrderDao;
import pl.edu.agh.bd.bootcamp.dao.ProductDao;
import pl.edu.agh.bd.bootcamp.dao.RegionDao;
import pl.edu.agh.bd.bootcamp.dao.ShipperDao;
import pl.edu.agh.bd.bootcamp.dao.SupplierDao;
import pl.edu.agh.bd.bootcamp.dao.TerritoryDao;
import pl.edu.agh.bd.bootcamp.model.Category;
import pl.edu.agh.bd.bootcamp.model.Customer;
import pl.edu.agh.bd.bootcamp.model.CustomerDemographics;
import pl.edu.agh.bd.bootcamp.model.Employee;
import pl.edu.agh.bd.bootcamp.model.Order;
import pl.edu.agh.bd.bootcamp.model.OrderDetails;
import pl.edu.agh.bd.bootcamp.model.Product;
import pl.edu.agh.bd.bootcamp.model.Region;
import pl.edu.agh.bd.bootcamp.model.Shipper;
import pl.edu.agh.bd.bootcamp.model.Supplier;
import pl.edu.agh.bd.bootcamp.model.Territory;

@Transactional
@Repository("dataGenerator")
public class DataGeneratorImpl implements DataGenerator {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CustomerDemographicsDao customerDemographicsDao;
	@Autowired
	private ShipperDao shipperDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private RegionDao regionDao;
	@Autowired
	private TerritoryDao territoryDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void generateCustomers(int n, int nDemographics) {
		for (int i = 0; i < n; i++) {
			Customer customer = new Customer();
			customer.setContactName(GenerationUtil.getContact());
			customer.setAddress(GenerationUtil.getAddress());
			customer.setCity(GenerationUtil.getCity());
			customer.setCompanyName(GenerationUtil.getCompany());
			customer.setContactTitle(GenerationUtil.getTitle());
			customer.setCountry(GenerationUtil.getCountry());
			customer.setCustomerDemographics(GenerationUtil.pickSome(customerDemographicsDao.getAll(), nDemographics));
			customer.setFax(GenerationUtil.getPhone());
			customer.setPhone(GenerationUtil.getPhone());
			customer.setRegion(GenerationUtil.getRegion());
			customer.setPostalCode(GenerationUtil.getPostalCode());
			customerDao.save(customer);
		}
	}

	@Override
	public void generateShippers(int size) {
		for (int i = 0; i < size; i++) {
			Shipper shipper = new Shipper();
			shipper.setCompanyName(GenerationUtil.getCompany());
			shipper.setPhone(GenerationUtil.getPhone());
			shipperDao.save(shipper);
		}

	}

	@Override
	public void generateOrders(int size) {
		for (int i = 0; i < size; i++) {
			Order order = new Order();
			order.setEmployee(GenerationUtil.pickOne(employeeDao.getAll()));
			order.setFreight(GenerationUtil.nextDouble());
			Date orderdate = GenerationUtil.getOrderDate();
			order.setOrderDate(orderdate);
			Date reqDate = GenerationUtil.getOrderDate();
			while (orderdate.after(reqDate)) {
				reqDate = GenerationUtil.getOrderDate();
			}
			order.setRequiredDate(reqDate);
			order.setShipAddress(GenerationUtil.getAddress());
			order.setShipCity(GenerationUtil.getCity());
			order.setShipCountry(GenerationUtil.getCountry());
			order.setShipName(GenerationUtil.getContact());
			if (GenerationUtil.nextBoolean()) {
				Date shippedDate = GenerationUtil.getOrderDate();
				while (orderdate.after(shippedDate)) {
					shippedDate = GenerationUtil.getOrderDate();
				}
				order.setShippedDate(shippedDate);
			}
			order.setShipper(GenerationUtil.pickOne(shipperDao.getAll()));
			order.setShipPostalCode(GenerationUtil.getPostalCode());
			order.setShipRegion(GenerationUtil.getRegion());
			for (int k = 0; k < GenerationUtil.nextInt(20); k++) {
				OrderDetails od = new OrderDetails();
				od.setDiscount(GenerationUtil.nextInt(40) / 100.0);
				od.setProduct(GenerationUtil.pickOne(productDao.getAll()));
				od.setQuantity(GenerationUtil.nextInt(100) + 1);
				od.setUnitPrice(GenerationUtil.nextDouble());
				order.addOrderDetails(od);
			}
			orderDao.save(order);
			Customer cust = GenerationUtil.pickOne(customerDao.getAll());
			cust.addOrder(order);
			customerDao.save(cust);
		}
	}

	@Override
	public void generateCategories(int size) {
		for (int i = 0; i < size; i++) {
			Category category = new Category();
			category.setCategoryName(GenerationUtil.getString(15));
			category.setDescription(GenerationUtil.getString(150));
			categoryDao.save(category);
		}
	}

	@Override
	public void generateProducts(int size) {
		for (int i = 0; i < size; i++) {
			Product product = new Product();
			product.setCategory(GenerationUtil.pickOne(categoryDao.getAll()));
			product.setDiscontinued(GenerationUtil.nextBoolean());
			product.setProductName(GenerationUtil.getString(20));
			product.setQuantityPerUnit(GenerationUtil.nextDouble());
			product.setReorderLevel(GenerationUtil.nextDouble());
			product.setSupplier(GenerationUtil.pickOne(supplierDao.getAll()));
			product.setUnitPrice(GenerationUtil.nextDouble());
			product.setUnitsInStock(GenerationUtil.nextInt(10000));
			product.setUnitsOnOrder(GenerationUtil.nextInt(1000));
			productDao.save(product);
		}
	}

	@Override
	public void generateSuppliers(int size) {
		for (int i = 0; i < size; i++) {
			Supplier supplier = new Supplier();
			supplier.setAddress(GenerationUtil.getAddress());
			supplier.setCity(GenerationUtil.getCity());
			supplier.setCompanyName(GenerationUtil.getCompany());
			supplier.setContactName(GenerationUtil.getContact());
			supplier.setContactTitle(GenerationUtil.getTitle());
			supplier.setCountry(GenerationUtil.getCountry());
			supplier.setFax(GenerationUtil.getPhone());
			supplier.setHomePage(GenerationUtil.getWww());
			supplier.setPhone(GenerationUtil.getPhone());
			supplier.setPostalCode(GenerationUtil.getPostalCode());
			supplier.setRegion(GenerationUtil.getRegion());
			supplierDao.save(supplier);
		}

	}

	@Override
	public void generateEmployees(int size) {
		for (int i = 0; i < size; i++) {
			Employee employee = new Employee();
			employee.setAddress(GenerationUtil.getAddress());
			employee.setBirthDate(GenerationUtil.getBirthDate());
			employee.setCity(GenerationUtil.getCity());
			employee.setFirstName(GenerationUtil.getName());
			employee.setHireDate(new Date());
			employee.setLastName(GenerationUtil.getSurname());
			employee.setPostalCode(GenerationUtil.getPostalCode());
			if (employeeDao.getAll().size() != 0) {
				employee.setSupervisor(GenerationUtil.pickOne(employeeDao.getAll()));
			}
			employee.setTerritories(GenerationUtil.pickSome(territoryDao.getAll(), 4));
			employee.setTitle(GenerationUtil.getTitle());
			employee.setTitleOfCourtesy(GenerationUtil.getTitle());
			employeeDao.save(employee);
		}
	}

	@Override
	public void generateTerritoriesAndRegions(int size) {
		for (int i = 0; i < size; i++) {
			Region region = new Region();
			region.setRegionDescription(GenerationUtil.getString(200));
			regionDao.save(region);
		}

		for (int i = 0; i < size; i++) {
			Territory territory = new Territory();
			territory.setTerritoryDescription(GenerationUtil.getString(200));
			territory.setRegion(GenerationUtil.pickOne(regionDao.getAll()));
			territoryDao.save(territory);
		}
	}

	@Override
	public void generateDatabase(double scalingFactor) {
		generateCustomerDemographics((int) (10 * scalingFactor));
		generateCustomers((int) (300 * scalingFactor), (int) (5 * scalingFactor));
		generateShippers((int) (10 * scalingFactor));
		generateCategories((int) (50 * scalingFactor));
		generateSuppliers((int) (70 * scalingFactor));
		generateProducts((int) (100 * scalingFactor));
		generateTerritoriesAndRegions((int) (50 * scalingFactor));
		generateEmployees((int) (20 * scalingFactor));
		generateOrders((int) (1000 * scalingFactor));
	}

	@Override
	public void generateCustomerDemographics(int size) {
		for (int i = 0; i < size; i++) {
			CustomerDemographics cd = new CustomerDemographics();
			cd.setCustomerDesc(GenerationUtil.getString(200));
			customerDemographicsDao.save(cd);
		}
	}
}
