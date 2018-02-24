package com.product.handler;

import com.product.annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class InjectRandomIntegerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass ().getDeclaredFields ();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation (InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min ();
                int max = annotation.max ();
                field.setAccessible (true);
                int random = random (min, max);
                ReflectionUtils.setField (field, bean, random);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private int random(int min, int max) {
        max -= min;
        return (int) (Math.random () * ++max) + min;
    }
}
