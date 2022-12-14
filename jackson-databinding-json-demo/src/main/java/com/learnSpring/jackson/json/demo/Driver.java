package com.learnSpring.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map to java POJO:
			// data/sample-lite.json
			Student theStudent = 
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			System.out.println("Last name = " + theStudent.getAddress().getCity());
			for(String temp: theStudent.getLanguages()) {
				System.out.println(temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
