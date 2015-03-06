package Red;


import java.io.ObjectInputStream;
import Generic.FrameGame;

public class serverInputThread extends Thread {
	private ObjectInputStream ois;
	private FrameGame game;
	public serverInputThread(ObjectInputStream ois,FrameGame g){
		this.ois=ois;
		game=g;
	}
	public void run(){
		try{
			if (servidor.closed!=true){
				synchronized (ois){
					
					Object o=ois.readObject();
					if (Integer.valueOf(String.valueOf(o))==3){
						game.getPack().getTank()[1].disparar();
					}else{
						game.getPack().getTank()[1].startRot((Integer.valueOf(String.valueOf(o))).byteValue());
					}
					//System.out.println(s);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
