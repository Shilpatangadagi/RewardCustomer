package com.rewards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String month;
   private Integer points;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public Integer getPoints() {
	return points;
}

public void setPoints(Integer points) {
	this.points = points;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

 
   
}