package com.app.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.ProductDto;
import com.app.entity.Product;
import com.app.service.ProductService;


@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/product")

@RestController()
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct/{catid}")
	@ResponseBody
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto product ,@PathVariable int catid) 
	{
//		System.out.println(product.getProductName());
		ProductDto saveProduct=productService.saveProduct(product,catid);
		return new ResponseEntity<ProductDto>(saveProduct, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllProduct() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@GetMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}

	@PostMapping("/editProduct/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id) {
		return new ResponseEntity<>(productService.editProduct(product, id), HttpStatus.CREATED);
	}

}