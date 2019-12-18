package io.isr.customer_profile.controllers;

import io.isr.customer_profile.dto.UserDto;
import io.isr.customer_profile.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomerController{
	@Autowired
	private FeignService feignService;
	
	@GetMapping("/info")
	public UserDto getUser(HttpServletRequest request){
		String token = request.getHeader("Authorization").substring(7);
		return feignService.getUser(token);
	}
}

