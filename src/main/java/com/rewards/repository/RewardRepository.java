package com.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rewards.entity.Reward;

public interface RewardRepository extends JpaRepository<Reward, Long> {
   List<Reward> findByCustomerId(Long customerId);
}

