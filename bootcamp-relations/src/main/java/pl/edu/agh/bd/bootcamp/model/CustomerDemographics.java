package pl.edu.agh.bd.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerDemographics")
public class CustomerDemographics {
	
	private Long customerTypeId;
	private String customerDesc;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getCustomerTypeId() {
		return customerTypeId;
	}

	@Column
	public String getCustomerDesc() {
		return customerDesc;
	}

	public void setCustomerTypeId(Long id) {
		this.customerTypeId = id;
	}

	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CustomerDemographics && 
				this.customerTypeId.equals(((CustomerDemographics) obj).customerTypeId);
	}

	@Override
	public int hashCode() {
		return customerTypeId.intValue();
	}

}
