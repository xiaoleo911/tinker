package test;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("last" + run());
	}
	
	public static int run(){
		int i = 0;
		
		try {
			i++;
			return ++i;
		} finally {
			// TODO: handle finally clause
			System.out.println(++i);
		}
		
	}

}
