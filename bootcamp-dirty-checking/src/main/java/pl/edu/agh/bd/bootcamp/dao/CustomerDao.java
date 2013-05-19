package pl.edu.agh.bd.bootcamp.dao;

import java.util.List;

import pl.edu.agh.bd.bootcamp.model.Customer;

public interface CustomerDao extends GenericDao<Customer> {
	public List<Customer> getByContactName(String name);
}
