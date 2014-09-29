package demo.mockitoJUnit.manager;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import demo.mockitoJUnit.dao.CategoryDao;
import demo.mockitoJUnit.manager.impl.CategoryManagerImpl;
import demo.mockitoJUnit.model.Category;
import demo.mockitoJUnit.model.Product;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryManagerTest {

    @InjectMocks
    private CategoryManagerImpl categoryManager;

    @Mock
    private CategoryDao categoryDao;

    private Map<String, Category> categoryMap = new HashMap<String, Category>();

    private Map<String, Category> createCategoryMap(int length) {
        Map<String, Category> quesMap = new HashMap<String, Category>();
        for (int i = 0; i < length; i++) {
            Category question = createCategory("Category_" + i, i);
            quesMap.put("Category_" + i, question);
        }
        return quesMap;
    }

    private Category createCategory(String id, int i) {
        Category category = new Category(id, "Category_" + i);
        return category;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryMap = createCategoryMap(10);
        when(categoryDao.getList()).thenAnswer(new Answer<List<Category>>() {

            public List<Category> answer(InvocationOnMock invocation)
                    throws Throwable {
                List<Category> newList = new ArrayList<Category>();
                for (int i = 0; i < categoryMap.size(); i++) {
                    newList.add(categoryMap.get("Category_" + i));
                }
                return newList;
            }
        });
    }

    @Test
    public void getCategorTest() {
        List<Category> list = categoryManager.getCategories();
        Assert.assertTrue(list.size() == 10);
    }

    @Test
    public void getProductsTest() {
    	when(categoryManager.getProducts(Mockito.anyString()))
    						.thenAnswer(new Answer<List<Product>>() {
			public List<Product> answer(InvocationOnMock invocation)
					throws Throwable {
				List<Product> listProduct = new ArrayList<Product>();
				for (int i = 0; i < 5; i++) {
					Product item = new Product("Product_" + i, "Product_" + i, 
											(String)invocation.getArguments()[0]);
					listProduct.add(item);
				}
				return listProduct;
			}
		});
    	String idTest = "Category_1";
        List<Product> listProduct = categoryManager.getProducts(idTest);
        Assert.assertTrue(listProduct.size() == 5);
    }
    
    @Test
    public void getProductsTest_NotFound() {
    	when(categoryManager.getProducts(Mockito.anyString()))
    						.thenAnswer(new Answer<List<Product>>() {
			public List<Product> answer(InvocationOnMock invocation)
					throws Throwable {
				throw new Exception("NotFound");
			}
		});
    	try{
	    	String idTest = "Category_999";
	        List<Product> listProduct = categoryManager.getProducts(idTest);
	        Assert.assertNull(listProduct);
    	}catch(Exception e){
    		Assert.assertEquals("NotFound",e.getMessage());
    	}
    }
}
