
1.jdk8 默认使用的是并行gc（Parallel gc ）
2.工具的使用：

    java Java 应用的启动程序
    javac JDK 内置的编译工具
    javap 反编译 class 文件的工具
    javadoc 根据 Java 代码和标准注释,自动生成相关的API说明文档
    javah JNI 开发时, 根据 java 代码生成需要的 .h文件。
    extcheck 检查某个 jar 文件和运行时扩展 jar 有没有版本冲突，很少使用
    jdb Java Debugger ; 可以调试本地和远端程序, 属于 JPDA 中的一个 demo 实现, 供
    其他调试器参考。开发时很少使用
    jdeps 探测 class 或 jar 包需要的依赖
    jar 打包工具，可以将文件和目录打包成为 .jar 文件；.jar 文件本质上就是 zip 文件,
    只是后缀不同。使用时按顺序对应好选项和参数即可。
    keytool 安全证书和密钥的管理工具; （支持生成、导入、导出等操作）
    jarsigner JAR 文件签名和验证工具
    policytool 实际上这是一款图形界面工具, 管理本机的 Java 安全策略

 ------------------------------------------------------------- 
     [root@localhost javarun]# jps -l
    7398 sun.tools.jps.Jps   --jps本身命令
    7290 gateway-server-0.0.1-SNAPSHOT.jar  --运行的jar

    [root@localhost javarun]# jps -mlv
    7290 gateway-server-0.0.1-SNAPSHOT.jar
    7438 sun.tools.jps.Jps -mlv -Dapplication.home=/usr/local/java/jdk1.8.0_231 -Xms8m

-------------------------------------------------------------------------
    [root@localhost javarun]# jinfo 7290
    Attaching to process ID 7290, please wait...
    Debugger attached successfully.
    Server compiler detected.
    JVM version is 25.231-b11
    Java System Properties:
 
    java.runtime.name = Java(TM) SE Runtime Environment
    java.vm.version = 25.231-b11
    sun.boot.library.path = /usr/local/java/jdk1.8.0_231/jre/lib/amd64
    java.protocol.handler.pkgs = org.springframework.boot.loader
    java.vendor.url = http://java.oracle.com/
    java.vm.vendor = Oracle Corporation
    path.separator = :
    file.encoding.pkg = sun.io
    java.vm.name = Java HotSpot(TM) 64-Bit Server VM
    sun.os.patch.level = unknown
    sun.java.launcher = SUN_STANDARD
    user.country = CN
    user.dir = /usr/local/java/javarun
    java.vm.specification.name = Java Virtual Machine Specification
    PID = 7290
    java.runtime.version = 1.8.0_231-b11
    java.awt.graphicsenv = sun.awt.X11GraphicsEnvironment
    os.arch = amd64
    java.endorsed.dirs = /usr/local/java/jdk1.8.0_231/jre/lib/endorsed
    line.separator =
    
    java.io.tmpdir = /tmp
    java.vm.specification.vendor = Oracle Corporation
    os.name = Linux
    sun.jnu.encoding = UTF-8
    java.library.path = /usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
    spring.beaninfo.ignore = true
    java.specification.name = Java Platform API Specification
    java.class.version = 52.0
    sun.management.compiler = HotSpot 64-Bit Tiered Compilers
    os.version = 3.10.0-1062.el7.x86_64
    user.home = /root
    user.timezone = Asia/Shanghai
    catalina.useNaming = false
    java.awt.printerjob = sun.print.PSPrinterJob
    file.encoding = UTF-8
    java.specification.version = 1.8
    catalina.home = /tmp/tomcat.6703576751829620327.8088
    user.name = root
    java.class.path = gateway-server-0.0.1-SNAPSHOT.jar
    java.vm.specification.version = 1.8
    sun.arch.data.model = 64
    sun.java.command = gateway-server-0.0.1-SNAPSHOT.jar
    java.home = /usr/local/java/jdk1.8.0_231/jre
    user.language = zh
    java.specification.vendor = Oracle Corporation
    awt.toolkit = sun.awt.X11.XToolkit
    java.vm.info = mixed mode
    java.version = 1.8.0_231
    java.ext.dirs = /usr/local/java/jdk1.8.0_231/jre/lib/ext:/usr/java/packages/lib/ext
    sun.boot.class.path = /usr/local/java/jdk1.8.0_231/jre/lib/resources.jar:/usr/local/java/jdk1.8.0_231/jre/lib/rt.jar:/usr/local/java/jdk1.8.0_231/jre/lib/sunrsasign.jar:/usr/local/java/jdk1.8.0_231/jre/lib/jsse.jar:/usr/local/java/jdk1.8.0_231/jre/lib/jce.jar:/usr/local/java/jdk1.8.0_231/jre/lib/charsets.jar:/usr/local/java/jdk1.8.0_231/jre/lib/jfr.jar:/usr/local/java/jdk1.8.0_231/jre/classes
    java.awt.headless = true
    java.vendor = Oracle Corporation
    catalina.base = /tmp/tomcat.6703576751829620327.8088
    file.separator = /
    java.vendor.url.bug = http://bugreport.sun.com/bugreport/
    sun.io.unicode.encoding = UnicodeLittle
    sun.cpu.endian = little
    sun.cpu.isalist =
    
    VM Flags:
    Non-default VM flags: -XX:CICompilerCount=2 -XX:InitialHeapSize=16777216 -XX:MaxHeapSize=255852544 -XX:MaxNewSize=85262336 -XX:MinHeapDeltaBytes=196608 -XX:NewSize=5570560 -XX:OldSize=11206656 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps
    Command line: 
    --------------------------------------------------------
        
    
    查看gc 的运行情况 
    [root@localhost javarun]# jstat -gc 7290 100 100
    S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT   
    1344.0 1344.0  0.0   819.0  11200.0   9254.9   27656.0    19220.3   34480.0 32880.2 4528.0 4255.8    117    0.200   3      0.099    0.299
    1344.0 1344.0  0.0   819.0  11200.0   9254.9   27656.0    19220.3   34480.0 32880.2 4528.0 4255.8    117    0.200   3      0.099    0.299
    1344.0 1344.0  0.0   819.0  11200.0   9254.9   27656.0    19220.3   34480.0 32880.2 4528.0 4255.8    117    0.200   3      0.099    0.299
    1344.0 1344.0  0.0   819.0  11200.0   9254.9   27656.0    19220.3   34480.0 32880.2 4528.0 4255.8    117    0.200   3      0.099    0.299

