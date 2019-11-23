package com.sachin.organization.PaymentGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sachin.organization.PaymentGateway.PaymentReceipt.PaymentReceipt;
import com.sachin.organization.PaymentGateway.model.Payment;
import com.sachin.organization.PaymentGateway.model.Payment.Type;
import com.sachin.organization.PaymentGateway.model.Receipt;

@SpringBootApplication
public class PaymentGatewayApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PaymentGatewayApplication.class, args);
		PaymentReceipt paymentReceipt= ctx.getBean(PaymentReceipt.class);
	
		Payment payment1= new Payment();
		payment1.setCardNumber("");
		payment1.setCcv(0);
		payment1.setExpDate(null);
		payment1.setCustomerName(null);
		payment1.setType(Type.CREDIT);
		
		Payment payment2= new Payment();
		payment2.setBankName("ICICI");
		payment2.setType(Type.INB);
		
		Receipt receipt= paymentReceipt.receipt(payment2);
		
		System.out.println("Payment Receipt is ");
		System.out.println("Payment Status is "+receipt.getStatus());
		System.out.println("Url is "+receipt.getUrl());
		
		for(String message : receipt.getMessages()) {
			System.out.println(message);
		}
	}

}
