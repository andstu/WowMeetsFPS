package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import wowMeetsFPS.Character;

public class GameManager {
	static final int PORT = 25565;
	
	public static void main(String args[]) {
		System.out.println("Server is a go");
		//Initialize Socket Variables
		ServerSocket serverSocket = null;
		Socket socket = null;
		HashMap<String, Character> players = new HashMap<String, Character>();
	
		try {
			serverSocket = new ServerSocket(PORT);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println("Waiting....");
				socket = serverSocket.accept();
				System.out.println("Connected!");
			}catch(IOException e) {
				System.out.println("Failed...");
				//System.out.println("I/O Error: " + e);
			}
			
			//New Thread for Every incoming connection request
			new Thread(new ServerThread(socket, players)).start();
		}
	}
	
	
	
}
