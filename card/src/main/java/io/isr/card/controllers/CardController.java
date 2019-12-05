package io.isr.card.controllers;

import io.isr.card.dto.PaymentDto;
import io.isr.card.dto.TransferDto;
import io.isr.card.dto.UserDto;
import io.isr.card.entities.Card;
import io.isr.card.repositories.CardRepositories;
import io.isr.card.services.CardService;
import io.isr.card.services.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
		cardService.CreateCard(token);
		return ok(HttpStatus.OK);
	}
	
	@GetMapping("/getCard/{token}")
	public ResponseEntity getCard(@PathVariable String token) {
		UserDto userDto = feignService.getUser(token);
		ArrayList<Card> cards = cardService.findAllCardsByUserId(userDto.getId());
		return ok(cards);
	}
	
	
	@PutMapping("/putMoney")
	public ResponseEntity putMoney(@RequestBody TransferDto transferDto){
		Card cardFrom = cardService.findByCardNumber(transferDto.getCardFrom());
		Card cardTo = cardService.findByCardNumber(transferDto.getCardTo());
		Long amount = transferDto.getAmount();
		cardFrom.setBalance(cardFrom.getBalance()-amount);
		cardTo.setBalance(cardTo.getBalance()+amount);
		cardRepositories.save(cardFrom);
		cardRepositories.save(cardTo);
		return ok(HttpStatus.OK);
	}
	
	@PutMapping("/pay")
	public ResponseEntity pay(@RequestBody PaymentDto paymentDto){
		Card card = cardService.findByCardNumber(paymentDto.getNumberOfCard());
		card.setBalance(card.getBalance()+paymentDto.getAmount());
		cardRepositories.save(card);
		return ok(HttpStatus.OK);
	}
}
