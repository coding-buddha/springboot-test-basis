package edu.pasudo123.study.demo;

import edu.pasudo123.study.demo.springio.service.AccountService;
import edu.pasudo123.study.demo.springio.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final DemoJpaInitializer demoJpaInitializer;
    private final DemoBeanFactoryChecker demoBeanFactoryChecker;
    private final ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // JPA N+1 을 위한 엔티티 초기화
        // demoJpaInitializer.initOneToManyExSampleEntity();

        // one to one lazy loading 을 위한 초기화
        // demoJpaInitializer.initOneToOneExSampleEntity();

        log.info("=== proxy check run ===");
        AccountService accountService = context.getBean(AccountService.class);

        // cglib proxy 가 출력된다. :: AccountService class 를 proxy 객체(CGLIB) 로 래핑.
        log.info("account service bean");
        log.info("current class : {}", accountService.getClass());

        MemberService memberService = context.getBean(MemberService.class);
        log.info("");
        log.info("member service bean");
        log.info("current class : {}", memberService.getClass());
    }
}
