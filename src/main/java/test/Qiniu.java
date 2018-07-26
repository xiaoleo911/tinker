package test;

import java.util.Scanner;

public class Qiniu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String [] str = sc.nextLine().split(" ");
		int [] a = new int[str.length];
		for(int i = 0;i<str.length;i++){
			a[i] = Integer.parseInt(str[i], 10);
		}
	
		int result = getMaxSum(a);
		System.out.println(result);
		
	}
	
	public static int getMaxSum(int[] A){
		if (A == null) {
			return 0;
		}
		int n = A.length;
		int maxSum = 0;
		int current = A[0];
		
		for(int i =0;i<n;i++){
			if (current < 0 && A[i] > 0) {
				current = A[i];
			}else{
				current += A[i];
			}
			
			if (current > maxSum) {
				maxSum = current;
			}
		}
		return maxSum;
	}

}
