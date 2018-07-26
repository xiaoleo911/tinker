package test;

public class FindInteger {
	
	public static int findInteger(int a[]){
		int x,y;
		x = y = 0;
		do{
			x = a[a[x]];
			y = a[y];
		}while(x!=y);
		x = 0;
		do{
			x = a[x];
			y = a[y];
		}while(x!=y);
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,1,3,4};
		int missingNum = findInteger(a);
		System.out.println(missingNum);
	}

}
