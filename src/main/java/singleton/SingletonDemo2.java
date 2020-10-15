package singleton;

/**
 * 饿汉式
 * <p>
 * 饿汉式单例模式呢就如它的名字一样，事先就将对象准备好，来一个调用就直接将instance给对方。饿汉式本身是线程安全的，但是一开始就要加载，会浪费许多空间。
 *
 * @author:fupeng
 * @date: 2018/7/26 21:45
 */
public class SingletonDemo2 {

    private static final SingletonDemo2 instance = new SingletonDemo2();

    private SingletonDemo2() {
    }

    public static SingletonDemo2 getInstance() {
        return instance;
    }


}
