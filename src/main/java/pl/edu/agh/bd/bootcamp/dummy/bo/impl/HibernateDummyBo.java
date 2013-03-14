package pl.edu.agh.bd.bootcamp.dummy.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dummy.bo.DummyBo;
import pl.edu.agh.bd.bootcamp.dummy.dao.DummyDao;
import pl.edu.agh.bd.bootcamp.dummy.model.Dummy;

@Transactional
@Service("dummyBo")
public class HibernateDummyBo implements DummyBo {

	@Autowired
	DummyDao dummyDao;	
	
	public void save(Dummy dummy){
		dummyDao.save(dummy);
	}
 
	public void update(Dummy dummy){
		dummyDao.update(dummy);
	}
 
	public void delete(Dummy dummy){
		dummyDao.delete(dummy);
	}
	
	public List<Dummy> getAll() {
		return dummyDao.getAll();
	}
	
}
