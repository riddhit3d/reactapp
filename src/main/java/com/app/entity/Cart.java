package com.app.entity;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer cartId;
@OneToMany
private Set<CartItem> items=new HashSet<>();
@OneToOne
private User1 user;

public Cart() {
	super();
	// TODO Auto-generated constructor stub
}
public Set<CartItem> getItems() {
	return items;
}
public void setItems(Set<CartItem> items) {
	this.items = items;
}public Cart(Integer cartId, Set<CartItem> items) {

	super();
	this.cartId = cartId;
	this.items = items;
}


public Integer getCartId() {
	return cartId;
}
public void setCartId(Integer cartId) {
	this.cartId = cartId;
}



public Object get() {
	// TODO Auto-generated method stub
	return null;
}
public void setUser(User1 user) {
	// TODO Auto-generated method stub
	this.user =user;
}


}
