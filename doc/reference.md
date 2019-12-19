# 前言

引用类型：强、软、弱、虚
 
 #### 1）强引用
 任何时候都不会被垃圾回收器回收，如果内存不足，抛出OutOfMemoryError。
 
 #### 2）软引用 SoftReference
 只有在内存将满的时候才会被垃圾回收器回收，如果还有可用内存，垃圾回收器不会回收。适合做高速缓存，当系统内存不足的时候，缓存中的内容是可以被释放的
 
 #### 3）弱引用 WeakReference
 只要垃圾回收器运行，就肯定会被回收，不管还有没有可用内存。
 
 #### 4）虚引用 PhantomReference
 被虚引用完全不会引用其所指向的对象的生命周期，也就是说一个 Java 对象是否被回收和指向它的虚引用完全没有任何关系。也不能通过虚引用来得到其指向的对象（其 get 方法直接返回 null）。
 
 #### 5）引用队列 ReferenceQueue
 当gc（垃圾回收线程）准备回收一个对象时，如果发现它还仅有软引用(或弱引用，或虚引用)指向它，就会在回收该对象之前，把这个软引用（或弱引用，或虚引用）加入到与之关联的引用队列（ReferenceQueue）中。如果一个软引用（或弱引用，或虚引用）对象本身在引用队列中，就说明该引用对象所指向的对象被回收了。
 
 ReferenceQueue名义上是一个队列，但实际内部并非有实际的存储结构，它的存储是依赖于内部节点之间的关系来表达。可以理解为queue是一个类似于链表的结构，这里的节点其实就是reference本身。可以理解为queue为一个链表的容器，其自己仅存储当前的head节点，而后面的节点由每个reference节点自己通过next来保持即可。。
 
 当软引用（或弱引用，或虚引用）对象所指向的对象被回收了，那么这个引用对象本身就没有价值了，如果程序中存在大量的这类对象（注意，我们创建的软引用、弱引用、虚引用对象本身是个强引用，不会自动被gc回收），就会浪费内存。因此我们这就可以手动回收位于引用队列中的引用对象本身。
 
 #### 6）WeakHashMap
 WeakHashMap 的实现原理简单来说就是HashMap里面的条目 Entry继承了 WeakReference，那么当 Entry 的 key 不再被使用（即，引用对象不可达）且被 GC 后，
 那么该 Entry 就会进入到 ReferenceQueue 中。当我们调用WeakHashMap 的get和put方法会有一个副作用，即清除无效key对应的Entry。这个过程就和上面的代码很类似了，
 首先会从引用队列中取出一个Entry对象，然后在HashMap中查找这个Entry对象的位置，最后把这个 Entry 从 HashMap中删除，这时key和value对象都被回收了。重复这个过程直到队列为空。

 #### 7） ThreadLocalMap
 
 #### 参考文章
 * [Reference 、ReferenceQueue 详解](https://www.jianshu.com/p/f86d3a43eec5)
 * [话说ReferenceQueue](http://hongjiang.info/java-referencequeue/)
 