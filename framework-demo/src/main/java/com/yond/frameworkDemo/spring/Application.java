package com.yond.frameworkDemo.spring;

import com.yond.common.util.TraceUtil;
import com.yond.frameworkDemo.spring.startProcess.StepApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author yond
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addInitializers(new StepApplicationContextInitializer());
        springApplication.run(args);
        TraceUtil.getTrace("spring.start").console();
    }
    
}
