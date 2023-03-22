package top.zerotop.scallion.data.provider.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NettyServer {
    @Value("${spring.websocket.port}")
    private int port;

    public void start() {
        //创建主线程组，接收请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //创建从线程组，处理主线程组分配下来的io操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建netty服务器
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)//设置主从线程组
                    .channel(NioServerSocketChannel.class)//设置通道
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline= socketChannel.pipeline();
                            //以下三个是Http的支持
                            //http解码器
                            pipeline.addLast(new HttpServerCodec());
                            //支持写大数据流
                            pipeline.addLast(new ChunkedWriteHandler());
                            //http聚合器
                            pipeline.addLast(new HttpObjectAggregator(1024*62));
                            //websocket支持,设置路由
                            pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                            //添加自定义的助手类
                            pipeline.addLast(new NettyHandler());
                        }
                    });//子处理器，用于处理workerGroup中的操作
            //启动server
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //监听关闭channel
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();//关闭主线程
            workerGroup.shutdownGracefully();//关闭从线程
        }
    }
}
