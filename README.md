# RewardCustomer
# Retail Rewards API

# Project Overview
 A Spring Boot RESTful API for managing a retailer's rewards program. It allows creating customers and transactions, and calculating reward points based on transaction history within a specified time frame.



## 🚀 Features

- Create and manage customers

- Record customer transactions

- Calculate reward points per customer

- Filter rewards by date range

- Clean architecture with DTOs, services, and exception handling



## 🛠️ Tech Stack



- Java 17+

- Spring Boot

- Spring Web

- Spring Data JPA

- H2 / MySQL (configurable)

- Lombok

- Maven



## 📁 Project Structure

Show more lines

com.rewards ├── api # REST controllers 
			├── dto # Data Transfer Objects 
			├── entity # JPA entities 
			├── repository # Spring Data JPA repositories 
			├── service # Business logic 
			├── exception # Custom exceptions and handlers 
			└── RewardsApplication.java


## 📦 API Endpoints



## Create a Customer


POST 
http:localhost:8765/api/customers



Request Body:

{

  "name": "John Doe",

  "email": "john@example.com"

}



#Create Transaction



POST 
http:localhost:8765/api/transactions



Request Body:

{

  "customerId": 1,

  "amount": 120.0,

  "transactionDate": "2025-10-01"

}

#Get Rewards

GET 
http:localhost:8765/api/rewards/{customerId}?startDate=2025-09-01&endDate=2025-10-01



Reward Calculation Logic

No points for transactions ≤ $50
1 point per dollar for $51–$100
2 points per dollar over $100

Example: $120 → 70 points (50 × 1 + 20 × 2)

🛠️ Setup & Run

Clone the repository
Run mvn clean install
Start the app with mvn spring-boot:run
Access API at http://localhost:8765/api

🧪 Testing

Unit and integration tests can be added using JUnit and Mockito.
