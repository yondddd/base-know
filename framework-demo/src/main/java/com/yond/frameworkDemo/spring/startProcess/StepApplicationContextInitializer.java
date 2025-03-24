package com.yond.frameworkDemo.spring.startProcess;

import com.yond.common.util.TraceUtil;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Author: yond
 * @Date: 3/23/2025
 */
public class StepApplicationContextInitializer implements ApplicationContextInitializer {
    
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        TraceUtil.getTrace("spring.start").trace("ApplicationContextInitializer initialize");
    }
    
}
