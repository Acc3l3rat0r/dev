package io.isr.transaction.controllers;

import io.isr.transaction.dto.TransferDto;
import io.isr.transaction.services.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TransferController {
	
	@Autowired
	FeignService feignService;
	
	@PutMapping("/transfer")
	public ResponseEntity transfer(@RequestBody TransferDto transferDto){
		feignService.putMoney(transferDto);
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "Transfer successful");
		return ResponseEntity.ok(model);
	}
}

