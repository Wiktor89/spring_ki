package com.product;

import com.product.configuration.ConfigurationSpring;
import com.product.models.ColorFrame;
import com.product.models.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static int anInt = 12;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext (
                ConfigurationSpring.class);
        Message bean = context.getBean (Message.class);
        while (true) {
            context.getBean (ColorFrame.class).showOnRandomColor ();
            Thread.sleep (500);
        }
//        ((AbstractApplicationContext) context).close ();
    }
}
