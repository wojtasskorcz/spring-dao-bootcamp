package pl.edu.agh.bd.bootcamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DirtyCheckingSample {
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		DirtyBean dirtyBean = (DirtyBean) appContext.getBean("dirtyBean");
		dirtyBean.incrementQuantity();
	}
}
