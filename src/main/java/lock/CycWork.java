package lock;

import java.util.concurrent.CyclicBarrier;

/**
 * @author:fupeng
 * @date: 2018/7/26 21:09
 */
public class CycWork implements Runnable {


    private CyclicBarrier cyclicBarrier;
    private String name;

    public CycWork(CyclicBarrier cyclicBarrier, String name) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        System.out.println(name + "正在打桩，毕竟不轻松。。。。。");

        try {
            System.out.println(name + "不容易，终于把桩打完了。。。。");
            cyclicBarrier.await();
            Thread.sleep(5000);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println(name + "：其他逗b把桩都打完了，又得忙活了。。。");


    }

}