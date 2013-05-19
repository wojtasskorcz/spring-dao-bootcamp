package pl.edu.agh.bd.bootcamp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.ProductDao;
import pl.edu.agh.bd.bootcamp.model.Product;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateTestSupport;

public class ProductTest extends CustomHibernateTestSupport {
	@Autowired
	private ProductDao productDao;

	@Before
	public void setUp() {
		Product product = new Product();
		product.setProductName("Szynka");
		productDao.save(product);
	}

	@Test
	@Transactional
	public void testGetAll() {
		assertEquals(1, productDao.getAll().size());
	}
}