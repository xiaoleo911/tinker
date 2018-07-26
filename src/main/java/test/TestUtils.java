package test;

public class TestUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result;
		try {
			result = maxCommanFactor(2, 12);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int maxCommanFactor(int a, int b) throws Exception{
		if (a < 2 || a >= 100000) {
			return 0;
		}
		if (b < 2 || b >= 1000000) {
			return 0;
		}
		
		int m = a;
		int n = a;
		int count = 0;
		
		while(true){
			while(true){
				if (m % a == 0 && n % a == 0 && m*n/a == b) {
					count++;
				}
				
				if (m * n / a < b) {
					n++;
					continue;
				}
				if (m * n / a > b) {
					break;
				}
			}
			if (m >= n) {
				break;
			}
			m++;
			n = a;
		}
		
		
		return count;
		
	}

}
