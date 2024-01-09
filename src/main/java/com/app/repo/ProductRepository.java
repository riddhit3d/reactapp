package com.app.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	ProductDto save(ProductDto product);
	Product save(Product product);
    Optional<Product> findById(Integer id);

}