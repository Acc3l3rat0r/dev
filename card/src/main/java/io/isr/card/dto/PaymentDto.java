package io.isr.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDto {
	@JsonProperty("numberOfCard")
	private String numberOfCard;
	
	@JsonProperty("amount")
	private Long amount;
	
	public String getNumberOfCard() {
		return numberOfCard;
	}
	
	public void setNumberOfCard(String numberOfCard) {
		this.numberOfCard = numberOfCard;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
