package io.isr.card.controllers;

import io.isr.card.dto.*;
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
		ArrayList<CardDto> cardDtos = new ArrayList<>();
		for(int i = 0; i<cards.size(); i++){
			cardDtos.add(new CardDto());
		}
		for(int i = 0; i<cards.size(); i++){
			cardDtos.get(i).setBalance(cards.get(i).getBalance());
			cardDtos.get(i).setId(cards.get(i).getId());
			cardDtos.get(i).setUserId(cards.get(i).getUserId());
			cardDtos.get(i).setCardNumber("****"+cards.get(i).getCardNumber().substring(14));
		}
		return ok(cardDtos);
	}
	
	@GetMapping("/getCardInfo/{id}")
	public ResponseEntity getCardInfo(@PathVariable Long id){
		Card card = cardService.findCardById(id);
		return  ok(card);
	}
	
	@PutMapping("/putMoneyToClient")
	public ResponseEntity putMoneyToClient(@RequestBody TransferToClientDto transferToClientDto){
		Card cardFrom = cardService.findCardById(transferToClientDto.getIdFrom());
		Card cardTo = cardService.findByCardNumber(transferToClientDto.getCardTo());
		Long amount = transferToClientDto.getAmount();
		cardFrom.setBalance(cardFrom.getBalance()-amount);
		cardTo.setBalance(cardTo.getBalance()+amount);
		cardRepositories.save(cardFrom);
		cardRepositories.save(cardTo);
		return ok(HttpStatus.OK);
	}
	
	@PutMapping("/putMoney")
	public ResponseEntity putMoney(@RequestBody TransferDto transferDto){
		Card cardFrom = cardService.findCardById(transferDto.getIdFrom());
		Card cardTo = cardService.findCardById(transferDto.getIdTo());
		Long amount = transferDto.getAmount();
		cardFrom.setBalance(cardFrom.getBalance()-amount);
		cardTo.setBalance(cardTo.getBalance()+amount);
		cardRepositories.save(cardFrom);
		cardRepositories.save(cardTo);
		return ok(HttpStatus.OK);
	}
	
	@PutMapping("/pay")
	public ResponseEntity pay(@RequestBody PaymentDto paymentDto){
		Card card = cardService.findCardById(paymentDto.getId());
		card.setBalance(card.getBalance()+paymentDto.getAmount());
		cardRepositories.save(card);
		return ok(HttpStatus.OK);
	}
}
