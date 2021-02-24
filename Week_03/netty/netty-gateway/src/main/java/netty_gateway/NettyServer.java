package netty_gateway;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @param
 * @author silent
 * @time 15:48 2021/2/24
 * @description netty 服务端
 */
public class NettyServer {


    public static void main(String[] args) throws Exception{
        //只处理accpt（连接） 请求
        EventLoopGroup boos = new NioEventLoopGroup(1);
        //真正处理业务
        EventLoopGroup work = new NioEventLoopGroup();


        ServerBootstrap serverBootstrap = new ServerBootstrap();


        try {
            //配置条件
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .option(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

            //配置处理器
            serverBootstrap.group(boos,work).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))//配置日志级别
                    .childHandler(new NettyServerInit());

            Channel channel = serverBootstrap.bind(8080).sync().channel();
            channel.closeFuture().sync();
        }finally {
            boos.shutdownGracefully();
            work.shutdownGracefully();
        }




    }





}
