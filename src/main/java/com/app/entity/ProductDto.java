package com.app.entity;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String productName;

	private String description;

	private Double price;
	private Double quantity;

	public ProductDto(Integer id, String productName, String description, Double price, Double quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

//	public Integer getId() {
//		return id;
//	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + "]";
	}

//	public Integer getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setCategory(Category cat) {
		// TODO Auto-generated method stub
		
	}
}
