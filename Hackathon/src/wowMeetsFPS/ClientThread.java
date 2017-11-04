package wowMeetsFPS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread implements Runnable{

	protected Socket socket;
	protected Character user;
	protected Character[] otherUsers;
	
	public ClientThread(Socket socket, Character user, Character[] otherUsers) {
		this.socket = socket;
		this.user = user;
		this.otherUsers = otherUsers;
	}
	
	@Override
	public void run() {
		
		try {
			ObjectOutputStream infoToServer = new ObjectOutputStream(socket.getOutputStream());
			infoToServer.writeObject(new Data<Character>(user));
			
			ObjectInputStream infoFromServer = new ObjectInputStream(socket.getInputStream());
			Data<Character[]> otherPlayers = (Data<Character[]>) infoFromServer.readObject();
			Character[] otherPlayersArray = otherPlayers.getInfo();
			for(int i = 0; i < otherPlayersArray.length; i++)
			{
				this.otherUsers[i] = otherPlayersArray[i];
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
