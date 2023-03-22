package top.zerotop.scallion.data.provider.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //所有正在连接的channel都会存在这里面
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //接收到客户端发送的消息
    @Override
    public void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        sendAllMessages(ctx, msg.text());
    }
    //客户端建立连接
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        System.out.println(ctx.channel().remoteAddress()+"连接成功!");
    }
    //关闭连接
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.remove(ctx.channel());
        System.out.println(ctx.channel().remoteAddress()+"断开连接");
    }

    //出现异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    //给客户端发送消息
    private void sendMessage(ChannelHandlerContext ctx, String msg) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame(msg));
    }

    // 广播消息
    public static void sendAllMessages(ChannelHandlerContext ctx, String msg) {
        for(Channel channel:channelGroup){
            System.out.println(String.format("socket msg: 请求 channel: %s", channel.id()));

            channel.writeAndFlush(new TextWebSocketFrame(msg));
        }
    }
}
