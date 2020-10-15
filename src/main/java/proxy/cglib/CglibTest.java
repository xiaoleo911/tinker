package proxy.cglib;

/**
 * cglib 动态代理
 *
 * @author: fupeng
 * @date: 2020/9/28 9:45
 */
public class CglibTest {

    public String method(String str) {
        System.out.println(str);
        return "CGLibTest.method():" + str;
    }

    /**
     * 输出如下：
     * <p>
     * 前置处理
     * test
     * 后置处理
     * CGLibTest.method():test
     */
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        // 生成CBLibTest的代理对象
        CglibTest proxyImp = (CglibTest) proxy.getProxy(CglibTest.class);
        // 调用代理对象的method()方法
        String result = proxyImp.method("test");
        System.out.println(result);
    }

}
