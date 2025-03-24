package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepEmbeddedValueResolverAware implements EmbeddedValueResolverAware {
    
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        TraceUtil.getTrace("spring.start").trace("EmbeddedValueResolverAware_setEmbeddedValueResolver");
    }
}
