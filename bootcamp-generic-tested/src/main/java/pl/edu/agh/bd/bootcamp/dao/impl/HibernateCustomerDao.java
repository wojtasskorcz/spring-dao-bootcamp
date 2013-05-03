package pl.edu.agh.bd.bootcamp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.model.Customer;

@Transactional
@Repository("customerDao")
public class HibernateCustomerDao extends HibernateGenericDao<Customer> implements CustomerDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getByContactName(String name) {
		return (List<Customer>) getHibernateTemplate().find("from Customer where contactName = '" + name + "'");
	}
}
