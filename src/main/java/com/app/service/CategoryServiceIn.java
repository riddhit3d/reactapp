package com.app.service;



import java.util.List;

import com.app.entity.Category;
import com.app.entity.Product;

public interface CategoryServiceIn {






	

	public List<Category> getAllCategory();

	public Category getCategoryById(Integer catId);

	public String deleteCategory(Integer categoryId);

	public Category Update(Category category,Integer catId);

	public Category saveCategory(Category Category);

	Category editCategory(Category p, Integer id);
	
}