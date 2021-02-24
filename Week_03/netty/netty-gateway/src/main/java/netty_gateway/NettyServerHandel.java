package netty_gateway;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @param
 * @author silent
 * @time 15:57 2021/2/24
 * @description
 */
public class NettyServerHandel extends ChannelInboundHandlerAdapter {


    private HttpOutboundHandler outboundHandler;

    public NettyServerHandel() {
        outboundHandler= new HttpOutboundHandler();
    }

    /**
     * 读取客户端传送的请求信息  入栈
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        FullHttpRequest fullRequest = (FullHttpRequest) msg;

        outboundHandler.msgHandle(fullRequest,ctx);

    }
    /**
     *
     * 读取完成后刷新管道
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
