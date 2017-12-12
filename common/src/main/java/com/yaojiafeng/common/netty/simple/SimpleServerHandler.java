package com.yaojiafeng.common.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yaojiafeng on 16/1/17.
 */
public class SimpleServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf body = (ByteBuf) msg;
        byte[] bytes = new byte[body.readableBytes()];
        body.readBytes(bytes);
        System.out.println(new String(bytes));

        ByteBuf resp = Unpooled.copiedBuffer(bytes);
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}