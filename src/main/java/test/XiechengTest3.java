package test;

import java.util.*;

class XiechengTest3 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		String a[] = in.split(",");
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<a.length;i++){
			list.add(Integer.parseInt(a[i]));
		}
		int max = 0;
		
		for(int i = list.size();i>0;i--){
			int result = 0; 
			for(int j = i -1;j>0;j--){
				result = list.get(i-1) - list.get(j-1);
				if (result > max) {
					max = result;
				}
			}
		}
		
		System.out.println(max);

	}
}
