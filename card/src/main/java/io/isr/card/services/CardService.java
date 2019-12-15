package io.isr.card.services;

import io.isr.card.dto.UserDto;
import io.isr.card.entities.Card;
import io.isr.card.repositories.CardRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CardService {
	@Autowired
	CardRepositories cardRepositories;
	
	@Autowired
	FeignService feignService;
	
	public ArrayList<Card> findAllCardsByUserId(Long userId){
		return cardRepositories.findAllByUserId(userId);
	}
	
	public Card findByCardNumber(String cardNumber){
		return cardRepositories.findByCardNumber(cardNumber);
	}
	
	public Card findCardById(Long id){
		return cardRepositories.findCardById(id);
	}
	
	public Card finCardByUserId(Long id){
		return cardRepositories.findCardById(id);
	}
	
	public Card CreateCard(String token){
		Card card = new Card();
		UserDto userDto = feignService.getUser(token);
		card.setUserId(userDto.getId());
		card.setBalance((long) 0);
		card.setCardNumber(generateCardNumber());
		cardRepositories.save(card);
		return card;
	}
	
	private String generateCardNumber(){
		int a = 1000+(int) (Math.random() * 9000);
		int b = 1000+(int) (Math.random() * 9000);
		int c = 1000+(int) (Math.random() * 9000);
		int d = 1000+(int) (Math.random() * 9000);
		return a + "-" + b+"-"+c+"-"+d;
	}
}
