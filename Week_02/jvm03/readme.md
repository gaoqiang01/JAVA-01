采用GCLogAnalysis执行操作测试用例 （默认内存16g）

    -Xloggc:gc.demo.log  打印日志
    -XX:+PrintGCDetails  打印程序执行的详细
    -XX:+PrintGCDateStamps 打印时间戳


1.分配不同的堆执行结果

    java -XX:+PrintGCDetails GCLogAnalysis -->>>> 17636
    java -Xmx512m -XX:+PrintGCDetails -XX:+UseParallelGC  GCLogAnalysis -->>> 8732
    java -Xmx1g -XX:+PrintGCDetails -XX:+UseParallelGC  GCLogAnalysis -->>>13472
    java -Xmx2g -XX:+PrintGCDetails -XX:+UseParallelGC  GCLogAnalysis  -->>>14644
    java -Xmx4g -XX:+PrintGCDetails -XX:+UseParallelGC  GCLogAnalysis  ->>>>16891
    java -Xmx8g -XX:+PrintGCDetails -XX:+UseParallelGC  GCLogAnalysis  ->>>>17265
    


2.为什么会出现内存溢出
    
    java -Xmx256m -XX:+PrintGCDetails -XX:+UseParallelGC  GCLogAnalysis -->>> OutOfMemoryError
        
    [GC (Allocation Failure) [PSYoungGen: 65024K->10750K(75776K)] 65024K->20171K(249344K), 0.0040642 secs] [Times: user=0.05 sys=0.11, real=0.01 secs]
    [GC (Allocation Failure) [PSYoungGen: 75774K->10739K(76288K)] 85195K->40778K(249856K), 0.0057507 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 76275K->10736K(76288K)] 106314K->63437K(249856K), 0.0060917 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 76046K->10745K(76288K)] 128747K->84132K(249856K), 0.0070070 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [GC (Allocation Failure) [PSYoungGen: 76281K->10751K(76288K)] 149668K->106175K(249856K), 0.0058368 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 76287K->10751K(40448K)] 171711K->127656K(214016K), 0.0050764 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 40331K->18486K(58368K)] 157237K->137369K(231936K), 0.0037296 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [GC (Allocation Failure) [PSYoungGen: 47914K->25283K(58368K)] 166797K->147359K(231936K), 0.0051475 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 54925K->28235K(58368K)] 177001K->154768K(231936K), 0.0049531 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 57860K->16388K(58368K)] 184392K->162458K(231936K), 0.0056558 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
    [Full GC (Ergonomics) [PSYoungGen: 16388K->0K(58368K)] [ParOldGen: 146070K->138001K(175104K)] 162458K->138001K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0208534 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [GC (Allocation Failure) [PSYoungGen: 29694K->9400K(58368K)] 167696K->147402K(233472K), 0.0020240 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 38944K->8420K(58368K)] 176945K->155733K(233472K), 0.0033259 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 8420K->0K(58368K)] [ParOldGen: 147312K->149084K(175104K)] 155733K->149084K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0263475 secs] [Times: user=0.16 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29696K->0K(58368K)] [ParOldGen: 149084K->156197K(175104K)] 178780K->156197K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0238761 secs] [Times: user=0.14 sys=0.02, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29650K->0K(58368K)] [ParOldGen: 156197K->161911K(175104K)] 185848K->161911K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0196699 secs] [Times: user=0.14 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29338K->0K(58368K)] [ParOldGen: 161911K->166535K(175104K)] 191250K->166535K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0189698 secs] [Times: user=0.14 sys=0.01, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29305K->0K(58368K)] [ParOldGen: 166535K->172251K(175104K)] 195840K->172251K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0214758 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29696K->3837K(58368K)] [ParOldGen: 172251K->174965K(175104K)] 201947K->178802K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0216647 secs] [Times: user=0.14 sys=0.02, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29596K->6580K(58368K)] [ParOldGen: 174965K->175023K(175104K)] 204561K->181604K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0206469 secs] [Times: user=0.17 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29561K->12185K(58368K)] [ParOldGen: 175023K->174620K(175104K)] 204585K->186806K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0201912 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29298K->12623K(58368K)] [ParOldGen: 174620K->175000K(175104K)] 203918K->187623K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0261754 secs] [Times: user=0.17 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29065K->16155K(58368K)] [ParOldGen: 175000K->174221K(175104K)] 204065K->190376K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0243532 secs] [Times: user=0.16 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29696K->16800K(58368K)] [ParOldGen: 174221K->174576K(175104K)] 203917K->191376K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0198283 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29382K->19715K(58368K)] [ParOldGen: 174576K->174942K(175104K)] 203959K->194657K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0260654 secs] [Times: user=0.16 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29475K->22653K(58368K)] [ParOldGen: 174942K->175070K(175104K)] 204418K->197724K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0193795 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29503K->25005K(58368K)] [ParOldGen: 175070K->174656K(175104K)] 204574K->199662K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0214411 secs] [Times: user=0.14 sys=0.01, real=0.01 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29328K->27227K(58368K)] [ParOldGen: 174656K->174924K(175104K)] 203984K->202151K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0192740 secs] [Times: user=0.03 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29238K->27402K(58368K)] [ParOldGen: 174924K->174924K(175104K)] 204162K->202326K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0023178 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29684K->27022K(58368K)] [ParOldGen: 174924K->174733K(175104K)] 204608K->201756K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0206863 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29683K->27095K(58368K)] [ParOldGen: 174733K->174996K(175104K)] 204417K->202091K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0198348 secs] [Times: user=0.16 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29114K->27619K(58368K)] [ParOldGen: 174996K->174996K(175104K)] 204110K->202616K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0025229 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29446K->28384K(58368K)] [ParOldGen: 174996K->174914K(175104K)] 204442K->203298K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0304235 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29342K->29003K(58368K)] [ParOldGen: 174914K->174914K(175104K)] 204256K->203917K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0088922 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29695K->29467K(58368K)] [ParOldGen: 174914K->174721K(175104K)] 204609K->204189K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0150748 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29633K->29503K(58368K)] [ParOldGen: 174721K->174721K(175104K)] 204355K->204225K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0095857 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29575K->29539K(58368K)] [ParOldGen: 174721K->174721K(175104K)] 204297K->204261K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0129780 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29683K->29611K(58368K)] [ParOldGen: 174721K->174721K(175104K)] 204405K->204333K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0130309 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29635K->29467K(58368K)] [ParOldGen: 175009K->175009K(175104K)] 204644K->204477K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0148232 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29686K->29485K(58368K)] [ParOldGen: 175009K->174721K(175104K)] 204696K->204207K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0141828 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29606K->29539K(58368K)] [ParOldGen: 174721K->174721K(175104K)] 204328K->204261K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0064198 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29692K->29611K(58368K)] [ParOldGen: 174721K->174721K(175104K)] 204414K->204333K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0042058 secs] [Times: user=0.03 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29660K->29509K(58368K)] [ParOldGen: 175068K->174574K(175104K)] 204728K->204084K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0122786 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29665K->29337K(58368K)] [ParOldGen: 174574K->174574K(175104K)] 204240K->203911K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0062667 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29604K->29531K(58368K)] [ParOldGen: 175042K->174574K(175104K)] 204647K->204106K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0062705 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29675K->29603K(58368K)] [ParOldGen: 174574K->174574K(175104K)] 204250K->204178K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0030954 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29680K->29459K(58368K)] [ParOldGen: 175079K->174596K(175104K)] 204760K->204056K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0146182 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29613K->29037K(58368K)] [ParOldGen: 174596K->175091K(175104K)] 204210K->204128K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0067991 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29679K->29079K(58368K)] [ParOldGen: 175091K->174659K(175104K)] 204770K->203738K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0048800 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29666K->29633K(58368K)] [ParOldGen: 174659K->174659K(175104K)] 204326K->204292K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0068314 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 29633K->29633K(58368K)] [ParOldGen: 175056K->174659K(175104K)] 204690K->204292K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0026029 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Allocation Failure) [PSYoungGen: 29633K->29633K(58368K)] [ParOldGen: 174659K->174640K(175104K)] 204292K->204273K(233472K), [Metaspace: 2637K->2637K(1056768K)], 0.0213371 secs] [Times: user=0.14 sys=0.02, real=0.03 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
    at GCLogAnalysis.main(GCLogAnalysis.java:25)
    Heap
    PSYoungGen      total 58368K, used 29696K [0x00000000fab00000, 0x0000000100000000, 0x0000000100000000)
    eden space 29696K, 100% used [0x00000000fab00000,0x00000000fc800000,0x00000000fc800000)
    from space 28672K, 0% used [0x00000000fe400000,0x00000000fe400000,0x0000000100000000)
    to   space 28672K, 0% used [0x00000000fc800000,0x00000000fc800000,0x00000000fe400000)
    ParOldGen       total 175104K, used 174640K [0x00000000f0000000, 0x00000000fab00000, 0x00000000fab00000)
    object space 175104K, 99% used [0x00000000f0000000,0x00000000faa8c0b8,0x00000000fab00000)
    Metaspace       used 2667K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 294K, capacity 386K, committed 512K, reserved 1048576K 


    在执行了n次young gc 之后一直在执行full gc 直至内存消耗完没有内存可用（整个old区对象回收不掉，在新创建对象的时候没有内存可用）
        
3.UseParallelGC 初始堆内存2g 内存执行过程
    
    --->>>2g-UseParallelGC.png 

4.同样的内存分配及同样的堆内存设置不同的gc 的效率
        
    并行gc
    java -Xmx1g -Xms1g  -XX:+UseParallelGC  GCLogAnalysis   --->>> 16235
    串行
    java -Xmx1g -Xms1g  -XX:+UseSerialGC  GCLogAnalysis     --->>> 15863
    cms
    java -Xmx1g -Xms1g  -XX:+UseConcMarkSweepGC  GCLogAnalysis ---->>>16782
    g1
    java -Xmx1g -Xms1g  -XX:+UseG1GC  GCLogAnalysis    --->>>14545

5.不通过的gc 在不同的内存分配下 的执行效果 （不考虑程序运行误差的情况下）
    
    -->>>gc对比.png

6.gc内存分析得到的结论
    
    在jdk 8 情况下运行的gc效率对比(内存分配为1g,2g 的情况下)
    ParallelGC  >  CMSGC >  SerialGC >  G1GC

    当把内存拉大到8g 效率 
    G1GC  > CMSGC >  ParallelGC>  SerialGC
    
    
