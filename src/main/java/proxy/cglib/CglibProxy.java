package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: fupeng
 * @date: 2020/9/29 9:32
 */
public class CglibProxy implements MethodInterceptor {

    // 初始化Enhancer对象
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 指定生成的代理类的父类
        enhancer.setSuperclass(clazz);
        // 设置Callback对象
        enhancer.setCallback(this);
        // 通过ASM字节码技术动态创建子类实例
        return enhancer.create();

    }

    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     *
     * @param obj    "this", the enhanced object
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param proxy  used to invoke super (non-intercepted method); may be called
     *               as many times as needed
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @see MethodProxy
     */
    // 实现MethodInterceptor接口的intercept()方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("前置处理");
        Object result = proxy.invokeSuper(obj, args); // 调用父类中的方法
        System.out.println("后置处理");
        return result;
    }

}
