package com.yond.frameworkDemo.spring.startProcess;

import com.yond.common.util.TraceUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceOnceIf(beanName.equals("bean_test"), "StepSmartInstantiationAwareBeanPostProcessor_predictBeanType");
        return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
    }
    
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "StepSmartInstantiationAwareBeanPostProcessor_determineCandidateConstructors");
        
        return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
    }
    
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        TraceUtil.getTrace("spring.start").traceIf(beanName.equals("bean_test"), "StepSmartInstantiationAwareBeanPostProcessor_getEarlyBeanReference");
        return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }
}
