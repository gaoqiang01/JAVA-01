package netty_gateway;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @param
 * @author silent
 * @time 15:54 2021/2/24
 * @description
 */
public class NettyServerInit extends ChannelInitializer<SocketChannel> {



    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //获取通道
        ChannelPipeline cp = ch.pipeline();


        //配置HTTP编码器
        cp.addLast( new HttpServerCodec());
        //配置HTTP解码器
        cp.addLast(new HttpObjectAggregator(1024 * 1024));
        //配置自定义处理器
        cp.addLast(new NettyServerHandel());

    }
}
