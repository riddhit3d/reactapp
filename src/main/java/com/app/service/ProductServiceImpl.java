package com.app.service;




import com.app.entity.ProductDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.ProductDto;
import com.app.repo.CategoryRepository;
import com.app.repo.ProductRepository;

import exception.RecordNotFoundException;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
//	private CategoryRepository catRepo;
	  private CategoryRepository catRepo;
	    @Autowired
	    public ProductServiceImpl(CategoryRepository catRepo){
	        this.catRepo = catRepo;
	    }
	
	
	public ProductDto  saveProduct(ProductDto productDto ,int catid) {
	Category cat = this.catRepo.findById(catid).orElseThrow(()->new RecordNotFoundException("this category id not found"));
    Product  product =toEntity(productDto);
   product.setCategory(cat);
    Product save =this.productRepo.save(product);
    ProductDto dto =toDto(save);
//		return productRepo.save(product);
    return dto;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepo.findById(id).get();

		if (product != null) {
			productRepo.delete(product);
			return "Product Delete Sucessfully";
		}

		return "Something wrong on server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {

		Product oldProduct = productRepo.findById(id).get();

		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());

		return productRepo.save(oldProduct);
	}
//
//	@Override
//	public Product saveProduct(Product product) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public Product toEntity(ProductDto pDto) { 
		Product p=new Product();
		p.setId(((ProductDto) pDto).getId());
		p.setProductName(pDto.getProductName());
		p.setDescription(pDto.getDescription());
		p.setPrice(pDto.getPrice());
		p.setQuantity(pDto.getQuantity());;
		return p;
	}

//	@Override
//	public Product saveProduct(Product product) {
//		// TODO Auto-generated method stub
////		return save;
//	}
	public ProductDto toDto(Product product) { 
		ProductDto pDto=new ProductDto();
		pDto.setId(product.getId());
		pDto.setProductName(product.getProductName());
		pDto.setDescription(product.getDescription());
		pDto.setPrice(product.getPrice());
		pDto.setQuantity(pDto.getQuantity());
		return pDto;
		
	}

@Override
public Product saveProduct(Product product, int catid) {
	// TODO Auto-generated method stub
	return null;
}
//
//@Override
//public ProductDto saveProduct(ProductDto product) {
//	// TODO Auto-generated method stub
//	return null;
}

