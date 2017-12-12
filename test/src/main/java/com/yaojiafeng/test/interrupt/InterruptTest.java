package com.yaojiafeng.test.interrupt;

import org.junit.Test;

import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yaojiafeng
 * @create 2017-08-02 上午11:04
 */
public class InterruptTest {

    @Test
    public static void test() throws InterruptedException {

        final ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(111111);
                    reentrantLock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                reentrantLock.unlock();
            }
        });
        thread.start();

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (next.equals("1")) {
            thread.interrupt();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
