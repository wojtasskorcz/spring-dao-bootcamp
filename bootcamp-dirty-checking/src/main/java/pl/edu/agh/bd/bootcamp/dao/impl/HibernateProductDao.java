package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.ProductDao;
import pl.edu.agh.bd.bootcamp.model.Product;

@Transactional
@Repository("productDao")
public class HibernateProductDao extends HibernateGenericDao<Product> implements ProductDao {
}
