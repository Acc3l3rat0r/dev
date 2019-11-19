package io.isr.card.controllers;

import io.isr.card.dto.PaymentDto;
import io.isr.card.dto.UserDto;
import io.isr.card.entities.Card;
import io.isr.card.repositories.CardRepositories;
import io.isr.card.services.CardService;
import io.isr.card.services.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CardController {
	@Autowired
	CardService cardService;
	
	@Autowired
	FeignService feignService;
	
	@Autowired
	CardRepositories cardRepositories;
	
	@PostMapping("/createCard/{token}")
	public ResponseEntity createCard(@PathVariable String token) {
		Card card = cardService.CreateCard(token);
		String number = card.getCardNumber();
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "Card with number: " + number + " created");
		return ok(model);
	}
	
	@GetMapping("/getCard/{token}")
	public ResponseEntity getCard(@PathVariable String token) {
		UserDto userDto = feignService.getUser(token);
		ArrayList<Card> cards = cardService.findAllCardsByUserId(userDto.getId());
		return ok(cards);
	}
	
	@PutMapping("/pay")
	public ResponseEntity pay(@RequestBody PaymentDto paymentDto){
		Card card = cardService.findByCardNumber(paymentDto.getNumberOfCard());
		card.setBalance(paymentDto.getAmount());
		cardRepositories.save(card);
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "Successful pay operation ");
		return ok(model);
	}
	
	
}
