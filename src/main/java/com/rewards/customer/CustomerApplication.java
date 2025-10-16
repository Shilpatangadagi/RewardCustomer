package com.rewards.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages="com.rewards.repository")
public class CustomerApplication {
   public static void main(String[] args) {
       SpringApplication.run(CustomerApplication.class, args);
   }
}
