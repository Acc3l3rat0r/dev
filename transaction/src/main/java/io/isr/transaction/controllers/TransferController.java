package io.isr.transaction.controllers;

import io.isr.transaction.dto.TransferDto;
import io.isr.transaction.services.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
	
	@Autowired
	FeignService feignService;
	
	@PutMapping("/transfer")
	public ResponseEntity transfer(@RequestBody TransferDto transferDto){
		feignService.putMoney(transferDto);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}

