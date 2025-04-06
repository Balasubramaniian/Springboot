package com.complaintProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.complaintProject.Model.User;

@SpringBootApplication
public class LearningDemoApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(LearningDemoApplication.class, args);
		User user=new User();
		user.setName("Balasubramaniyan");
		System.out.println("USer Details: "+user.getName() );
		
		
		
	}

}
