package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import common.Data;

public class ServerThread implements Runnable{

	protected Socket socket;
	private Character[] players;
	
	public ServerThread(Socket socket, Character[] players) {
		this.socket = socket;
		this.players = players;
	}

	@Override
	public void run() {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		BufferedReader buff = null;
		Character curr;
		Data<Character> info = null;
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
			info = (Data<Character>) in.readObject();
			curr = info.getInfo();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
