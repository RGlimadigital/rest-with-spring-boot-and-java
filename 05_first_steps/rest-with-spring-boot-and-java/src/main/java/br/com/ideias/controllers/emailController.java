package br.com.ideias.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ideias.UserEmail;

@RestController
public class emailController {
	
	private static final String emailTemplate = "E-mail: %s";
	private static final AtomicLong emailCounter = new AtomicLong();
	
	
	@RequestMapping("/useremail")
	public UserEmail userEmail(@RequestParam(value = "email", defaultValue = "user@email.com") String email) {
		
		return new UserEmail(emailCounter.incrementAndGet(), email);
	}

}
