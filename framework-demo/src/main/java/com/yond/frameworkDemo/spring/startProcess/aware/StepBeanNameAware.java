package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepBeanNameAware implements BeanNameAware {
    
    @Override
    public void setBeanName(String name) {
        if (name.equals("bean_test")) {
            TraceUtil.getTrace("spring.start").trace("BeanNameAware_setBeanName");
        }
    }
    
}
