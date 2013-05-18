package pl.edu.agh.bd.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Shippers")
public class Shipper {
	
	private Long shipperId;
	private String companyName;
	private String phone;
	private List<Order> orders = new ArrayList<Order>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getShipperId() {
		return shipperId;
	}
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shipper")
	public List<Order> getOrders() {
		return orders;
	}
	
	@Column
	public String getCompanyName() {
		return companyName;
	}
	
	@Column
	public String getPhone() {
		return phone;
	}
	
	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Shipper && this.shipperId.equals(((Shipper) obj).shipperId);
	}

	@Override
	public int hashCode() {
		return shipperId.intValue();
	}
}
