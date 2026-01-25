package com.ibm.be.isco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Start
@SpringBootApplication
@ComponentScan(basePackages = "com.ibm.be.isco")
public class IscoApplication {

  public static void main(String[] args) {

    SpringApplication.run(IscoApplication.class, args);
  }
}
