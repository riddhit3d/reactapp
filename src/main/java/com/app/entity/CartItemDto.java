package com.app.entity;



public class CartItemDto {
	private int cartItemId;
	private int quantity;
	private double totalprice;
	private CartDto cartDto;
	private ProductDto productDto;
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public CartDto getCartDto() {
		return cartDto;
	}
	public void setCartDto(CartDto cartDto) {
		this.cartDto = cartDto;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	

}
