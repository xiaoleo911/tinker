package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {

	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			Socket socket = new Socket("localhost", 2000);
			System.out.println("client");
			// 获取输入流输出流
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			// 向服务器发送数据
			pw.println("Hello");
			String s = null;
			while (true) {
				s = br.readLine();
				if (s != null) {
					break;
				}
			}
			System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


}
