package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread implements Runnable{

	protected Socket socket;
	
	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		BufferedReader buff = null;
		
		try {
			in = (ObjectInputStream) socket.getInputStream();
			buff = new BufferedReader(new InputStreamReader(in));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
