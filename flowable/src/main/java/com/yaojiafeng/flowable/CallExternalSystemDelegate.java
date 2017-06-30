package com.yaojiafeng.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author yaojiafeng
 * @create 2017-06-29 下午6:38
 */
public class CallExternalSystemDelegate implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Calling the external system for employee " + execution.getVariable("employee"));
    }
}