package test;

public class CTest implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println("thread开始sleep");
            Thread.sleep(3000);
            System.out.println("thread结束sleep");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        CTest c = new CTest();
        Thread thread = new Thread(c);
        thread.start();
        try {
            thread.join(2000);
            System.out.println("join开始执行！");


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

