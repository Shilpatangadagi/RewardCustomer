package com.rewards.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Double amount;

   private LocalDate transactionDate;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;

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

public LocalDate getTransactionDate() {
	return transactionDate;
}

public void setTransactionDate(LocalDate transactionDate) {
	this.transactionDate = transactionDate;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}
   
}