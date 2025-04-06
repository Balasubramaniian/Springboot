package com.complaintProject;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.complaintProject.Model.User;

public class RestClient {

	 private static final String GET_USER_URL = "http://localhost:8080/user/get";
	 private static final String POST_USER_URL = "http://localhost:8080/user/create";
	 private static RestTemplate restTemplate = new RestTemplate();
	 
	 
	 public static void main(String[] args) {
		 
		 RestClient client=new RestClient();
		 //client.createUsers();
		 client.getUsers();
	 }
	 
	 public void getUsers() {

	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

	        ResponseEntity<String> response = restTemplate.exchange(GET_USER_URL,HttpMethod.GET,entity, String.class);
	        System.out.println("Users List: " + response.getBody());
	        
	        
	 }
	 public void createUsers() {
		 User user=new User(null,"maniyan");
		 RestTemplate restTemplate = new RestTemplate();
	        User result = restTemplate.postForObject(POST_USER_URL, user, User.class);

	        System.out.println(result);
	 }
}
