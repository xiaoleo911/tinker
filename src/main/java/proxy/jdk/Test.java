package proxy.jdk;

/**
 * jdk 动态代理
 *
 * @author: fupeng
 * @date: 2020/9/28 9:39
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        DemoInvokerHandler demoInvokerHandler = new DemoInvokerHandler(subject);

        // 获取代理类
        Subject proxy = (Subject) demoInvokerHandler.getProxy();

        // 调用代理对象的方法，它会调用DemoInvokerHandler.invoke()方法
        proxy.operation();
    }


}
