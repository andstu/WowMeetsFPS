package wowMeetsFPS;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
	
	final Character user = null;
	Character[] otherPlayers;
	final static int PORT = 25565;

	public static void main(String[] args){
		
	}
	
	void connectToServer(SocketAddress ip, int port)
	{
		SocketAddress serverIP = ip; //TODO: Find a way to pick IP
		
		Socket socket = new Socket();
		try
		{
			socket.connect(serverIP,port);
			
			new Thread(new ClientThread(socket,user,otherPlayers)).start();
			
			socket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
