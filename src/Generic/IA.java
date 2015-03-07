package Generic;

public class IA {
	private Tanque tank;
	private int nextPoint;
	private int dir;
	
	public IA(Tanque t){
		tank=t;
	}
	
	public void think(){
		if(Math.abs(nextPoint-Math.abs(tank.getDegreesAngle()%360))>10){
			if(dir==0){
				tank.mouseRotarDer();
			}else{
				tank.mouseRotarIzq();
			}
		}else{
			tank.disparar();
			if(tank.getY()>384){
				nextPoint=(int)(Math.random()*180);
			}else{
				nextPoint=(int)(180+Math.random()*180);
			}
			dir=(int)(Math.random()*2);
		}
	}
}
