package com.kevin.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = ("com.kevin.data"))
public class WxCloudRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}