package com.rewards.dto;

import lombok.Data;

@Data
public class RewardDTO {
   private Long id;
   private Long customerId;
   private String month;
   private Integer points;
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
   
}
