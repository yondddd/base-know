package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepMessageSourceAware implements MessageSourceAware {
    
    @Override
    public void setMessageSource(MessageSource messageSource) {
        TraceUtil.getTrace("spring.start").trace("MessageSourceAware_setMessageSource");
        
    }
}
