package com.rewards.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.dto.CustomerDTO;
import com.rewards.dto.RewardDTO;
import com.rewards.dto.TransactionDTO;
import com.rewards.entity.Customer;
import com.rewards.entity.Reward;
import com.rewards.entity.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.RewardRepository;
import com.rewards.repository.TransactionRepository;

@Service
public class RewardService {

   @Autowired
   private CustomerRepository customerRepository;

   @Autowired
   private TransactionRepository transactionRepository;

   @Autowired
   private RewardRepository rewardRepository;

   public CustomerDTO createCustomer(CustomerDTO dto) {
       Customer customer = new Customer();
       customer.setName(dto.getName());
       customer.setEmail(dto.getEmail());
       Customer saved = customerRepository.save(customer);
       dto.setId(saved.getId());
       return dto;
   }

   public TransactionDTO createTransaction(TransactionDTO dto) {
       Customer customer = customerRepository.findById(dto.getCustomerId())
               .orElseThrow(() -> new RuntimeException("Customer not found"));

       Transaction transaction = new Transaction();
       transaction.setAmount(dto.getAmount());
       transaction.setTransactionDate(dto.getTransactionDate());
       transaction.setCustomer(customer);

       Transaction saved = transactionRepository.save(transaction);
       dto.setId(saved.getId());
       return dto;
   }

   public RewardDTO calculateRewardPoints(Long customerId, LocalDate startDate, LocalDate endDate) {
       List<Transaction> transactions = transactionRepository
               .findByCustomerIdAndTransactionDateBetween(customerId, startDate, endDate);

       Map<String, Integer> monthlyPoints = new HashMap<>();
       int totalPoints = 0;

       for (Transaction tx : transactions) {
           int points = calculatePoints(tx.getAmount());
           String month = tx.getTransactionDate().getMonth().toString();

           monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0) + points);
           totalPoints += points;
       }

       RewardDTO rewardDTO = new RewardDTO();
       rewardDTO.setCustomerId(customerId);
       rewardDTO.setPoints(totalPoints);
       rewardDTO.setMonth("TOTAL");

       // Optionally save to DB
       Reward reward = new Reward();
       reward.setCustomer(customerRepository.findById(customerId).orElseThrow());
       reward.setMonth("TOTAL");
       reward.setPoints(totalPoints);
       rewardRepository.save(reward);

       return rewardDTO;
   }

   private int calculatePoints(Double amount) {
       int points = 0;
       if (amount > 100) {
           points += (int) ((amount - 100) * 2);
           points += 50; // for the $50-$100 range
       } else if (amount > 50) {
           points += (int) ((amount - 50) * 1);
       }
       return points;
   }
}
