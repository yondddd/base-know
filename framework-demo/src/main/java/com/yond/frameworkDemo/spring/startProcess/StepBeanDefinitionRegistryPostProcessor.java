package com.yond.frameworkDemo.spring.startProcess;

import com.yond.common.util.TraceUtil;
import com.yond.frameworkDemo.spring.startProcess.support.StepClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(StepClass.class.getName());
        registry.registerBeanDefinition("bean_test", beanDefinition);
        TraceUtil.getTrace("spring.start").trace("BeanDefinitionRegistryPostProcessor_postProcessBeanDefinitionRegistry");
    }
    
}
