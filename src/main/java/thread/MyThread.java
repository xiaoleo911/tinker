package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: fupeng
 * @date: 2020/6/16 20:20
 */
class MyThread extends Thread {

    public static void main(String[] args) {
        try {
            MyThread.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * lockInterruptibly 响应中断
     * @throws Exception
     */
    public static void test1() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                lock.lock();
	        	try {
					lock.lockInterruptibly();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }

}