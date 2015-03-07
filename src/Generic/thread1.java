package Generic;

import Box.Caja;


public class thread1 implements Runnable {//Thread que se encarga del tiempo del juego
	private int time;
	private FrameGame frame;
	private int max;
	public thread1(int tiempo,FrameGame Frame){
		time=tiempo;
		frame=Frame;
		max=tiempo;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(frame.getEstado()!=-1){
			System.out.println();
			time=max;
			do{
				if (frame.getEstado()==0){
					time--;
				}else{
					time=0;
				}
				try{
					Thread.sleep(1000);
				}catch(Exception e){

				}

				frame.setGameTime(time);
			}while(time>0 && Caja.getCant()!=0);
			frame.setVictory(0);
			frame.stop();
		}
	}	
}
