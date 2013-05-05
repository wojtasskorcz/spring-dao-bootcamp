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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	private Long orderId;
	private Customer customer;
	private Employee employee;
	private Shipper shipper;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private Double freight;
	private String shipName;
	private String shipAddress;
	private String shipCity;
	private String shipRegion;
	private String shipPostalCode;
	private String shipCountry;
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getOrderId() {
		return orderId;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orderId")
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}

	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployee() {
		return employee;
	}
	
	@ManyToOne
	@JoinColumn(name = "shipVia")
	public Shipper getShipper() {
		return shipper;
	}

	@Column
	public Date getOrderDate() {
		return orderDate;
	}

	@Column
	public Date getRequiredDate() {
		return requiredDate;
	}

	@Column
	public Date getShippedDate() {
		return shippedDate;
	}

	@Column
	public Double getFreight() {
		return freight;
	}

	@Column
	public String getShipName() {
		return shipName;
	}

	@Column
	public String getShipAddress() {
		return shipAddress;
	}

	@Column
	public String getShipCity() {
		return shipCity;
	}

	@Column
	public String getShipRegion() {
		return shipRegion;
	}

	@Column
	public String getShipPostalCode() {
		return shipPostalCode;
	}

	@Column
	public String getShipCountry() {
		return shipCountry;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Order && this.orderId.equals(((Order) obj).orderId);
	}

	@Override
	public int hashCode() {
		return orderId.intValue();
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void addOrderDetails(OrderDetails orderDetails) {
		this.orderDetails.add(orderDetails);
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
}
