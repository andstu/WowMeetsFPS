package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

import wowMeetsFPS.Character;
import wowMeetsFPS.Data;

public class ServerThread implements Runnable{

	protected Socket socket;
	private HashMap<String, Character> players;
	
	public ServerThread(Socket socket, HashMap<String, Character> players) {
		this.socket = socket;
		this.players = players;
	}

	@Override
	public void run() {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		Character curr;
		Data<Character> info = null;
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
			info = (Data<Character>) in.readObject();
			curr = info.getInfo();
			System.out.println(curr.getID());
			players.put(curr.getID(), curr);
			
			out = new ObjectOutputStream(socket.getOutputStream());
			LinkedList<Character> toSend = new LinkedList<Character>();

			for(String s: players.keySet()) {
				if(s.equals(curr.getID())) continue;
				toSend.add(players.get(s));
			}
			out.writeObject(new Data<LinkedList<Character>>(toSend));
			socket.close();
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
