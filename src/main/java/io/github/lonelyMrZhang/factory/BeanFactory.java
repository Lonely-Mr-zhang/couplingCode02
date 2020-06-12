package io.github.lonelyMrZhang.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

///**
// * 初级版本--多例版本
// *
// * @description: 创建Bean对象的工厂
// * @author: lonely.mr.zhang
// * @date: 2020/6/12 4:20 下午
// */
//public class BeanFactory {
//
//    /**
//     * 分析：
//     * Bean: 在计算机英语中有可重用组件的含义
//     * javaBean：用java语言编写的可重用组件，javaBean > 类
//     *
//     * BeanFactory就是用来创建service和dao对象的
//     *
//     * 要解藕的创建对象需要以下两步：
//     * 1、需要一个配置文件来配置我们的service和dao，配置文件的内容：唯一标识ID=全限定类名（KV健值对）
//     * 2、通过读取配置文件中配置，反射创建对象
//     *
//     * 配置文件可以是xml也可以是properties
//     */
//
//    private static Properties properties;
//    //初始化配置文件对象
//    static {
//        try {
//            properties = new Properties();
//            //避免使用 new File()的方式，因为文件路径不好控制
//            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
//            properties.load(in);
//        } catch (Exception e) {
//           throw new ExceptionInInitializerError("初始化properties失败！");
//        }
//    }
//
//    /**
//     * 根据beanName获取Bean对象
//     *
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
//
//}

/**
 * 升级版本--单例模式
 */
public class BeanFactory{

    private static Properties properties;

    //定义一个Map当作容器，存储我们要在项目中创建的对象
    private static Map<String,Object> beans;


    //初始化配置文件对象
    static {
        try {
            properties = new Properties();
            //避免使用 new File()的方式，因为文件路径不好控制
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);

            //初始化容器
            beans = new HashMap<String, Object>();
            //取出配置温江中的所有key
            Enumeration<Object> keys = properties.keys();
            //遍历所有key，将该key及其对应创建出来的对象存入容器中
            while (keys.hasMoreElements()){
                //获取key
                String key = keys.nextElement().toString();
                //获取全路径类名
                String beanPath = properties.getProperty(key);
                //创建对象
                Object value = Class.forName(beanPath).newInstance();
                //存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /*
     * 根据beanName获取Bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

}

