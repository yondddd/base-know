package com.yond.frameworkDemo.spring.startProcess;

import com.yond.common.util.TraceUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "InstantiationAwareBeanPostProcessor_postProcessBeforeInstantiation");
        return org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }
    
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "InstantiationAwareBeanPostProcessor_postProcessAfterInstantiation");
        return org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }
    
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "InstantiationAwareBeanPostProcessor_postProcessProperties");
        return org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "InstantiationAwareBeanPostProcessor_postProcessBeforeInitialization");
        return org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "InstantiationAwareBeanPostProcessor_postProcessAfterInitialization");
        return org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
