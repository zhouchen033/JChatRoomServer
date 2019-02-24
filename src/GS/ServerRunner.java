package GS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Branch - dolphin by Raymond
		// supposed to be Raymond's working branch 
		try {
			ServerSocket serverSocket=new ServerSocket(8888);
			Socket socket = null;
			System.out.println("=== Server is starting ===");
			
			while (true) {
				socket=serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				InetAddress address = socket.getInetAddress();
				System.out.println("Current Client IP: "+address.getHostAddress());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
