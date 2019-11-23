package com.sachin.organization.PaymentGateway.PaymentValidation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sachin.organization.PaymentGateway.model.Payment;
import com.sachin.organization.PaymentGateway.model.Payment.Type;
import com.sachin.organization.PaymentGateway.model.Receipt;
import com.sachin.organization.PaymentGateway.model.Receipt.FinalStatus;

@Component
public class PaymentValidationImpl implements PaymentValidation{

	@Value("${payment.BANKS}")
	private List<String> BANKS;
	
	
	@Override
	public Receipt validate(Payment payment) {
		// TODO Auto-generated method stub
		Receipt receipt= new Receipt();
		List<String> messages= new ArrayList<String>();
		
		if(payment!=null && payment.getType()!=null && payment.getType().equals(Type.INB)) {
			if(payment.getBankName()!=null && BANKS.contains(payment.getBankName()) ) {
				receipt.setStatus(FinalStatus.VALIDPAYMENT);
				messages.add(payment.getBankName()+" Bank is Supported");
				receipt.setPayment(payment);
				receipt.setMessages(messages);
			}else {
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add(payment.getBankName()+" Bank Not Supported");
				receipt.setPayment(payment);
				receipt.setMessages(messages);
			}
		}
		else {
			
			receipt.setStatus(FinalStatus.VALIDPAYMENT);
			receipt.setPayment(payment);
			
			if(payment.getCardNumber()!=null && !payment.getCardNumber().trim().isEmpty() && payment.getCardNumber().length()<12) {
				
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add(payment.getCardNumber()+" is less than 12 digits");
				receipt.setMessages(messages);
				
			}else if(payment.getCardNumber()!=null && !payment.getCardNumber().trim().isEmpty() && payment.getCardNumber().length()>12) {
				
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add(payment.getCardNumber()+" is more than 12 digits");
				receipt.setMessages(messages);
				
			}else if(payment.getCardNumber()==null || payment.getCardNumber().isEmpty()) {
				
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add(payment.getType()+" Card Number is empty");
				receipt.setMessages(messages);
				
			}

			if(payment.getCustomerName()==null || payment.getCustomerName().isEmpty()){
				
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add("Customer Name is not given");
				receipt.setMessages(messages);
				
			}
			
			if(payment.getCcv()<=99 || payment.getCcv()>=1000) {
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add("CCV should be 3 digits");
				receipt.setMessages(messages);
			}
			
			if(payment.getExpDate()==null) {
				receipt.setStatus(FinalStatus.INVALIDPAYMENT);
				messages.add(payment.getType()+" Card Expiry Date should not be empty");
				receipt.setMessages(messages);
			}
			
			if(receipt.getStatus().equals(FinalStatus.VALIDPAYMENT)) {
				messages.add("All "+payment.getType()+" Card Details Validated ");
				receipt.setMessages(messages);
			}
			
		
		}
		
		
		return receipt;
		
	}

}
