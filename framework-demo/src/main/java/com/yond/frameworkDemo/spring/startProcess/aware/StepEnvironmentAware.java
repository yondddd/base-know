package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepEnvironmentAware implements EnvironmentAware {
    
    @Override
    public void setEnvironment(Environment environment) {
        TraceUtil.getTrace("spring.start").trace("EnvironmentAware_setEnvironment");
    }
}
