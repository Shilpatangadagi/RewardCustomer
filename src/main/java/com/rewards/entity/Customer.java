package com.rewards.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;
   private String email;

   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
   private List<Transaction> transactions;

   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
   private List<Reward> rewards;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public List<Transaction> getTransactions() {
	return transactions;
}

public void setTransactions(List<Transaction> transactions) {
	this.transactions = transactions;
}

public List<Reward> getRewards() {
	return rewards;
}

public void setRewards(List<Reward> rewards) {
	this.rewards = rewards;
}

 
}