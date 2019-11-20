package io.isr.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferDto {
	
	@JsonProperty
	private String cardFrom;
	
	@JsonProperty
	private String cardTo;
	
	@JsonProperty
	private Long amount;
	
	public String getCardFrom() {
		return cardFrom;
	}
	
	public void setCardFrom(String cardFrom) {
		this.cardFrom = cardFrom;
	}
	
	public String getCardTo() {
		return cardTo;
	}
	
	public void setCardTo(String cardTo) {
		this.cardTo = cardTo;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
