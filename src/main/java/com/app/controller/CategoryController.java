package com.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.Product;
//import com.app.repo.ApiResponse;
import com.app.repo.CategoryRepository;
import com.app.service.CategoryService;

//@RestController
//@RequestMapping("/categories")
//public class CategoryController {
//@Autowired
//private CategoryService catService;
//private CategoryRepository categoryrepo;

//
//@PostMapping("/saveCategory")
//
//public ResponseEntity<Category>saveCategory(@RequestBody Category category)
//{
////Category save =this.catService.saveCategory(category);
////return new ResponseEntity<Category>(save,HttpStatus.ACCEPTED);
////}
//	return new ResponseEntity<>(catService.saveCategory(category), HttpStatus.CREATED);
//}
//
//@PostMapping("/editCategory/{id}")
//
//public ResponseEntity<Category>Update(Category category, int catId){
//
//	Category Update =this.catService.Update(category, catId);
//	return new ResponseEntity<Category>(Update,HttpStatus.ACCEPTED);
//	}
////public ResponseEntity<ApiResponse>Delete(@PathVariable int catId){
////	
//////	Category Delete =this.catService.deleteCategory(catId);
//////	return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted succsessfully",true),HttpStatus.ACCEPTED);
//////	}
////
//////get
//	
//	@GetMapping("/{catId}")
//	
//public ResponseEntity<Category>getCategoryById(@PathVariable int catId){
//	Category getbyId = this.catService.getCategoryById(catId);
//	return new ResponseEntity<Category>(getbyId,HttpStatus.OK);
//}
//@GetMapping("/categoryall")
////
////public ResponseEntity<List<Category>>getAllCategory(Category category){
////	List<Category>all = this.catService.getAllCategory();
////	return new ResponseEntity<List<Category>>(all,HttpStatus.OK);
////}
//
//public ResponseEntity<?> getAllCategory() {
//	return new ResponseEntity<>(catService.getAllCategory(), HttpStatus.OK);
//}
//
//
//@GetMapping("/deleteCategory/{catId}")
//public ResponseEntity<?> deleteCategory(@PathVariable Integer catId) {
//	return new ResponseEntity<>(catService.deleteCategory(catId), HttpStatus.OK);
//}
//
//
//@GetMapping("/addCategory")
//@RequestMapping(method = RequestMethod.GET)
//public ResponseEntity<Category> addCategory(@RequestBody Category Category) {
//    try {
//        Category categoryObj = categoryrepo.save(Category);
//        return new ResponseEntity<>(categoryObj, HttpStatus.CREATED);
//    } catch (Exception e) {
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//
//
//
//@GetMapping("/cat")
//public ResponseEntity<?> getAllCategory1() {
//	return new ResponseEntity<>(catService.getAllCategory(), HttpStatus.OK);
//}
//






@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/categories")

//@CrossOrigin(origins = "http://localhost:3000")
@RestController()
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/saveCategory")
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllCategory() {
		return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
	}

	@GetMapping("catbyid/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer catid) {
		return new ResponseEntity<>(categoryService.getCategoryById(catid), HttpStatus.OK);
	}
//
//	@DeleteMapping("/deleteCategory/{id}")
//	public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
//		return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
//	}

//	@PostMapping("/editProduct/{id}")
//	public ResponseEntity<?> editProduct(@RequestBody Category category, @PathVariable Integer catid) {
//		return new ResponseEntity<>(categoryService.editCategory(category, catid), HttpStatus.CREATED);
//	}


	@GetMapping("/deleteCategory/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer categoryId) {
		return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
	}

}




