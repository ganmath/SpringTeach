package com.example.cashcard;

import org.springframework.stereotype.Component;

// Java class CashCard using fields id as long and amount as double using record keyword of Java 17

@Component
public class CashCard {
	
	private Long id;
	private Double amount;
	
	public CashCard(Long id, Double amount) {
		this.id = id;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}