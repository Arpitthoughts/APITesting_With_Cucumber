package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlacePojo;
import pojo.location;

public class TestDataBuild {

	public static AddPlacePojo AddPlacePayload(String name, String address, String language) {

		
		AddPlacePojo p = new AddPlacePojo();
		p.setAccuracy(50);
		p.setName(name);
		p.setAddress(address);
		p.setPhone_number("+91 983 748 8293");
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		
		List<String> al= new ArrayList<String>();
		al.add("shoe park");
		al.add("shop");
		p.setTypes(al);
		
		location l = new location();
		l.setLat(-38.383334);
		l.setLng(33.423362);
		
		p.setLocation(l);
		return p;
	}
	
	public static String deletePlacePayload(String place_id) {
		
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}\r\n"
				+ "";
				
	}

}