package io.github.lonelyMrZhang.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 创建Bean对象的工厂
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 4:20 下午
 */
public class BeanFactory {

    /**
     * Bean: 在计算机英语中有可重用组件的含义
     * javaBean：用java语言编写的可重用组件，javaBean > 类
     *
     *
     * BeanFactory就是用来创建service和dao对象的
     *
     * 要解藕的创建对象需要以下两步：
     * 1、需要一个配置文件来配置我们的service和dao，配置文件的内容：唯一标识ID=全限定类名（KV健值对）
     * 2、通过读取配置文件中配置，反射创建对象
     *
     *
     * 配置文件可以是xml也可以是properties
     */
    private static Properties properties;
    static {
        try {
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
        } catch (Exception e) {
           throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

}
