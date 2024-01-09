package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Response;
import com.app.entity.Cart1;
import com.app.service.CartService1;


@CrossOrigin
@RestController
@RequestMapping("/api/cart")
public class CartController1 {

	@Autowired private CartService1 service;
	
	@PostMapping
	public ResponseEntity<?> saveItem(@RequestBody Cart1 cart1) {
		System.out.println(cart1);
		if(service.checkexist(cart1.getUser(), cart1.getProduct())) {
			return ResponseEntity.badRequest().body("Item already exists");
		}
		service.save(cart1);
		return Response.success("Item saved into cart");
	}
	
	@GetMapping("/updateqty")
	public ResponseEntity<?> updateQty(int cartid,int qty){
		service.updateQty(cartid, qty);
		return com.app.dto.Response.success("quantity updated");
	}
	
	@GetMapping("/r")
	public List<Cart1> listall(int userid){
		return service.findByuserid(userid);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") int id){
		service.deleteItem(id);
		return Response.success("item deleted successfully");
	}
}
