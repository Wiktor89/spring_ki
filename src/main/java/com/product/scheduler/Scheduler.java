package com.product.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Scheduler {

    private final LocalDateTime localDate = LocalDateTime.now () ;

    @Scheduled(fixedDelay = 1000)
    public void reportCurrentTime() {
        System.out.println ("Scheduler.reportCurrentTime " + localDate.getSecond ());
    }
}
