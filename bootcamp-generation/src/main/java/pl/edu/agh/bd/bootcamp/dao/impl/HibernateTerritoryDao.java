package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.TerritoryDao;
import pl.edu.agh.bd.bootcamp.model.Territory;

@Transactional
@Repository("territoryDao")
public class HibernateTerritoryDao extends HibernateGenericDao<Territory> implements TerritoryDao {

}
