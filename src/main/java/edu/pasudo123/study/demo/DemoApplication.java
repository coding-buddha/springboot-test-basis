package edu.pasudo123.study.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final DemoJpaInitializer demoJpaInitializer;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // JPA N+1 을 위한 엔티티 초기화
        demoJpaInitializer.initOneToManyExSampleEntity();

        // one to one lazy loading 을 위한 초기화
        demoJpaInitializer.initOneToOneExSampleEntity();
    }
}
