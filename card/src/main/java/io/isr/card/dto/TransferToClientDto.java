package io.isr.card.dto;

public class TransferToClientDto {
	private Long idFrom;
	private String cardTo;
	private Long amount;
	
	public Long getIdFrom() {
		return idFrom;
	}
	
	public void setIdFrom(Long idFrom) {
		this.idFrom = idFrom;
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
