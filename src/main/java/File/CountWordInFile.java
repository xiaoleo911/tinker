package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File s = new File("D:/game/a.txt");
		int count = CountWordInFile(s, "abc");
		System.out.println(count);  //4次
	}

	public static int CountWordInFile(File file, String word) {
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = "";
			while(( line = br.readLine()) != null){
				int index = -1;
				while(line.length() >= word.length() && (index = line.indexOf(word)) >= 0){
					count++;
					line = line.substring(word.length() + index);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
		
	}
	
	
}
