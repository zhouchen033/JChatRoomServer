package GS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		
		try {
			is = socket.getInputStream();
			isr=new InputStreamReader(is);//将字节流包装为字符流
			br=new BufferedReader(isr);//为输入流添加缓冲
			String info = null;
			while((info=br.readLine())!=null){
				System.out.println("Client says: "+info);
			}
			socket.shutdownInput();//关闭输入流
			os = socket.getOutputStream();
			pw = new PrintWriter(os);//包装成打印流
			pw.write("Welcome from server");
			pw.flush();
			} catch (IOException e){
				e.printStackTrace();
			} finally {
				try {
					if(pw!=null)
						pw.close();
					if(os!=null)
						os.close();
					if(br!=null)
						br.close();
					if(isr!=null)
						isr.close();
					if(is!=null)
						is.close();
					if(socket!=null)
						socket.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
			}
		
	}
}
