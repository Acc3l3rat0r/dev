package io.isr.customer_profile.controllers;

import io.isr.customer_profile.dto.UserDto;
import io.isr.customer_profile.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController{
	@Autowired
	private FeignService feignService;
	
	@GetMapping("/info/{token}")
	public UserDto getUser(@PathVariable String token){
		return feignService.getUser(token);
	}
}

