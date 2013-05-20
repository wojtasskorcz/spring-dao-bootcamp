package pl.edu.agh.bd.bootcamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformanceSample {
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		PerformanceBean bean = (PerformanceBean) appContext.getBean("performanceBean");
		bean.shippersCategories();
		bean.customersEmployeesRegions();
	}

}
