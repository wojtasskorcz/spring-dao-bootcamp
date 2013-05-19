package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.OrderDao;
import pl.edu.agh.bd.bootcamp.model.Order;

@Transactional
@Repository("orderDao")
public class HibernateOrderDao extends HibernateGenericDao<Order> implements OrderDao {
}
