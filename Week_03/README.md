什么是高性能？
    
    高并发用户（Concurrent Users）
    ·在同一时间点有大量的用户并发的访问使用

    高吞吐量（Throughout）
    ·每秒的请求数/交易数 

    低延迟（Latency）
    ·系统延迟跟请求响应时间的区别 ： 延迟说的是系统内部的，请求进入系统在出去在系统侧进入和出去计算的差值
                                请求响应时间，说的是调用方发送请求到回来的时间




高性能的弊端：

    1、系统复杂度 x10以上
    2、建设与维护成本++++
    3、故障或 BUG 导致的破坏性 x10以上

    应对策略： 稳定性建设（混沌工程）



TCP 建立连接的3次握手 4次挥手

    三次握手：
        tcp简历连接一定是客户端（指的是先发起的一方）连接服务器端
        客户端 ：你在不在？
        服务器 ：我在，你在不在？
        客户端 ： 我在可以传输。。。

    四次挥手 :
        客户端 : 断了吧 ？
        服务器端：好，断了吧，确认断了吧？
        客户端 ： 确认了，断了吧
        服务器端 ： 好，断了！


API 网关
    
    网关分类： 流量网关 / 业务网关
        流量网关作用：稳定性安全性的处理
               全局性流控
               日志统计
               防止 SQL 注入
               防止 Web 攻击
               屏蔽工具扫描
               黑白 IP 名单
               证书/加解密处理

        业务网关：提供更好的服务
               服务级别流控
               服务降级与熔断
               路由与负载均衡、灰度策略
               服务过滤、聚合与发现
               权限验证与用户等级策略
               业务规则与参数校验
               多级缓存策略


    网关的功能：
        请求接入，业务聚合，中介策略，统一管理。
    
    
    