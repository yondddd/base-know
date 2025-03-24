package com.yond.frameworkDemo.spring.startProcess;

import com.yond.common.util.TraceUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepBeanFactoryAware implements BeanFactoryAware {
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        TraceUtil.getTrace("spring.start").trace("BeanFactoryAware_setBeanFactory");
    }
}
