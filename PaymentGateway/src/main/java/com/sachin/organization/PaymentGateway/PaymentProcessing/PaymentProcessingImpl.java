package com.sachin.organization.PaymentGateway.PaymentProcessing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sachin.organization.PaymentGateway.model.Receipt;
import com.sachin.organization.PaymentGateway.model.Receipt.FinalStatus;

@Component
public class PaymentProcessingImpl implements PaymentProcessing{

	@Value("${payment.SBIINB}")
	private String SBIURL;
	
	@Value("${payment.ICICIINB}")
	private String ICICIURL;
	
	@Override
	public Receipt processing(Receipt receipt) {
		
		if(receipt.getStatus().equals(FinalStatus.VALIDPAYMENT)) {
			receipt.setStatus(FinalStatus.SUCCESSFULPAYMENT);
			
			if(receipt.getPayment().getBankName()!=null && receipt.getPayment().getBankName().equalsIgnoreCase("SBI")) {
				receipt.setUrl(SBIURL);
			}
			
			if(receipt.getPayment().getBankName()!=null && receipt.getPayment().getBankName().equalsIgnoreCase("ICICI")) {
				receipt.setUrl(ICICIURL);
			}
			
			
		}else {
			receipt.setStatus(FinalStatus.FAILEDPAYMENT);
		}
		return receipt;
	}

}
