package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepApplicationStartupAware implements ApplicationStartupAware {
    
    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        TraceUtil.getTrace("spring.start").trace("ApplicationStartupAware_setApplicationStartup");
    }
}
