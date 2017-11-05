package wowMeetsFPS;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Client {
	final static int PORT = 25565;
	final static String ip = "54.145.139.6";
	
	
	String username;
	static Character[] otherPlayers;
	static Character user;
	static Map map;
	static Timer timer = new Timer();
	static TimerTask tasks = new TimerTask() {
		@Override
		public void run() {
			System.out.println("Wut Dah");
			map.performAction();
			map.updateMap(user, otherPlayers);
			updateProjectiles();
			
			Thread thread = new Thread(new Runnable() {

			    @Override
			    public void run() {
			         connectToServer(ip,PORT, user);       
			    }
			            
			});
			        
			thread.start();
		}
		
	};
	public static void start() {
		System.out.println("AAHHHAHAH");
		timer.scheduleAtFixedRate(tasks, 0, 5);
	}
	private static void updateProjectiles() {
		user.setCooldown(true);
		if(user.getProjectiles() != null) {
		for(Projectile p: user.getProjectiles()) {
			p.move();
		}
		}
		user.setCooldown(false);
	}
	public static void main(String[] args){
		System.out.println("Server is a go");
		String username = null;
		while(username == null || username.equals("")) {
		username = Map.getUserName();
		}
		user = new Tank(username); //Initalize Character
		//Initialize otherPlayers
		otherPlayers = new Character[0];
		map = new Map(null, user, otherPlayers);
		start();
	}	
	static void connectToServer(String ip, int port, Character user)
	{
		try
		{
			Socket socket = new Socket(ip,port);

			ObjectOutputStream infoToServer = new ObjectOutputStream(socket.getOutputStream());
			infoToServer.writeObject(new Data<Character>(user));
			
			ObjectInputStream infoFromServer = new ObjectInputStream(socket.getInputStream());
			Data<Character[]> otherPlayersArray = (Data<Character[]>) infoFromServer.readObject();
			otherPlayers = otherPlayersArray.getInfo();
			map.updateMap(user, otherPlayers);
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
