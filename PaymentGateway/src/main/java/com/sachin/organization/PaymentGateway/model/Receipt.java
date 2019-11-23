package com.sachin.organization.PaymentGateway.model;

import java.util.List;

public class Receipt {
	
	private Payment payment;
	public enum FinalStatus {SUCCESSFULPAYMENT, FAILEDPAYMENT, VALIDPAYMENT, INVALIDPAYMENT};
	private FinalStatus status;
	private List<String> messages;
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public FinalStatus getStatus() {
		return status;
	}
	public void setStatus(FinalStatus status) {
		this.status = status;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
	
	
}
