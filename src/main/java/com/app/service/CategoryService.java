package com.app.service;

//package com.cybage.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cybage.entity.Category;
//import com.cybage.entity.Product;
//import com.cybage.repo.CategoryRepository;
//import com.cybage.service.CategoryServiceIn;
//@Service
//public class CategoryService implements CategoryServiceIn{
//	@Autowired
//	private CategoryRepository categoryRepo;
////	private Category category;
////
////@Overrirde
////	public Category Update(Category  c,Integer catId) {
////		// TODO Auto-generated method stub
////		Category oldCategory = categoryRepo.findById(catId).get();
////
////		oldCategory.setCategoryId(c.getCategoryId());
////		oldCategory.setTitle(c.getTitle());
////	
////		return categoryRepo.save(oldCategory);
////	}
//	
//	@Override
//	public List<Category> getAllCategory() {
//		// TODO Auto-generated method stub
//		return categoryRepo.findAll();
//	}
//
//	@Override
//	public Category getCategoryById(Integer catId) {
//		// TODO Auto-generated method stub
//		return categoryRepo.findById(catId).get();
//
//	}
//
//	@Override
//	public String deleteCategory(Integer catId) {
//		// TODO Auto-generated method stub
//		Category category = categoryRepo.findById(catId).get();
//
//		if (category != null) {
//			categoryRepo.delete(category);
//			return "category Delete Sucessfully";
//		}
//
//		return "Something wrong on server";
//	}
//
//	
//
//	@Override
//	public Category saveCategory(Category category) {
//		return category.save(category);
//
//
//		
//
//	}
//
//	@Override
//	public Category Update(Category c, Integer catId) {
//		
//	Category oldCategory = categoryRepo.findById(catId).get();
//	
//		oldCategory.setCategoryId(c.getCategoryId());
//			oldCategory.setTitle(c.getTitle());
//	
//			return categoryRepo.save(oldCategory);
//		}
//	}
//
//	
//
//





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.repo.CategoryRepository;
import com.app.repo.ProductRepository;


@Service
public class CategoryService implements CategoryServiceIn{
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Category saveCategory(Category category) {

		return categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepo.findById(id).get();
	}

	@Override
	public String deleteCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).get();

		if (category != null) {
			categoryRepo.delete(category);
			return "CATEGORY Delete Sucessfully";
		}

		return "Something wrong on server";
	}

	@Override
	public Category Update(Category category, Integer catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category editCategory(Category p, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Category editCategory(Category p, Integer catid) {
//
//		Category oldCategory = categoryRepo.findById(catid).get();
//
//		oldCategory.setTitle(p.getTitle());
//
//		return categoryRepo.save(oldCategory);
//	}
//
//	@Override
//	public Category Update(Category category, Integer catId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}

