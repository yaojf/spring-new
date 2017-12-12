package com.yaojiafeng.common.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yaojiafeng on 16/1/17.
 */
public class SimpleClientHandler extends ChannelHandlerAdapter {


    /**
     * Creates a client-side handler.
     */
    public SimpleClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf message = Unpooled.copiedBuffer("hello world".getBytes());

        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf body = (ByteBuf) msg;

        byte[] bytes = new byte[body.readableBytes()];
        body.readBytes(bytes);
        System.out.println(new String(bytes));
    }

}
