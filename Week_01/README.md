Java字节码
        
    aload_0                            //a* 表表示引用类型
    iconst_0                           //初始化常量0 
    istore        4						//store  ==》》 对应的常量值 
    iinc          4, 1             //iinc  4，1 表示 常量值加1


        0: new           #2                  // class HellByteCode
         3: dup
         4: invokespecial #3                  // Method "<init>":()V                 
         7: astore_1
         8: return
		 // 0，3，4，7，8 对应的是字节码的位置
        LineNumberTable:
        line 11: 0    ->>>对应的new 
        line 13: 8    ->>>对应的return
    
类加载
        
    Java启动程序加载器默认使用是 appclassloader 加载器
    类的生命周长： 加载->使用->卸载；
    Java内存结构： 栈/堆/非堆/自身


1、画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

    Xmn、Xms、Xmx、Xss都是JVM对内存的配置参数，我们可以根据不同需要区修改这些参数，以达到运行程序的最好效果。
    -Xms 堆内存的最小大小，默认为物理内存的1/64
    -Xmx 堆内存的最大大小，默认为物理内存的1/4
    -Xmn 堆内新生代的大小。通过这个值也可以得到老生代的大小：-Xmx减去-Xmn
    -Xss 设置每个线程可使用的内存大小，即栈的大小。在相同物理内存下，减小这个值能生成更多的线程，当然操作系统对一个进程内的线程数还是有限制的，不能无限生成。线程栈的大小是个双刃剑，如果设置过小，可能会出现栈溢出，特别是在该线程内有递归、大的循环时出现溢出的可能性更大，如果该值设置过大，就有影响到创建栈的数量，如果是多线程的应用，就会出现内存溢出的错误。
    -XX:MetaspaceSize 这个JVM参数是指Metaspace扩容时触发FullGC的初始化阈值，也是最小的阈值
    
    图片：https://github.com/gaoqiang01/JAVA-01/blob/main/Week_01/jvm.png
