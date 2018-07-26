package test;

import javax.sql.rowset.CachedRowSet;

public class Test1 {
	
	public static void Combine(char[] c){
		if(c == null)
			return;
		int len = c.length;
		boolean used[] = new boolean[len];
		char cache[] = new char[len];
		int result = len;
 		while(true){
			int index = 0;
			while(used[index]){
				used[index] = false;
				++result;
				if (++index == len) {
					return;
				}
			}
			used[index] = true;
			cache[--result] = c[index];
			System.out.println(new String(cache).substring(result) + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		char[]c = s.toCharArray();
		Combine(c);
	}

}
