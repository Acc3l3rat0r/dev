package io.isr.card.services;

import io.isr.card.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("authentication")
public interface FeignService {
	@GetMapping("/getUser/{token}")
	UserDto getUser(@PathVariable String token);
}
