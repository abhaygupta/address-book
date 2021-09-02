ADDRESS BOOK - Project details

1. Gives you two interface to interact with pager duty user-api 
	a. List Users
	b. Get User details 
2. Library can be consumed using UserService it exposes two api calls
	- Users list(final ListUserRequest request) 
	- Users getDetails(final GetUserDetailRequest request)
3. Model for library are defined in package and accessible for consumption by clients
	- com.pagerduty.adress_book.model
4. API request can be found in package com.pagerduty.adress_book.request
	- GetUserDetailRequest
	- ListUserRequest
5. Properties to interact with PagerDuty APIs are configured in application.properties (namely base server url, and test token)


Compilation and Running tests

1. To compile you will need:
    1. Maven - 3.3+
    2. Java - 1.8 +
    3. Access to internet (for downloading maven jars)
  
2. To compile you can run command line from directory - 
	`mvn clean install -DskipTests=true`  
	
3. To run tests, you can do 
   `mvn clean install`
   
4. Currently project has limited test due to time-limitation
    1. Unit tests for property service - PropertyServiceUnitTest.java
    2. Unit tests for user service - UserServiceUnitTest.java
    3. Integration test with real pager duty API - UserServiceIntegrationTest.java
    
