package com.app.entity;



public class IntemRequest {
	private int productId;
	private int quantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public IntemRequest(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public IntemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
