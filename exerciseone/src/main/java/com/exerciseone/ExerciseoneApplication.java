package com.exerciseone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class ExerciseoneApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExerciseoneApplication.class, args);
  }

}
