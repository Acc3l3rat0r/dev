package io.isr.customer_profile.service;

import io.isr.customer_profile.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("auth")
public interface FeignService {
	
	@GetMapping("/getUser/{token}")
	UserDto getUser(@PathVariable String token);
}
