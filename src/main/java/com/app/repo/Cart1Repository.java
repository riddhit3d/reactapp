package com.app.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Cart1;
import com.app.entity.Product;
import com.app.entity.User;


@Repository
public interface Cart1Repository extends JpaRepository<Cart1, Integer> {

	List<Cart1> findByUser(User user);
	Cart1 findByUserAndProduct(User user,Product product);
	void deleteByUser(User user);
}

