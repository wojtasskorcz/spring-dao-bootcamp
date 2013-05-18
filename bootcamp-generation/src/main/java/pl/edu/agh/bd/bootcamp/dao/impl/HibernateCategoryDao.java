package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CategoryDao;
import pl.edu.agh.bd.bootcamp.model.Category;

@Transactional
@Repository("categoryDao")
public class HibernateCategoryDao extends HibernateGenericDao<Category> implements CategoryDao {

}
