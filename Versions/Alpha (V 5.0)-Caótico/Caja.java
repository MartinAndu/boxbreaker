
public class Caja {
	private int x;
	private int y;
	private int dir;
	private int Puntaje;
	private float Velocidad;
	private int spe;
	public Caja(int a, int b){
		x=(int)(Math.random()*750);
		y=(int)(Math.random()*550);
		Puntaje=a;
		dir=(int)(Math.random()*360);
		Velocidad=1+(int)(Math.random()* 19);
		spe=b;
	}
	public int getPoints(){
		return(Puntaje);
	}
	public float getVel(){
		return(Velocidad);
	}
	public int getSpe(){
		return(spe);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getDir(){
		return dir;
	}
	
	public void setToNextX(){
		x= x+(int) ((double)Velocidad*Math.cos(((double)dir/360)*2*Math.PI));
	}
	public void setToNextY(){
		y= y+(int) ((double)Velocidad*Math.sin(((double)dir/360)*2*Math.PI));
	}
	public void setDir(int dirVal){
		dir=dirVal;
	}
}
