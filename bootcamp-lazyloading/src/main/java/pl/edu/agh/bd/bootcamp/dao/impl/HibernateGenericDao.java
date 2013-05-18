package pl.edu.agh.bd.bootcamp.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import pl.edu.agh.bd.bootcamp.dao.GenericDao;
import pl.edu.agh.bd.bootcamp.util.CustomHibernateDaoSupport;

public abstract class HibernateGenericDao<T> extends CustomHibernateDaoSupport implements GenericDao<T> {

	private Class<T> type;

	@SuppressWarnings("unchecked")
	public HibernateGenericDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);

	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);

	}

	@Override
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(type);
	}
}
