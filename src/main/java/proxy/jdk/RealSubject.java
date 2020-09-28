package proxy.jdk;

/**
 * @author: fupeng
 * @date: 2020/9/28 9:31
 */
public class RealSubject implements Subject {

    public void operation() {
        System.out.println("real subject run ...");
    }

}
