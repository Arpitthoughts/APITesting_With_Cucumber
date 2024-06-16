package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Apiresources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils {
	RequestSpecification req;

	ResponseSpecification resspec;
	Response res;
	static String place_id; 
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {

		// reqspec=new
		// RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();

		req = given().spec(setRequestSpecification()).body(TestDataBuild.AddPlacePayload(name, address, language));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {

		Apiresources apireso = Apiresources.valueOf(resource);
		
		System.out.println(apireso.getResources());

		if (method.equalsIgnoreCase("post"))
			res = req.when().post(apireso.getResources());
		else
			res = req.when().get(apireso.getResources());

	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res.then().spec(resspec).extract().response();

		assertEquals(res.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions

		// String resp=res.asString();
		// js= new JsonPath(resp);
		assertEquals(getJsonPathValue(res, key), expectedValue);
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		place_id = getJsonPathValue(res, "place_id");

		req = given().spec(setRequestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "Get");
		String actualName = getJsonPathValue(res, "name");

		assertEquals(actualName, expectedName);
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req=given().spec(setRequestSpecification()).body(TestDataBuild.deletePlacePayload(place_id));





	}

}
