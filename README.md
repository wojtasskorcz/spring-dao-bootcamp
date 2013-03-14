spring-dao-bootcamp
===================

Authors: Piotr Bryk & Wojciech Grajewski

Description
-------------------
This is the initial ("hello world") version. 
The database is purged at every execution (`<prop key="hibernate.hbm2ddl.auto">create</prop>`). 
So far you can only change the database dialect editing the file `src/main/resources/database/Hibernate.xml`, line:  
`<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>`


**IMPORTANT**  
Create a file `src/main/resources/properties/database.properties` after pulling. The template for the file is:

	jdbc.driverClassName=com.mysql.jdbc.Driver
	jdbc.dialect=org.hibernate.dialect.MySQLDialect
	jdbc.databaseurl=jdbc:mysql://localhost:3306/bootcamp
	jdbc.username=your_db_root
	jdbc.password=your_db_password
  
The `jdbc.dialect` parameter is so far ignored, I'm working on integrating it into other configuration files. 
Follow the notes above if you use a different database. In this case you also have to add a driver dependency for your database 
in the `pom.xml` file.

To check the installation correctness just run the application (the `main` method is in the `src/main/java/pl/edu/agh/bd/bootcamp/App.java`)

