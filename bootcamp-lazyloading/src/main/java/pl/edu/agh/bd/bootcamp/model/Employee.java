package pl.edu.agh.bd.bootcamp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {
	
	private Long employeeId;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private Date birthDate;
	private Date hireDate;
	private String address;
	private String city;
	private String postalCode;
	private List<Territory> territories = new ArrayList<Territory>();
	private Employee supervisor;
	private List<Employee> subordinates = new ArrayList<Employee>();
	private List<Order> orders = new ArrayList<Order>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getEmployeeId() {
		return employeeId;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
        name="EmployeeTerritories",
        joinColumns=@JoinColumn(name="employeeId"),
        inverseJoinColumns=@JoinColumn(name="territoryId")
    )
	public List<Territory> getTerritories() {
		return territories;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supervisor")
	public Employee getSupervisor() {
		return supervisor;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "supervisor")
	public List<Employee> getSubordinates() {
		return subordinates;
	}
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
	public List<Order> getOrders() {
		return orders;
	}

	@Column
	public String getLastName() {
		return lastName;
	}

	@Column
	public String getFirstName() {
		return firstName;
	}

	@Column
	public String getTitle() {
		return title;
	}

	@Column
	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}

	@Column
	public Date getBirthDate() {
		return birthDate;
	}

	@Column
	public Date getHireDate() {
		return hireDate;
	}

	@Column
	public String getAddress() {
		return address;
	}

	@Column
	public String getCity() {
		return city;
	}

	@Column
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setEmployeeId(Long id) {
		this.employeeId = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleOfCourtesy(String titleOfCourtesy) {
		this.titleOfCourtesy = titleOfCourtesy;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTerritories(List<Territory> territories) {
		this.territories = territories;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Employee && this.employeeId.equals(((Employee) obj).employeeId);
	}

	@Override
	public int hashCode() {
		return employeeId.intValue();
	}

}
