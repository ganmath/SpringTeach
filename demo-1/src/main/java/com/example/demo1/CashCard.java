package com.example.demo1;

import java.util.Objects;

import org.springframework.stereotype.Component;

// Java class CashCard using fields id as long and amount as double using record keyword of Java 17

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
	
	@Override
	public int hashCode() {
		return Objects.hash(amount, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashCard other = (CashCard) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CashCard [id=" + id + ", amount=" + amount + "]";
	}
	
	
	
}