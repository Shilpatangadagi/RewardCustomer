package com.rewards.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class TransactionDTO {
   private Long id;
   private Long customerId;
   private Double amount;
   private LocalDate transactionDate;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
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
   
}
