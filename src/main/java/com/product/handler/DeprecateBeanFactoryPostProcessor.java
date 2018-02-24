package com.product.handler;

import com.product.annotation.DeprecateNew;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//@Component
public class DeprecateBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames ();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition (beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName ();
            try {
                Class<?> beanClass = Class.forName (beanClassName);
                DeprecateNew annotation = beanClass.getAnnotation (DeprecateNew.class);
                if (annotation != null) {
                    beanDefinition.setBeanClassName (annotation.newImpl ().getName ());
                }
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
}
