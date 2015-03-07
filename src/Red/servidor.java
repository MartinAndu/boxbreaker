package Red;


import java.io.ObjectOutputStream;
import java.net.ServerSocket;

import Generic.FrameGame;
import Generic.FrameNivel;
import Generic.Nivel;
public class servidor {
  static final int PUERTO=5300;
  listeningThread getClient;
  private static ObjectOutputStream[] oos;
  private static int oosCant;
  public static boolean closed;
  private FrameGame game;
  private Nivel nivel;
  public servidor(int cant, int lvlIndex, int sceIndex) {
	  closed=false;
	  oosCant=0;
    try {
      ServerSocket server = new ServerSocket( PUERTO );
      System.out.println("Escucho el puerto " + PUERTO );
      oos=new ObjectOutputStream[3];
      getClient=new listeningThread(game, server,cant-1);
      getClient.start();

     // for ( int numCli = 0; numCli < 4; numCli++ ) {
        //Socket skCliente = server.accept(); // Crea objeto
       // System.out.println("Sirvo al cliente " + numCli);
        //ObjectOutputStream aux = new ObjectOutputStream(skCliente.getOutputStream());
        //aux.writeObject( "Hola cliente " + 1 );
       // skCliente.close();
   //   }
      while(oosCant<cant-1){

      }
      for (int i=0;i<oosCant;i++){
    	  System.out.println("Le escribi al cliente "+i);
    	  synchronized (oos){
    		  oos[i].writeObject(lvlIndex);
    	  }
      }
     /* for (int i=0;i<1000000000;i++){

      }*/
      
      FrameNivel FN=new FrameNivel(0);
      game=new FrameGame(FN);
      game.setOos(oos);
      for (int i=0;i<oosCant;i++){
    	  System.out.println("Le escribi al cliente "+i);
    	  synchronized (oos){
    		  oos[i].writeObject(1);
    	  }
      }
      FN.setMultiplayerFrame(game);
      FN.multiplayer(cant, sceIndex, lvlIndex);
      /*server.close();
      System.out.println("Cerre Socket");
      closed=true;
      System.out.println("Demasiados clientes por hoy");*/
    } catch( Exception e ) {
    	e.printStackTrace();
      System.out.println( "kviola server" );
    }
  }

  public static void setOos(int num, ObjectOutputStream os){
	  oos[num]=os;
	  oosCant++;
  }

public Nivel getNivel() {
	return nivel;
}

public void setNivel(Nivel nivel) {
	this.nivel = nivel;
}

}
