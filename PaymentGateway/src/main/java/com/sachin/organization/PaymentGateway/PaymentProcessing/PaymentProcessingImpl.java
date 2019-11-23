package com.sachin.organization.PaymentGateway.PaymentProcessing;

import org.springframework.stereotype.Component;

import com.sachin.organization.PaymentGateway.model.Receipt;
import com.sachin.organization.PaymentGateway.model.Receipt.FinalStatus;

@Component
public class PaymentProcessingImpl implements PaymentProcessing{

	@Override
	public Receipt processing(Receipt receipt) {
		
		if(receipt.getStatus().equals(FinalStatus.VALIDPAYMENT)) {
			receipt.setStatus(FinalStatus.SUCCESSFULPAYMENT);
		}else {
			receipt.setStatus(FinalStatus.FAILEDPAYMENT);
		}
		return receipt;
	}

}
