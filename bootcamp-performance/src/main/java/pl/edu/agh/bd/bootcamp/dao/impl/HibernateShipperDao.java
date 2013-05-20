package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.ShipperDao;
import pl.edu.agh.bd.bootcamp.model.Shipper;

@Transactional
@Repository("shipperDao")
public class HibernateShipperDao extends HibernateGenericDao<Shipper> implements ShipperDao {

}
