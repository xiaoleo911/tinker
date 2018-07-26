package test;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 a = new Thread1();
		Thread2 b = new Thread2();
		new Thread(a).start();
		new Thread(b).start();
	}
	
	

	
}
class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("1.run");
		System.out.println("1.end");
	}
	
}


class Thread2 implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("2.run");
		System.out.println("2.end");
	}
	
}
