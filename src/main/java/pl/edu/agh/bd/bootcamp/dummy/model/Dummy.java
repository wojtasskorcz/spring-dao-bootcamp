package pl.edu.agh.bd.bootcamp.dummy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dummy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private Integer age;
	
	public Dummy() {
	}
	
	public Dummy(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s (%s)", name, surname, age);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
