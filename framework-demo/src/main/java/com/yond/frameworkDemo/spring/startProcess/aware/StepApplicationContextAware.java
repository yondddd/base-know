package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepApplicationContextAware implements ApplicationContextAware {
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TraceUtil.getTrace("spring.start").trace("ApplicationContextAware_setApplicationContext");
    }
}
