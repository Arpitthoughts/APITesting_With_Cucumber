#Author: Arpit Arjaria

Feature: Validating Place API's

@Addplace @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceApi
Given Add Place Payload with "<name>" "<address>" "<language>"
When user calls "Addplaceapi" with "post" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "Getplaceapi"

Examples:
|name|address|language|
|Times Square|East 100 Road|Spanish|
#|Millions shade|Safex Area|English| 


@Deleteplace @Regression
Scenario: Verify if Delete Place functionality is working
Given DeletePlace Payload
When user calls "Deleteplaceapi" with "post" http request
Then the API call is success with status code 200
And  "status" in response body is "OK"


