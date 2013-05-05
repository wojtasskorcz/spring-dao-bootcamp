package pl.edu.agh.bd.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	private Long productId;
	private String productName;
	private Supplier supplier;
	private Category category;
	private Double quantityPerUnit;
	private Double unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Double reorderLevel;
	private Boolean discontinued;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getProductId() {
		return productId;
	}
	
	@ManyToOne
	@JoinColumn(name = "supplierId")
	public Supplier getSupplier() {
		return supplier;
	}
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return category;
	}

	@Column
	public String getProductName() {
		return productName;
	}

	@Column
	public Double getQuantityPerUnit() {
		return quantityPerUnit;
	}

	@Column
	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	@Column
	public Double getUnitPrice() {
		return unitPrice;
	}

	@Column
	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	@Column
	public Boolean getDiscontinued() {
		return discontinued;
	}

	@Column
	public Double getReorderLevel() {
		return reorderLevel;
	}

	public void setQuantityPerUnit(Double quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public void setReorderLevel(Double reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Product && this.productId.equals(((Product) obj).productId);
	}

	@Override
	public int hashCode() {
		return productId.intValue();
	}
}
