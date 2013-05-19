package pl.edu.agh.bd.bootcamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.bd.bootcamp.dao.OrderDetailsDao;
import pl.edu.agh.bd.bootcamp.model.OrderDetails;

@Service("dirtyBean")
@Transactional
public class DirtyBean {
	
	@Autowired
	OrderDetailsDao odDao;
	
	@Autowired
	SessionFactory sf;

	@Transactional
	public void incrementQuantity() {		
		OrderDetails od = odDao.getAll().get(0);
		System.out.println(od.getQuantity());
		od.setQuantity(od.getQuantity() + 1);
		
		od = odDao.getAll().get(0);
		System.out.println(od.getQuantity());
	}
	
	@Transactional
	public void detachedIncrementQuantity() {
		Session s = sf.getCurrentSession();
		OrderDetails od = odDao.getAll().get(0);
		s.evict(od);
		System.out.println(od.getQuantity());
		od.setQuantity(od.getQuantity() + 1);
		
		od = odDao.getAll().get(0);
		System.out.println(od.getQuantity());
	}
}
