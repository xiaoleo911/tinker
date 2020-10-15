package singleton;

/**
 * 懒汉式
 * <p>
 * 懒汉式单例模式呢，我们的实例在一开始时是没有生成的，而是当被调用的时候才会生成，这种延迟加载特性可以用在配置文件之类的功能上。
 * 但是这里会有并发问题，当多个线程都调用getInstance时，就会生成多个实例。
 *
 * @author:fupeng
 * @date: 2018/7/26 21:45
 */
public class SingletonDemo1 {

    private static SingletonDemo1 instance;

    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo1();
        }
        return instance;
    }


}
