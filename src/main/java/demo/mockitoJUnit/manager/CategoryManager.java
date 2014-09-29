package demo.mockitoJUnit.manager;

import java.util.List;

import demo.mockitoJUnit.model.Category;
import demo.mockitoJUnit.model.Product;

public interface CategoryManager {
	
	List<Category> getCategories();
	List<Product> getProducts(String id);
}
