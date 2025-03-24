package com.yond.frameworkDemo.spring.startProcess.aware;

import com.yond.common.util.TraceUtil;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
@Component
public class StepSmartInitializingSingleton implements SmartInitializingSingleton {
    
    @Override
    public void afterSingletonsInstantiated() {
        TraceUtil.getTrace("spring.start").trace("SmartInitializingSingleton_afterSingletonsInstantiated");
    }
    
}
