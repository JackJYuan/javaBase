
# 前言

什么是代理,在Design patterns In java这个本书中是这样描述的，简单的说就是为某个对象提供一个代理，以控制对这个对象的访问。在不修改源代码的基础上做方法增强,代理是一种设计模式，又简单的分为两种。

静态代理:代理类和委托类在代码运行前关系就确定了,也就是说在代理类的代码一开始就已经存在了。
动态代理:动态代理类的字节码在程序运行时的时候生成。

## 动态代理Demo

### JDK动态代理
 JDK动态代理的实现是使用的是java反射机制在运行时根据一组接口定义，使用Proxy、InvocationHandler等工具类去生成一个代理类和代理类实例。
 
#### 类图
 ![avatar](https://upload-images.jianshu.io/upload_images/4252237-44643999582a70a9.png?imageMogr2/auto-orient/strip|imageView2/2/w/824)
 
#### 应用
* Spring AOP
* RPC框架
* Mybatis底层实现


### CGLIB
JDK动态代理的机制有个鲜明的特点是：某个类必须有实现的接口，而生成的代理类也只能代理某个类接口定义的方法。那么如果一个类没有实现接口怎么办呢？这就有CGLIB的诞生了,前面说的JDK的代理类的实现方式是实现相关的接口成为接口的实现类,那么我们自然而然的可以想到用继承的方式实现相关的代理类。
CGLIB 无法代理final修饰的类和方法.

#### 类图

#### 应用
* Spring AOP
* hibernate中session.load采用的是cglib实现的

## Aspectj

## Spring Aop

Spring代理实际上是对JDK代理和CGLIB代理做了一层封装，并且引入了AOP概念:Aspect、advice、joinpoint等等，同时引入了AspectJ中的一些注解@pointCut,@after,@before等等.Spring Aop严格的来说都是动态代理，所以实际上Spring代理和Aspectj的关系并不大.

## 参考文章
* [简书文章-JDK动态代理全面解析](https://www.jianshu.com/p/1a76e516aa53)
* [简书文章-Java JDK代理、CGLIB、AspectJ代理分析比较](https://www.jianshu.com/p/a501d53aeb6a)
* [菜鸟教程-CGLIB(Code Generation Library) 介绍与原理](https://www.runoob.com/w3cnote/cglibcode-generation-library-intro.html)