package pl.edu.agh.bd.bootcamp.dummy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dummy.dao.DummyDao;
import pl.edu.agh.bd.bootcamp.dummy.model.Dummy;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateDaoSupport;

@Transactional
@Repository("dummyDao")
public class HibernateDummyDao extends CustomHibernateDaoSupport implements DummyDao  {

	public void save(Dummy dummy){
		getHibernateTemplate().save(dummy);
	}
 
	public void update(Dummy dummy){
		getHibernateTemplate().update(dummy);
	}
 
	public void delete(Dummy dummy){
		getHibernateTemplate().delete(dummy);
	}
	
	public List<Dummy> getAll() {
		return getHibernateTemplate().loadAll(Dummy.class);
	}
}
