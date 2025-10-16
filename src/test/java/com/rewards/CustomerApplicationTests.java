package com.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.rewards.dto.RewardDTO;
import com.rewards.entity.Customer;
import com.rewards.entity.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.RewardRepository;
import com.rewards.repository.TransactionRepository;
import com.rewards.service.RewardService;

@SpringBootTest
class CustomerApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock

	private CustomerRepository customerRepository;


	 

	 @Mock

	 private TransactionRepository transactionRepository;


	 

	 @Mock

	private RewardRepository rewardRepository;


	 

	 @InjectMocks

	 private RewardService rewardService;


	 

	 @BeforeEach

	  public void setup() {

	  MockitoAnnotations.openMocks(this);

	  }


	 

	 @Test

	  public void testCalculateRewardPoints() {

	  Long customerId = 1L;

	  LocalDate startDate = LocalDate.of(2025, 9, 1);

	  LocalDate endDate = LocalDate.of(2025, 10, 1);


	 

	  Customer customer = new Customer();

	  customer.setId(customerId);

	  customer.setName("John");


	 

	  Transaction tx1 = new Transaction();

	  tx1.setAmount(120.0);

	  tx1.setTransactionDate(LocalDate.of(2025, 9, 10));

	  tx1.setCustomer(customer);


	 

	  Transaction tx2 = new Transaction();

	  tx2.setAmount(80.0);

	  tx2.setTransactionDate(LocalDate.of(2025, 9, 15));

	  tx2.setCustomer(customer);


	 

	  when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

	  when(transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId, startDate, endDate))

	  .thenReturn(List.of(tx1, tx2));


	 

	  RewardDTO rewardDTO = rewardService.calculateRewardPoints(customerId, startDate, endDate);


	 

	 // tx1: 120 -> (20*2 + 50) = 90

	 // tx2: 80 -> (30*1) = 30

	 assertEquals(120, rewardDTO.getPoints());

	  assertEquals(customerId, rewardDTO.getCustomerId());

	  assertEquals("TOTAL", rewardDTO.getMonth());

	  verify(rewardRepository, times(1)).save(any());
      }

	}