package test;

import java.util.HashMap;

public class Different {
	public static void main(String[] args) {
		Different df = new Different();
		boolean result = df.checkSam("This is nowcoder","is This nowcoder");
		System.out.println(result);
	}

	public boolean checkDifferent(String iniString) {
		// write code here
		for (int i = 0; i < iniString.length(); i++) {
			
		}
		return false;
	}

    public String reverseString(String initString) {
        // write code here
    	char[] a = initString.toCharArray();
        for(int i = 0; i < a.length/2; i++){
            char temp = a[i];
            a[i] = a[a.length -1 - i];
            a[a.length -1 - i] = temp;
        }
        initString = initString.valueOf(a);
		return initString;
    }
    
    public boolean checkSam(String stringA, String stringB) {
        // write code here
		char[] a = stringA.toCharArray();
		char[] b = stringB.toCharArray();
		
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		
		for(char c : a){
			if (!hs.containsKey(c)) {
				hs.put(c, 1);
			}else{
				hs.put(c,hs.get(c) + 1);;
			}
		}
		
		for(char c : b){
			if (!hs.containsKey(c)) {
				return false;
			}else{
				hs.put(c,hs.get(c) - 1);;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if (hs.get(a[i]) != 0) {
				return false;
			}
		}
	
         
        return true;
    }
    
	
}
