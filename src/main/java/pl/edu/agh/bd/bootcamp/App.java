package pl.edu.agh.bd.bootcamp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.edu.agh.bd.bootcamp.dummy.bo.DummyBo;
import pl.edu.agh.bd.bootcamp.dummy.model.Dummy;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		
		DummyBo dummyBo = (DummyBo)appContext.getBean("dummyBo");
		
		Dummy d1 = new Dummy("Wojciech", "Grajewski", 21);
		Dummy d2 = new Dummy("Piotr", "Bryk", 21);
		dummyBo.save(d1);
		dummyBo.save(d2);
		
		List<Dummy> dummies = dummyBo.getAll();
		
		for (Dummy d : dummies) {
			System.out.println(d);
		}
	}	
}
