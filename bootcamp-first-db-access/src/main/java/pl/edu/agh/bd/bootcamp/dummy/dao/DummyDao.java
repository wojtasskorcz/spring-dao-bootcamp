package pl.edu.agh.bd.bootcamp.dummy.dao;

import java.util.List;

import pl.edu.agh.bd.bootcamp.dummy.model.Dummy;

public interface DummyDao {
	
	void save(Dummy dummy);
	void update(Dummy dummy);
	void delete(Dummy dummy);
	List<Dummy> getAll();
}
