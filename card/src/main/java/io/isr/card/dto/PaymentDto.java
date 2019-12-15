package io.isr.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDto {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("amount")
	private Long amount;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
