package demo.mockitoJUnit.dao;

import java.util.List;

import demo.mockitoJUnit.model.Category;
import demo.mockitoJUnit.model.Product;

public interface CategoryDao {
	
	List<Category> getList();
	List<Product> getProductsByCatID(String id);
}
