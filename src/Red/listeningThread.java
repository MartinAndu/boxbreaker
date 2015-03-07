package Red;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Generic.FrameGame;
public class listeningThread extends Thread {
	private Socket client[];
	//private ObjectOutputStream oos;
	private ObjectInputStream  ois;
	private int clients;
	private ServerSocket server;
	private serverInputThread sit;
	private FrameGame game;
	public listeningThread(FrameGame g,ServerSocket server, int clients){
		this.client=new Socket[clients];
		this.clients=clients;
		this.server=server;
		this.game=g;
	}
	public void run(){
		for ( int numCli = 0; numCli < clients; numCli++ ) {
			try{
				client[numCli] = server.accept();

				ois= new ObjectInputStream(client[numCli].getInputStream());
				sit=new serverInputThread(ois,game);
				sit.start();
				System.out.println("Recibido Cliente "+numCli);
		       // aux.writeObject( "Hola cliente " + numCli );
				servidor.setOos(numCli,new ObjectOutputStream(client[numCli].getOutputStream()));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//servidor.Stop();
	}

}

