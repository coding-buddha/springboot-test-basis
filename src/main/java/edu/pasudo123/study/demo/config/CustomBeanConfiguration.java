//package edu.pasudo123.study.demo.config;
//
//import edu.pasudo123.study.demo.springio.service.AccountService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//
//@Configuration(proxyBeanMethods = false)
//@RequiredArgsConstructor
//public class CustomBeanConfiguration {
//
//    private final EntityManager entityManager;
//
//    @Bean
//    public AccountService accountService() {
//        AccountService accountService = new AccountService(entityManager);
//        return accountService;
//    }
//}
