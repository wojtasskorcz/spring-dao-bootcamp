package pl.edu.agh.bd.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Region")
public class Region {
	
	private Long regionId;
	private String regionDescription;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getRegionId() {
		return regionId;
	}
	
	@Column
	public String getRegionDescription() {
		return regionDescription;
	}
	
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Region && this.regionId.equals(((Region) obj).regionId);
	}

	@Override
	public int hashCode() {
		return regionId.intValue();
	}
}
