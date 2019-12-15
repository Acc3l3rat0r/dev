package io.isr.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferDto {
	
	@JsonProperty
	private Long idFrom;
	
	@JsonProperty
	private Long idTo;
	
	@JsonProperty
	private Long amount;
	
	public Long getIdFrom() {
		return idFrom;
	}
	
	public void setIdFrom(Long idFrom) {
		this.idFrom = idFrom;
	}
	
	public Long getIdTo() {
		return idTo;
	}
	
	public void setIdTo(Long idTo) {
		this.idTo = idTo;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
