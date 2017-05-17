package com.yaojiafeng.common.hystrix;

import com.google.common.collect.Lists;
import com.netflix.hystrix.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE;
import static com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy.THREAD;

/**
 * Created by yaojiafeng on 2017/5/12 下午4:45.
 */
public class TagQueryCommand extends HystrixCommand<List<String>> {
    // queryTags()的入参
    int groupId;

    int i = 0;

    // 构造方法用来进行方法参数传递
    protected TagQueryCommand(int groupId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TagService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("TagQueryCommand"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("TagServicePool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                                .withExecutionIsolationStrategy(SEMAPHORE)
//                                .withExecutionIsolationSemaphoreMaxConcurrentRequests(1)
                                .withExecutionIsolationStrategy(THREAD)
                                .withCircuitBreakerEnabled(true)
                                .withCircuitBreakerRequestVolumeThreshold(2)
                                .withExecutionIsolationThreadTimeoutInMilliseconds(5000)
                        .withMetricsRollingStatisticalWindowInMilliseconds(5000)
                ));
        this.groupId = groupId;
    }

    // 我们调用远程方法定义在这里面
    @Override
    protected List<String> run() throws Exception {
//        Thread.sleep(1000);
//        if ((i++) % 2 == 0) {
//            throw new Exception();
//        }
        List<String> strings = Arrays.asList("hystrix-TagServicePool-1", "hystrix-TagServicePool-2", "hystrix-TagServicePool-3");
        if (strings.contains(Thread.currentThread().getName())) {
            throw new Exception();
        }

        return Arrays.asList("1", "2", "3");
    }

    // 降级方式
    @Override
    protected List<String> getFallback() {
        return Arrays.asList("4");
    }


    public static void main(String[] args) {

        int array[] = {1000, 500, 300};
        int i = 0;
        while (i++ < 10) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Arrays.asList("4", "5", "6").contains(Thread.currentThread().getName())) {
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    TagQueryCommand tagQueryCommand = new TagQueryCommand(1);
                    List<String> execute = tagQueryCommand.execute();
                    System.out.println(execute);
                }
            }, i + "").start();

        }


    }
}