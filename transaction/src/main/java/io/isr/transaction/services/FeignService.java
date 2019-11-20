package io.isr.transaction.services;

import io.isr.transaction.dto.TransferDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("card")
public interface FeignService {
	
	@PutMapping("/putMoney")
	ResponseEntity putMoney(@RequestBody TransferDto transferDto);
	
}
