package pl.edu.agh.bd.bootcamp.dao;

import java.util.List;

public interface GenericDao<T> {

	public void save(T customer);

	public void update(T customer);

	public void delete(T customer);

	public List<T> getAll();
}
