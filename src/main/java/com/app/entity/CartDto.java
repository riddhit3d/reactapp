package com.app.entity;



import java.util.HashSet;
import java.util.Set;

import com.app.dto.UserDto;

import jakarta.persistence.OneToOne;

public class CartDto {
	private int cartId;
	private Set<CartItemDto>  items=new HashSet<>();
  private UserDto user;
	public CartDto(int cartId, Set<CartItemDto> items, UserDto user) {
	super();
	this.cartId = cartId;
	this.items = items;
	this.user = user;
}
	public UserDto getUser() {
	return user;
}
public void setUser(UserDto user) {
	this.user = user;
}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Set<CartItemDto> getItems() {
		return items;
	}
	public void setItems(Set<CartItemDto> items) {
		this.items = items;
	}
}
