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
@Table(name = "OrderDetails")
public class OrderDetails {
	private Product product;
	private Double unitPrice;
	private Integer quantity;
	private Double discount;
	private Long orderDetailsId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return product;
	}

	@Column
	public Integer getQuantity() {
		return quantity;
	}

	@Column
	public Double getUnitPrice() {
		return unitPrice;
	}

	@Column
	public Double getDiscount() {
		return discount;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setOrderDetailsId(Long id) {
		this.orderDetailsId = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof OrderDetails && this.orderDetailsId.equals(((OrderDetails) obj).orderDetailsId);
	}

	@Override
	public int hashCode() {
		return orderDetailsId.intValue();
	}
}
