package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart1{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="id")
	private Product product;
	private int qty;
	
	public Cart1() {
		// TODO Auto-generated constructor stub
//		this.qty=1;
	}
	
	public int getId() {
		return cartid;
	}
	public void setId(int id) {
		this.cartid = id;
	}
	public User getUser() {
		return user;
	}
	public void setCustomer(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Cart1 [id=" + cartid + ", user=" +user + ", product=" + product + ", qty=" + qty + "]";
	}

	
	
	
}
