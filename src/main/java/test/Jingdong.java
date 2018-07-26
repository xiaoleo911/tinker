package test;

import java.util.Scanner;

public class Jingdong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		Integer a = s.nextInt();
		int result = 0;
		for(int i = 2; i < a; i++ ){
			int temp = a;
			for(int j = i; j <= a; j++){
				result += temp%i; 
				temp = temp/i;
				if (temp == 0){
					break;
				}
			}
			System.out.println(result);
		}
		System.out.println(result + "/" + (a-2));
	}
	

}
