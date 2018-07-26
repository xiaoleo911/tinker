package test;

public class Xor_findDup {
	
	public static int xor_findDup(int[] a){
		int n = a.length;
		int result = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++){
			if(a[i]> 0){
				a[a[i]] = - a[a[i]];
			}else{
				a[-a[i]] = -a[-a[i]];
			}
		}
		for(int i = 1;i<n;i++){
			if(a[i] > 0)
				result = i;
			else
				a[i] = -a[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,1};
		
		
		int missingNum = xor_findDup(a);
		System.out.println(missingNum);
	}

}
