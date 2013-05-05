package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.RegionDao;
import pl.edu.agh.bd.bootcamp.model.Region;

@Transactional
@Repository("regionDao")
public class HibernateRegionDao extends HibernateGenericDao<Region> implements RegionDao {

}