---------------------------------------------------------------
    [root@localhost javarun]# jmap -heap 7290 
    Attaching to process ID 7290, please wait...
    Debugger attached successfully.
    Server compiler detected.
    JVM version is 25.231-b11
    
    using thread-local object allocation.
    Mark Sweep Compact GC  使用的gc 版本
    
    Heap Configuration:
    MinHeapFreeRatio         = 40
    MaxHeapFreeRatio         = 70
    MaxHeapSize              = 255852544 (244.0MB)
    NewSize                  = 5570560 (5.3125MB)
    MaxNewSize               = 85262336 (81.3125MB)
    OldSize                  = 11206656 (10.6875MB)
    NewRatio                 = 2
    SurvivorRatio            = 8
    MetaspaceSize            = 21807104 (20.796875MB)
    CompressedClassSpaceSize = 1073741824 (1024.0MB)
    MaxMetaspaceSize         = 17592186044415 MB
    G1HeapRegionSize         = 0 (0.0MB)
    
    Heap Usage:  堆内存
    New Generation (Eden + 1 Survivor Space):
    capacity = 12845056 (12.25MB)
    used     = 10315648 (9.8377685546875MB)  使用
    free     = 2529408 (2.4122314453125MB)   空闲
    80.30831473214286% used                 使用率

    Eden Space: 
    capacity = 11468800 (10.9375MB)
    used     = 9476976 (9.037948608398438MB)
    free     = 1991824 (1.8995513916015625MB)
    82.63267299107143% used
    
    from to 对应的就是 s0 s1
    From Space:
    capacity = 1376256 (1.3125MB)
    used     = 838672 (0.7998199462890625MB)
    free     = 537584 (0.5126800537109375MB)
    60.93866257440476% used

    To Space:
    capacity = 1376256 (1.3125MB)
    used     = 0 (0.0MB)
    free     = 1376256 (1.3125MB)
    0.0% used

    tenured generation:
    capacity = 28319744 (27.0078125MB)
    used     = 19681616 (18.769851684570312MB)
    free     = 8638128 (8.237960815429688MB)
    69.49785986765983% used
    
    15725 interned Strings occupying 2107272 bytes.

