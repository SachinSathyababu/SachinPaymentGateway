package com.sachin.organization.PaymentGateway.PaymentValidation;

import com.sachin.organization.PaymentGateway.model.Payment;
import com.sachin.organization.PaymentGateway.model.Receipt;

public interface PaymentValidation {
	public Receipt validate(Payment payment);
}
