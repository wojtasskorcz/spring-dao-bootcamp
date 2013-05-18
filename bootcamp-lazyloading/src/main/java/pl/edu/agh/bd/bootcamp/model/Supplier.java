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
@Table(name = "Suppliers")
public class Supplier {
	
	private Long supplierId;
	private List<Product> products = new ArrayList<Product>();
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
	private String homePage;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getSupplierId() {
		return supplierId;
	}
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "supplier")
	public List<Product> getProducts() {
		return products;
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

	@Column
	public String getCountry() {
		return country;
	}

	@Column
	public String getPhone() {
		return phone;
	}

	@Column
	public String getFax() {
		return fax;
	}

	@Column
	public String getHomePage() {
		return homePage;
	}
	
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Supplier && this.supplierId.equals(((Supplier) obj).supplierId);
	}

	@Override
	public int hashCode() {
		return supplierId.intValue();
	}

}
