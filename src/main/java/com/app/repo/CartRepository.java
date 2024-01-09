package com.app.repo;



import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.entity.User;
import com.app.entity.User1;
import com.app.entity.Cart;
@JavaBean
@Component
@Repository
public interface CartRepository extends JpaRepository< Cart,Integer>{

 public List<Cart> findByUser1(User1 user);

public Optional<User1> findByUser(User1 user);






	
}
