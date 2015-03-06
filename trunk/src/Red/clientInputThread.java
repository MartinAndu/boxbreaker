package Red;

import Generic.Pack;
import Generic.clientFrame;
import java.io.ObjectInputStream;

public class clientInputThread extends Thread {
	private ObjectInputStream ois;
	private clientFrame frame;
	private cliente c;
	private boolean keep;
	private boolean started;
	public clientInputThread(ObjectInputStream ois, cliente c){
		this.ois=ois;
		this.c=c;
		this.keep=true;
		started=false;

		//this.frame=f;
	}
	public void run(){
		while (keep){
			try{
				//System.out.println("EEEA");
				synchronized (ois){
					if (!started){
						Object o=ois.readObject();
						if (o instanceof String){
							System.out.println(String.valueOf(o));
						}
						if (o instanceof Integer){
							frame=c.createFrame(Integer.valueOf(String.valueOf(o)));
							System.out.println("Juego Creado");
							started=true;
						}
						if (o instanceof Boolean){
							//keep=false;
						}
						
					}else{
						Object o=ois.readObject();
						if (o instanceof Pack){
							frame.setPack((Pack)o);
							
						}else{
							
						}
						//frame.setPack(aux);

					}
						

				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
