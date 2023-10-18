package com.queryparams.hello_human_queryparams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class HelloHumanQueryParamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanQueryParamsApplication.class, args);
	}

	@RequestMapping("/")
	public String index(@RequestParam(value = "firstName", required = false) String firstName,
						@RequestParam(value = "lastName", required = false) String lastName,
						@RequestParam(value = "times", required = false, defaultValue = "1") int times) {

		StringBuilder result = new StringBuilder(); //old alternative to str.repeat() (V11 or newer of Java only)

		if (firstName == null && lastName == null) {
			result.append("Welcome: Please enter a name to the search bar");
		} else if (firstName != null && lastName == null) {
			result.append("You searched for: ").append(firstName);
		} else if (firstName == null && lastName != null) {
			result.append("You searched for: ").append(lastName);
		} else if (firstName != null && lastName != null) {
			result.append("You searched for: ").append(firstName).append(" ").append(lastName);
		} else {
			return "Did not meet requirements";
		}

		// Repeat the resulting string 'times' number of times
		StringBuilder repeatedResult = new StringBuilder();
		for (int i = 0; i < times; i++) {
			repeatedResult.append(result);
		}

		return repeatedResult.toString();
	}
}
