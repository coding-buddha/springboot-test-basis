package edu.pasudo123.study.demo.springio.controller;

import edu.pasudo123.study.demo.model.Member;
import edu.pasudo123.study.demo.springio.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("tx")
    public Member tx() {
        // cglib proxy 가 출력된다.
        // log.info("==> member service : {}", memberService.getClass());
        return memberService.createTransaction(Member.builder()
                .name("park_member")
                .age(30)
                .build());
    }
}
