package edu.pasudo123.study.demo.springio.service;

import edu.pasudo123.study.demo.model.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final EntityManager entityManager;

    /**
     * 현재 스레드에서 사용할 수 있는 실제 트랜잭션이 있는 entity manager 가 없기 때문에 에러발생.
     * persist 를 안정적으로 호출할 수 없음
     */
    public Account createNoTransaction(Account account) {
        entityManager.persist(account);
        return account;
    }

    @Transactional
    public Account createTransaction(Account account) {
        log.info("current account service class : {}", getClass());
        log.info("entityManager : {}", entityManager.getClass());
        entityManager.persist(account);
        return account;
    }
}
