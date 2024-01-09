package com.app.service;

import java.util.List;

import com.app.entity.Product;
import com.app.entity.ProductDto;


public interface ProductService {

	

	public List<Product> getAllProduct();

	public Product getProductById(Integer id);

	public String deleteProduct(Integer id);

	public Product editProduct(Product product,Integer id);

	public ProductDto saveProduct(ProductDto product, int catid);

	Product saveProduct(Product product, int catid);

	
}