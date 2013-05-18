package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.OrderDetailsDao;
import pl.edu.agh.bd.bootcamp.model.OrderDetails;

@Transactional
@Repository("orderDetailsDao")
public class HibernateOrderDetailsDao extends HibernateGenericDao<OrderDetails> implements OrderDetailsDao {

}
