package com.sachin.organization.PaymentGateway.PaymentProcessing;

import com.sachin.organization.PaymentGateway.model.Receipt;

public interface PaymentProcessing {
	public Receipt processing(Receipt receipt);
}
