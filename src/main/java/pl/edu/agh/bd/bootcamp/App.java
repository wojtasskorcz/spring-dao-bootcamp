package pl.edu.agh.bd.bootcamp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.edu.agh.bd.bootcamp.dummy.dao.DummyDao;
import pl.edu.agh.bd.bootcamp.dummy.model.Dummy;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		
		DummyDao dummyDao = (DummyDao)appContext.getBean("dummyDao");
		
		Dummy d1 = new Dummy("Wojciech", "Grajewski", 21);
		Dummy d2 = new Dummy("Piotr", "Bryk", 21);
		dummyDao.save(d1);
		dummyDao.save(d2);
		
		List<Dummy> dummies = dummyDao.getAll();
		
		for (Dummy d : dummies) {
			System.out.println(d);
		}
	}	
}
