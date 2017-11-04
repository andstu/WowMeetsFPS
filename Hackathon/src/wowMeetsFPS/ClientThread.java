package wowMeetsFPS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import common.Character;

public class ClientThread implements Runnable{

	protected Socket socket;
	protected Character user;
	
	public ClientThread(Socket socket, Character user) {
		this.socket = socket;
		this.user = user;
	}
	
	@Override
	public void run() {
		
		try {
			ObjectOutputStream infoToServer = new ObjectOutputStream(socket.getOutputStream());
			infoToServer.writeObject(new Data<Character>(user));
			
			ObjectInputStream infoFromServer = new ObjectInputStream(socket.getInputStream());
			Data<Character[]> otherPlayers = (Data<Character[]>) infoFromServer.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
