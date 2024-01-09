package com.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CartItem {
	@Id
	private int cartItemId;
	private int quantiy;
	private double totalprice;
	@ManyToOne
	private Cart cart;
	@OneToOne
	private Product product;
public Product getProduct() {
		return product;
	}
	public CartItem() {
	super();
	// TODO Auto-generated constructor stub
}
	public CartItem(int cartItemId, int quantiy, double totalprice, Cart cart, Product product) {
	super();
	this.cartItemId = cartItemId;
	this.quantiy = quantiy;
	this.totalprice = totalprice;
	this.cart = cart;
	this.product = product;
}
	public void setProduct(Product product) {
		this.product = product;
	}
	//	public CartItem(int cartItemId, int quantiy, double totalprice, Cart cart) {
//		super();
//		this.cartItemId = cartItemId;
//		this.quantiy = quantiy;
//		this.totalprice = totalprice;
//		this.cart = cart;
//	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart2) {
		this.cart = cart2;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public void add(CartItem cartItem) {
		// TODO Auto-generated method stub
		
	}
	
	

}
