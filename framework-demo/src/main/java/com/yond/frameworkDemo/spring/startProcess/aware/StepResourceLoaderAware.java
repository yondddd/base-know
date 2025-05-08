package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepResourceLoaderAware implements ResourceLoaderAware {
    
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        TraceUtil.getTrace("spring.start").trace("ResourceLoaderAware_setResourceLoader");
    }
}
