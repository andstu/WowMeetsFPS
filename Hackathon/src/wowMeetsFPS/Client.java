package wowMeetsFPS;
import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Timer;
import java.util.TimerTask;

public class Client {
	
	String username;
	static Character[] otherPlayers;
	static Character user;
	static Map map;
	final static int PORT = 25565;
	static Timer timer = new Timer();
	static TimerTask tasks = new TimerTask() {
		@Override
		public void run() {
			map.performAction();
			map.updateMap(user, otherPlayers);
			connectToServer("127.0.0.1",PORT, user);
		}
		
	};
	public static void start() {
		timer.scheduleAtFixedRate(tasks, 0, 50);
	}
	public static void main(String[] args){
		System.out.println("Server is a go");
		user = new Tank("Andrew" + Math.random()*10); //Initalize Character
		map = new Map(null, user, otherPlayers);
		connectToServer("127.0.0.1",PORT, user);
		start();
	}	
	static void connectToServer(String ip, int port, Character user)
	{
		try
		{
			Socket socket = new Socket(ip,port);
			System.out.println("Client has connected to the server");
			new Thread(new ClientThread(socket,user,otherPlayers)).start();
			
			socket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
