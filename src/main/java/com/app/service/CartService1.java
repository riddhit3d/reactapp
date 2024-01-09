package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Cart1;
import com.app.entity.Product;
import com.app.entity.User;
import com.app.repo.Cart1Repository;

@Service
public class CartService1 {

	@Autowired private Cart1Repository repo;
	@Autowired private UserService userService;
	
	public void save(Cart1 wl) {
		repo.save(wl);
	}
	
	public List<Cart1> findByuserid(int id){
		return repo.findByUser(userService.findById(id));
	}
	
	public void updateQty(int cartid,int qty) {
		Cart1 c=repo.findById(cartid).get();
		c.setQty(qty);
		repo.save(c);
	}
	
	public void deleteItem(int id) {
		repo.deleteById(id);
	}
	
	public boolean checkexist(User user,Product product) {
		return repo.findByUserAndProduct(user, product)!=null;
	}
	
	public void clearCart(User user) {
		//repo.deleteByCustomer(cust);
		repo.deleteAll(repo.findByUser(user));
	}
	
}
