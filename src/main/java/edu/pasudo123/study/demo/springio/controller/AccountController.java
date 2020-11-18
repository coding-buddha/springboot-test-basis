package edu.pasudo123.study.demo.springio.controller;

import edu.pasudo123.study.demo.model.Account;
import edu.pasudo123.study.demo.springio.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("no-tx")
    public Account noTx() {
        return accountService.createNoTransaction(Account.builder()
                .name("park_account")
                .age(30).build());
    }

    @GetMapping("tx")
    public Account tx() {
        // cglib proxy 가 출력된다.
        // log.info("==> account service : {}", accountService.getClass());
        return accountService.createTransaction(Account.builder()
                .name("park_account")
                .age(30).build());
    }
}
