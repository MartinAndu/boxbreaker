package Red;

import Generic.clientFrame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class cliente {
  //private static final String HOST = "localhost";
  //private static final int PUERTO=5300;
  private clientInputThread cit;
  private clientFrame game;
  private ObjectOutputStream oos;
  public cliente(int PUERTO, String HOST ) {
	    try{
	      @SuppressWarnings("resource")
		Socket Cliente = new Socket( HOST , PUERTO );
	      oos = new ObjectOutputStream(Cliente.getOutputStream());
	      ObjectInputStream ois=new ObjectInputStream(Cliente.getInputStream());
	      cit=new clientInputThread(ois,this);
	      cit.start();
	     /* synchronized(oos){
	    	  oos.writeObject(String.valueOf("Hola servidor"));
	      }*/
	    }catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("kviola cliente");
	    }
	  }
  public clientFrame createFrame(int sce){
	  game=new clientFrame(oos,sce);
	  game.start();
	  return(game);
  }
}