--------------------------------------------------
    查看正在执行的状态 及锁信息 
    [root@localhost javarun]# jstack -l 7290
    2021-01-14 16:15:35
    Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.231-b11 mixed mode):
    
    "Attach Listener" #31 daemon prio=9 os_prio=0 tid=0x00007f17b407c800 nid=0x1e0f waiting on condition [0x0000000000000000]
    java.lang.Thread.State: RUNNABLE
    
    Locked ownable synchronizers:
    - None
    
    "DestroyJavaVM" #30 prio=5 os_prio=0 tid=0x00007f17dc009800 nid=0x1c7b waiting on condition [0x0000000000000000]
    java.lang.Thread.State: RUNNABLE
    
    Locked ownable synchronizers:
    - None
    
    "http-nio-8088-AsyncTimeout" #28 daemon prio=5 os_prio=0 tid=0x00007f17dc86e000 nid=0x1c98 waiting on condition [0x00007f17b88c6000]
    java.lang.Thread.State: TIMED_WAITING (sleeping)
    at java.lang.Thread.sleep(Native Method)
    at org.apache.coyote.AbstractProtocol$AsyncTimeout.run(AbstractProtocol.java:1143)
    at java.lang.Thread.run(Thread.java:748)
    
    Locked ownable synchronizers:
    - None
    
    "http-nio-8088-Acceptor-0" #27 daemon prio=5 os_prio=0 tid=0x00007f17dc86b000 nid=0x1c97 runnable [0x00007f17b89c7000]
    java.lang.Thread.State: RUNNABLE
    at sun.nio.ch.ServerSocketChannelImpl.accept0(Native Method)
    at sun.nio.ch.ServerSocketChannelImpl.accept(ServerSocketChannelImpl.java:422)
    at sun.nio.ch.ServerSocketChannelImpl.accept(ServerSocketChannelImpl.java:250)
    - locked <0x00000000f10665d8> (a java.lang.Object)
    at org.apache.tomcat.util.net.NioEndpoint$Acceptor.run(NioEndpoint.java:455)
    at java.lang.Thread.run(Thread.java:748)
    
    Locked ownable synchronizers:
    - None
    
    "http-nio-8088-ClientPoller-0" #26 daemon prio=5 os_prio=0 tid=0x00007f17dc6d9800 nid=0x1c96 runnable [0x00007f17b8ac8000]
    java.lang.Thread.State: RUNNABLE
    at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
    at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
    at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
    at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
    - locked <0x00000000f128a3b8> (a sun.nio.ch.Util$3)
    - locked <0x00000000f128a3a8> (a java.util.Collections$UnmodifiableSet)
    - locked <0x00000000f128a290> (a sun.nio.ch.EPollSelectorImpl)
    at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
    at org.apache.tomcat.util.net.NioEndpoint$Poller.run(NioEndpoint.java:798)
    at java.lang.Thread.run(Thread.java:748)
    
    Locked ownable synchronizers:
    - None
    。。。。。。。。。。
--------------------------------------------------------------------------------

    [root@localhost javarun]# jcmd 7290 help
    7290:
    The following commands are available:
    JFR.stop         查看飞行记录
    JFR.start
    JFR.dump
    JFR.check
    VM.native_memory
    VM.check_commercial_features
    VM.unlock_commercial_features
    ManagementAgent.stop
    ManagementAgent.start_local
    ManagementAgent.start
    VM.classloader_stats
    GC.rotate_log
    Thread.print
    GC.class_stats
    GC.class_histogram
    GC.heap_dump
    GC.finalizer_info
    GC.heap_info
    GC.run_finalization
    GC.run
    VM.uptime    vm运行时间
    VM.dynlibs
    VM.flags
    VM.system_properties
    VM.command_line
    VM.version
    help

--------------------------------------
    开启的参数（默认参数）
    [root@localhost javarun]# jcmd 7290 VM.flags
    7290:
    -XX:CICompilerCount=2 -XX:InitialHeapSize=16777216 -XX:MaxHeapSize=255852544 -XX:MaxNewSize=85262336 -XX:MinHeapDeltaBytes=196608 -XX:NewSize=5570560 -XX:OldSize=11206656 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps
    [root@localhost javarun]# 




3.GC --->>内存管理器
    
    a.为什么会有gc 
        本质上是内存资源的有限性
    b.
    