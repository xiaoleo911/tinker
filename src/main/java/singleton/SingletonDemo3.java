package singleton;

/**
 * 双重检验锁
 *
 * 使用双重检验锁来保证单例模式的线程安全，虽然说效率低下了一点，但是毕竟靠谱啊！
 *
 * @author:fupeng
 * @date: 2018/7/26 21:45
 */
public class SingletonDemo3 {
    private static SingletonDemo3 instance;

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() {
        //若已经创建实例，那么就直接返回
        if (instance == null) {
            synchronized (SingletonDemo3.class) {
                //若没有创建实例，只有一个线程能够进入同步块，创建实例，后面被阻塞的线程再次进入该同步块时，对象已经被创建，则直接返回。
                if (instance == null) {
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }
}
