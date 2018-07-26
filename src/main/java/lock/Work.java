package lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author:fupeng
 * @date: 2018/7/26 21:02
 */
public class Work implements Runnable {

    private CountDownLatch downLatch;
    private String name;

    public Work(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException ie) {
        }
        System.out.println(this.name + "活干完了！");
        this.downLatch.countDown();

    }

    private void doWork() {
        System.out.println(this.name + "正在干活!");
    }

}
