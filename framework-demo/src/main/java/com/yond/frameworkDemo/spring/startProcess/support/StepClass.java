package com.yond.frameworkDemo.spring.startProcess.support;

import com.yond.common.util.TraceUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
public class StepClass implements InitializingBean, CommandLineRunner, DisposableBean {
    
    @PostConstruct
    public void init() {
        TraceUtil.getTrace("spring.start").trace("StepClass_PostConstruct");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        TraceUtil.getTrace("spring.start").trace("StepClass_InitializingBean");
    }
    
    @Override
    public void run(String... args) throws Exception {
        TraceUtil.getTrace("spring.start").trace("StepClass_CommandLineRunner");
    }
    
    @Override
    public void destroy() throws Exception {
        TraceUtil.getTrace("spring.start").trace("StepClass_DisposableBean");
    }
}
