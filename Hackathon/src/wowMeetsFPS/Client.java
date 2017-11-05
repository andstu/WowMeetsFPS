package wowMeetsFPS;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			
			Thread thread = new Thread(new Runnable() {

			    @Override
			    public void run() {
			         connectToServer("127.0.0.1",PORT, user);       
			    }
			            
			});
			        
			thread.start();
		}
		
	};
	public static void start() {
		timer.scheduleAtFixedRate(tasks, 0, 5);
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

			ObjectOutputStream infoToServer = new ObjectOutputStream(socket.getOutputStream());
			infoToServer.writeObject(new Data<Character>(user));
			
			ObjectInputStream infoFromServer = new ObjectInputStream(socket.getInputStream());
			Data<Character[]> otherPlayersArray = (Data<Character[]>) infoFromServer.readObject();
			otherPlayers = otherPlayersArray.getInfo();
			
			socket.close();
		}
		catch(IOException e)
		{
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
