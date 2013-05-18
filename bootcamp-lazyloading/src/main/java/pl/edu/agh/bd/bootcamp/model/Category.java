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
@Table(name = "Categories")
public class Category {
	
	private Long categoryId;
	private List<Product> products = new ArrayList<Product>();
	private String categoryName;
	private String description;
	private String picture;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getCategoryId() {
		return categoryId;
	}
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")
	public List<Product> getProducts() {
		return products;
	}
	
	@Column
	public String getCategoryName() {
		return categoryName;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	
	@Column
	public String getPicture() {
		return picture;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Category && this.categoryId.equals(((Category) obj).categoryId);
	}

	@Override
	public int hashCode() {
		return categoryId.intValue();
	}

}
