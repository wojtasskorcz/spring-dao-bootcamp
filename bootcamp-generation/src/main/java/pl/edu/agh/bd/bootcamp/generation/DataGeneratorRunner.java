package pl.edu.agh.bd.bootcamp.generation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataGeneratorRunner {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		DataGenerator dataGenerator = (DataGenerator) appContext.getBean("dataGenerator");
		dataGenerator.generateDatabase(1);
	}
}
