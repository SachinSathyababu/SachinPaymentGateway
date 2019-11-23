package com.sachin.organization.PaymentGateway.PaymentReceipt;

import com.sachin.organization.PaymentGateway.model.Payment;
import com.sachin.organization.PaymentGateway.model.Receipt;

public interface PaymentReceipt {
	public Receipt receipt(Payment payment);
}
