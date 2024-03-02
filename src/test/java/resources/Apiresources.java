package resources;

//enum is a special class in java, it is a collection of constants or methods
//when goal is only to retrieve values then we can create enums

public enum Apiresources {
	
	Addplaceapi("/maps/api/place/add/json"),
	Getplaceapi("/maps/api/place/get/json"),
	Deleteplaceapi("/maps/api/place/delete/json");
	private String resource;
	

	Apiresources(String resources) {
		
		this.resource=resources;
		
	}
	
	public String getResources(){
		return resource;
	}
	

}
