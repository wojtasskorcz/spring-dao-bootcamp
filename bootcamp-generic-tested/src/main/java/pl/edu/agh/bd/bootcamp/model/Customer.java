package pl.edu.agh.bd.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
	private Long customerId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String phone;
	private String fax;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getCustomerId() {
		return customerId;
	}

	@Column
	public String getCompanyName() {
		return companyName;
	}

	@Column
	public String getContactName() {
		return contactName;
	}

	@Column
	public String getContactTitle() {
		return contactTitle;
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
	public String getRegion() {
		return region;
	}

	@Column
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String toString() {
		return "{customerId: " + customerId + ", contactName: " + contactName
				+ "}";
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getFax() {
		return fax;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
}
