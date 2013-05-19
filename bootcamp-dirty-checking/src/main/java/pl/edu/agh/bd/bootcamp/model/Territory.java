package pl.edu.agh.bd.bootcamp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Territories")
public class Territory {
	
	private Long territoryId;
	private String territoryDescription;
	private Region region;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getTerritoryId() {
		return territoryId;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "regionId")
	public Region getRegion() {
		return region;
	}
	
	@Column
	public String getTerritoryDescription() {
		return territoryDescription;
	}
	
	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}
	
	public void setTerritoryDescription(String territoryDescription) {
		this.territoryDescription = territoryDescription;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Territory && this.territoryId.equals(((Territory) obj).territoryId);
	}

	@Override
	public int hashCode() {
		return territoryId.intValue();
	}

}
