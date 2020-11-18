package edu.pasudo123.study.demo.springio.service;

import edu.pasudo123.study.demo.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Member createTransaction(Member member) {
        log.info("current member service class : {}", getClass());
        entityManager.persist(member);
        return member;
    }
}
