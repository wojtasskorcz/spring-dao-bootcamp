package pl.edu.agh.bd.bootcamp;

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

	@Transactional
	public void incrementQuantity() {		
		OrderDetails od = odDao.getAll().get(0);
		System.out.println(od.getQuantity());
		od.setQuantity(od.getQuantity() + 1);
		
		od = odDao.getAll().get(0);
		System.out.println(od.getQuantity());
	}
}
