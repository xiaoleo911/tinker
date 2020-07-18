package thread;

/**
 * author: fupeng
 * time: 2020-07-18 20:44
 */
public class JoinDemo extends Thread {
    private int i;
    private Thread previousThread; // 上一个线程

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            // 调用上一个线程的join方法，需要等上一个线程执行结束，才继续执行（当num = 0 就是主线程自己）
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i + previousThread.getName());
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }
}