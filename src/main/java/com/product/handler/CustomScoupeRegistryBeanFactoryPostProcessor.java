package com.product.handler;

import com.product.scoupe.PeriodScoupeConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomScoupeRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bean) throws BeansException {
        bean.registerScope ("periodical", new PeriodScoupeConfigurer ());
    }
}
