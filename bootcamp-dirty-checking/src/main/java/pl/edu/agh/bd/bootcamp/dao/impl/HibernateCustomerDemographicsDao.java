package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.CustomerDemographicsDao;
import pl.edu.agh.bd.bootcamp.model.CustomerDemographics;

@Transactional
@Repository("customerDemographicsDao")
public class HibernateCustomerDemographicsDao extends HibernateGenericDao<CustomerDemographics> implements CustomerDemographicsDao {

}