package test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(){
			public void run(){
				print();
			}
		};
		t.run();
		System.out.println("MT");
		
		
		Hashtable<Integer, String> hashtable = new Hashtable<Integer,String>();
		hashtable.put(1,"1");
		hashtable.put(5,"2");
		hashtable.put(2,"3");
		hashtable.put(9,"4");
		Enumeration<Integer> keys = hashtable.keys();
		while(keys.hasMoreElements()){
			System.out.println(keys.nextElement());
		}
		
		Map<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "1");
		map.put(4, "2");
		map.put(2, "3");
		map.put(15, "4");
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
		
	}
	static void print(){
		
		System.out.println("DP");
	}
	
	Map map = new HashMap<>();
}
