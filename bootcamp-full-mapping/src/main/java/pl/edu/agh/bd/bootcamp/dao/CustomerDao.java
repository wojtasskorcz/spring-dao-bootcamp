package pl.edu.agh.bd.bootcamp.dao;

import java.util.List;

import pl.edu.agh.bd.bootcamp.model.Customer;

public interface CustomerDao {

	void save(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> getAll();
}
