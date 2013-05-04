package pl.edu.agh.bd.bootcamp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
	private Long orderId;
	private Long productId;
	private Double unitPrice;
	private Integer quantity;
	private Double discount;

	public Long getOrderId() {
		return orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
