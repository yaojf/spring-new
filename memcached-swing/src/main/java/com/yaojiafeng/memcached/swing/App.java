package com.yaojiafeng.memcached.swing;

import net.rubyeye.xmemcached.exception.MemcachedException;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by yaojiafeng on 2018/11/1 10:54 AM.
 */
public class App {

    public static void main(String[] args) {
        // 1. 创建一个顶层容器（窗口）
        JFrame jf = new JFrame("测试环境缓存清理工具");          // 创建窗口
        jf.setSize(250, 250);                       // 设置窗口大小
        jf.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）

        // 2. 创建中间容器（面板容器）
        JPanel panel = new JPanel();                // 创建面板容器，使用默认的布局管理器

        // 3. 创建一个基本组件（按钮），并添加到 面板容器 中
        JButton btn1 = new JButton("清除memcached缓存");
        panel.add(btn1);
        JButton btn2 = new JButton("清除redis缓存");
        panel.add(btn2);

        btn1.addActionListener(e -> {
            String message = "清除memcached缓存成功！";
            try {
                MemcachedUtil.main(null);
            } catch (IOException e1) {
                message = e1.getMessage();
            } catch (InterruptedException e1) {
                message = e1.getMessage();
            } catch (MemcachedException e1) {
                message = e1.getMessage();
            } catch (TimeoutException e1) {
                message = e1.getMessage();
            }
            JOptionPane.showMessageDialog(null, message, "结果", JOptionPane.INFORMATION_MESSAGE);
        });

        btn2.addActionListener(e -> {
            String message = "清除redis缓存成功！";
            try {
                RedisUtil.main(null);
            } catch (IOException e1) {
                message = e1.getMessage();
            } catch (InterruptedException e1) {
                message = e1.getMessage();
            } catch (MemcachedException e1) {
                message = e1.getMessage();
            } catch (TimeoutException e1) {
                message = e1.getMessage();
            }
            JOptionPane.showMessageDialog(null, message, "结果", JOptionPane.INFORMATION_MESSAGE);
        });

        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
        jf.setContentPane(panel);

        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
        jf.setVisible(true);
    }

}
