package demo.mockitoJUnit.manager.impl;

import java.util.List;

import demo.mockitoJUnit.dao.CategoryDao;
import demo.mockitoJUnit.manager.CategoryManager;
import demo.mockitoJUnit.model.Category;
import demo.mockitoJUnit.model.Product;

public class CategoryManagerImpl implements CategoryManager{

	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> getCategories() {
		return categoryDao.getList();
	}

	public List<Product> getProducts(String id) {
		return categoryDao.getProductsByCatID(id);
	}
}
