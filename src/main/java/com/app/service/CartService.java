package com.app.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//public Cart toEntity(CartDto cDto) { 
//	Cart c=new Cart();
//	c.setCartId(((CartDto) cDto).getCartId());
//	c.setItems(((CartDto)cDto).getItems());
//	
//	return c;
//}
import java.security.Principal;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.hibernate.ResourceClosedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Cart;
import com.app.entity.CartDto;
import com.app.entity.CartItem;
import com.app.entity.IntemRequest;
import com.app.entity.Product;
import com.app.entity.User1;
import com.app.exception.ResourceNotFoundException;
import com.app.repo.CartRepository;
import com.app.repo.ProductRepository;
import com.app.repo.UserRepository1;


@Service
public class CartService {
	
	@Autowired
private	UserRepository1 userRepo;
	@Autowired
 private ProductRepository productRepo;
 
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public CartDto addItem(IntemRequest item,String username){
		int productId=item.getProductId();
        int quantity=item.getQuantity();
        //fetch user
        User1 user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User not found"));
       //fetch Product 
       	Product product=this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
        	
       	//here we are checking product stock 
        if(!product.isStock()){
        	
        	new ResourceNotFoundException("Product Out of Stock");
        }
        
        // create cartItem with productId and Qnt
        
        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantiy(quantity);
//   double totaleprice=product.getPrice()*quantity;
//      cartItem.setTotalprice(totaleprice);
//        
        //getting cart from user
        Cart cart=user.getCart();
        
        if(cart==null) {
        	cart=new Cart();
        	//
        	cart.setUser(user);
        }
        
        cartItem.setCart(cart);
        
        Set<CartItem> items = cart.getItems();
        
        // here we check item is available in CartItem or not 
        // if CartItem is availabe then we inc Qnt only else
        // add new product in cartItem
        //
        // by default false
        	AtomicReference<Boolean> flag=new AtomicReference<>(false);
        	
        Set<CartItem> newproduct = items.stream().map((i)->{
          if(i.getProduct().getId()==product.getId()) {
        	  i.setQuantiy(quantity);
//    	  i.setTotalprice(totaleprice);
        	  flag.set(true);
          }
          return i;
          
        }).collect(Collectors.toSet());
        
        if(flag.get()){
        	items.clear();
        	items.addAll(newproduct);
        	
        }else {
        	cartItem.setCart(cart);
        	items.add(cartItem);
        }
        
        Cart saveCart = this.cartRepo.save(cart);
        
           
        
		return  this.modelMapper.map(saveCart,CartDto.class);
	}
	
	
	public CartDto getcartAll(String email){
		//find user
		User1 user = this.userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		//find cart
		    User1 cart= this.cartRepo.findByUser(user).orElseThrow(()->new ResourceNotFoundException("There is no cart"));
		
		    return this.modelMapper.map(cart,CartDto.class);
		
	}
	
	// get cart by CartId
	
	
	public CartDto getCartByID(int cartId){
		
		//User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User Not found"));
		
	    Cart findByUserAndcartId = this.cartRepo.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart not Found"));
		 
		return this.modelMapper.map(findByUserAndcartId,CartDto.class);
	}
	
	public CartDto removeCartItemFromCart(String userName, int id){
		User1 user=this.userRepo.findByEmail(userName).orElseThrow(()->new ResourceNotFoundException("User Not found"));
		
		Cart cart=user.getCart();
		Set<CartItem> items = cart.getItems();
		
		boolean removeIf = items.removeIf((i)->i.getProduct().getId()==id);
		Cart save = this.cartRepo.save(cart);
		System.out.println(removeIf);
		return this.modelMapper.map(save,CartDto.class);
	}
	
}




