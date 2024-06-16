package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void beforeScenario() throws IOException {
		
		stepDefinition m= new stepDefinition();
		if(m.place_id==null) {
		
		
		m.add_place_payload_with("Arpit", "637 Max Street Palace", "Norway");
		m.user_calls_with_http_request("Addplaceapi", "post");
		
		m.verify_place_id_created_maps_to_using("Arpit", "Getplaceapi");
			//new changes in remote branch
		}
		
		
	}

}
