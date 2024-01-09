package com.app.controller;



import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.entity.CartDto;
import com.app.entity.IntemRequest;
import com.app.service.CartService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	 public CartController(CartService cartService) {
	        this.cartService = cartService;
	    }

	@PostMapping("/")
	public ResponseEntity<CartDto> addToCart(@org.springframework.web.bind.annotation.RequestBody IntemRequest intemRequest,UserDto user){
		  String email=user.getEmail();

		  System.out.println(email);
	
	  CartDto addItem= this.cartService.addItem(intemRequest,user.getEmail());
	return new ResponseEntity<CartDto>(addItem,HttpStatus.OK);
}
	
	//create method for getting cart
	@GetMapping("/")
	public ResponseEntity<CartDto>getAllCart(Principal principal){
		    CartDto getcartAll = this.cartService.getcartAll(principal.getName());
		return new ResponseEntity<CartDto>(getcartAll,HttpStatus.ACCEPTED);
	}
	@GetMapping("/{cartId}")
	public ResponseEntity<CartDto>getCartById(@PathVariable  int cartId){
		
		System.out.println(cartId);
		CartDto cartByID = this.cartService.getCartByID(cartId);
		return new ResponseEntity<CartDto>(cartByID,HttpStatus.OK);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<CartDto>deleteCartItemFromCart(@PathVariable int pid,Principal p){
		
		CartDto remove = this.cartService.removeCartItemFromCart(p.getName(),pid);
		return new ResponseEntity<CartDto>(remove,HttpStatus.UPGRADE_REQUIRED);
	}



	  
	}
	
