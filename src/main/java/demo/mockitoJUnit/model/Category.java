package demo.mockitoJUnit.model;

public class Category {

	public Category(){}
	
	public Category(String _id, String _name){
		this.id = _id;
		this.name = _name;
	}
	
	private String id;
	private String name;
	
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
	
}
