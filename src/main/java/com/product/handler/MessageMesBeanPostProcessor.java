package com.product.handler;

import com.product.annotation.MessageMes;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class MessageMesBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass ().getDeclaredFields ();
        for (Field declaredField : declaredFields) {
            MessageMes annotation = declaredField.getAnnotation (MessageMes.class);
            if (annotation != null) {
                declaredField.setAccessible (true);
                String[] message = annotation.message ();
                StringBuilder s1 = new StringBuilder ();
                for (String s : message) {
                    s1.append (s);

                }
                ReflectionUtils.setField (declaredField, bean, s1.toString ());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
