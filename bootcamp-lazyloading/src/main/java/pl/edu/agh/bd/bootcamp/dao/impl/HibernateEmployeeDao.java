package pl.edu.agh.bd.bootcamp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.EmployeeDao;
import pl.edu.agh.bd.bootcamp.model.Employee;

@Transactional
@Repository("employeeDao")
public class HibernateEmployeeDao extends HibernateGenericDao<Employee> implements EmployeeDao {

}