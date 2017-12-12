package com.yaojiafeng.test.forkjoin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author yaojiafeng
 * @create 2017-08-01 上午11:40
 */
public class ForkJoinPoolTest {

    @Test
    public void testForkjoinPool() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        ForkJoinTask<Integer> submit = forkJoinPool.submit(new SumRecursiveTask(Arrays.asList(1, 2, 3, 4, 5)));

        Integer integer = submit.get();
        System.out.println(integer);
        System.out.println(level);
    }

    static int level = 0;

    static class SumRecursiveTask extends RecursiveTask<Integer> {

        List<Integer> list = new ArrayList<>();

        public SumRecursiveTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Integer compute() {
            try {
                level++;
                System.out.println(level);
                if (list.size() >= 2) {
                    int length = list.size() / 2;
                    SumRecursiveTask left = new SumRecursiveTask(list.subList(0, length));
                    SumRecursiveTask right = new SumRecursiveTask(list.subList(length, list.size()));

                    left.fork();
                    right.fork();

                    Integer join = left.join();
                    Integer join1 = right.join();
                    return join.intValue() + join1.intValue();
                } else {
                    return list.get(0);
                }
            } finally {
                level--;
            }
        }
    }


}
