package com.sachin.organization.PaymentGateway.PaymentReceipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sachin.organization.PaymentGateway.PaymentProcessing.PaymentProcessing;
import com.sachin.organization.PaymentGateway.PaymentValidation.PaymentValidation;
import com.sachin.organization.PaymentGateway.model.Payment;
import com.sachin.organization.PaymentGateway.model.Receipt;

@Component
public class PaymentReceiptImpl implements PaymentReceipt{

	@Autowired
	private PaymentValidation validator;
	
	@Autowired
	private PaymentProcessing processer;
	
	
	@Override
	public Receipt receipt(Payment payment) {
		
		Receipt receipt= new Receipt();
		receipt=validator.validate(payment);
		
		receipt=processer.processing(receipt);
		return receipt;
	}

}
