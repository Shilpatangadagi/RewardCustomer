package com.rewards.api;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.dto.CustomerDTO;
import com.rewards.dto.RewardDTO;
import com.rewards.dto.TransactionDTO;
import com.rewards.service.RewardService;

@RestController
@RequestMapping("/api")
public class RewardController {

   @Autowired
   private RewardService rewardService;

   // POST: Create a new customer
   @PostMapping("/customers")
   public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
       return rewardService.createCustomer(customerDTO);
   }

   // POST: Create a new transaction
   @PostMapping("/transactions")
   public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
       return rewardService.createTransaction(transactionDTO);
   }

   // GET: Calculate rewards for a customer within a time frame
   @GetMapping("/rewards/{customerId}")
   public RewardDTO getRewards(
           @PathVariable Long customerId,
           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
       return rewardService.calculateRewardPoints(customerId, startDate, endDate);
   }
}
