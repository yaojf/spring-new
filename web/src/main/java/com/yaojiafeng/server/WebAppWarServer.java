package com.yaojiafeng.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by yaojiafeng on 2017/4/11 下午3:53.
 */
public class WebAppWarServer {
    public static void main(String[] args) throws Exception {
        runFolder();
    }


    public static void runWar() throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar("E:/share/test/xxx.war");
        server.setHandler(context);

        server.start();
        server.join();
    }

    public static void runFolder() throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setDescriptor("/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();
        server.join();
    }


}
