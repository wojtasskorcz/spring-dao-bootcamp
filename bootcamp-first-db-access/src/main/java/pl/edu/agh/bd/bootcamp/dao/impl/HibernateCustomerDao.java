package pl.edu.agh.bd.bootcamp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDao;
import pl.edu.agh.bd.bootcamp.model.Customer;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateDaoSupport;

@Transactional
@Repository("customerDao")
public class HibernateCustomerDao extends CustomHibernateDaoSupport implements
		CustomerDao {

	public void save(Customer customer) {
		getHibernateTemplate().save(customer);
	}

	public void update(Customer customer) {
		getHibernateTemplate().update(customer);

	}

	public void delete(Customer customer) {
		getHibernateTemplate().delete(customer);

	}

	public List<Customer> getAll() {
		return getHibernateTemplate().loadAll(Customer.class);
	}
}
