package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.SupplierDao;
import pl.edu.agh.bd.bootcamp.model.Supplier;

@Transactional
@Repository("supplierDao")
public class HibernateSupplierDao extends HibernateGenericDao<Supplier> implements SupplierDao {

}