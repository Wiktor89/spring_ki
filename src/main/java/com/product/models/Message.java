package com.product.models;

import com.product.annotation.InjectRandomInt;
import com.product.annotation.MessageMes;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Message {

    @InjectRandomInt(min = 2, max = 8)
    private int repetition;

    @MessageMes(message = {"test","tset"})
    private String message;

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public String getMessage() {
        return message;
    }

    public void go() {
        System.out.println ("Message");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        System.out.println ("Message.i " + repetition);
    }

    @PreDestroy
    public void destroy() {
        System.out.println ("Message.d");
    }
}
