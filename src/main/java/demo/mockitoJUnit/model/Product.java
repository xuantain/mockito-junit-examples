package demo.mockitoJUnit.model;

public class Product {

	public Product(){}
	
	public Product(String _id, String _name, String _cat){
		this.id = _id;
		this.name = _name;
		this.catID = _cat;
	}
	
	private String id;
	private String name;
	private String catID;

	public String getId() {
		return id;
	}
	public void setId(String _id) {
		this.id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		this.name = _name;
	}	
	public String getCatID() {
		return catID;
	}
	public void setCatID(String _catID) {
		this.catID = _catID;
	}
	
}
