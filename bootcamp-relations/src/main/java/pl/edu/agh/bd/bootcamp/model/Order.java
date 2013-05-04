package pl.edu.agh.bd.bootcamp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	private Long orderId;
	private Long employeeId;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getOrderId() {
		return orderId;
	}

	@Column
	public Date getOrderDate() {
		return orderDate;
	}

	@Column
	public Long getEmployeeId() {
		return employeeId;
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

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
}
