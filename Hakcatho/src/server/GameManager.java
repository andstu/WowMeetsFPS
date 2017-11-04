package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameManager {
	static final int PORT = 25565;
	
	public static void main(String args[]) {

		//Initialize Socket Variables
		ServerSocket serverSocket = null;
		Socket socket = null;
	
		try {
			serverSocket = new ServerSocket(PORT);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				socket = serverSocket.accept();
			}catch(IOException e) {
				System.out.println("I/O Error: " + e);
			}
			
			//New Thread for Every incoming connection request
			new Thread(new ClientThread(socket)).start();
		}
		
	}
	
}
