package singleton;

/**
 * 静态内部类方式
 *
 * 由于双重检验锁方式的开销过大，所以可以使用静态内部类的方式来代替它。
 * 同样是线程安全，在系统加载Singleton时，我们所需的Instance并不会被初始化，因为利用了静态内部类的特性，只有在SingletonHolder被主动调用时，才会生成实例并返回。
 *
 * @author:fupeng
 * @date: 2018/7/26 21:45
 */
public class SingletonDemo4 {

    private static class SingletonHolder {
        private static final SingletonDemo4 INSTANCE = new SingletonDemo4();
    }

    private SingletonDemo4() {
    }

    public static final SingletonDemo4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
