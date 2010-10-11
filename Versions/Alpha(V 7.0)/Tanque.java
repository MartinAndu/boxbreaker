import java.awt.Graphics;


public class Tanque {
	private int Puntaje;
	private int Estado;
	private float Velocidad;
	private int rotacion;
	private boolean disparo;
	
	public Tanque(){
		Puntaje=0;
		Estado=0;
		Velocidad=5;
		rotacion=0;
		disparo=false;
	}
	
	public int getPoints(){
		return(Puntaje);
	}
	public void setPoints(int p){
		Puntaje=Puntaje+p;
	}
	public void setEstado(int a){
		Estado=a;
	}
	public int getEstado(){
		return(Estado);
	}
	public void setVelocidad(int a){
		Velocidad=a;
	}
	public int getAngle(){
		return(rotacion);
	}
	public void disparar(){
		disparo=true;
	}
	public void rotar(int dir){
		if(dir==0){
			rotacion+=Velocidad;	
		}else{
			rotacion-=Velocidad;	
		}	
	}
	public boolean seDisparo(){
		if(disparo){
			disparo=false;
			return (true);
		}else{
			return (false);
		}
	}
	public void dispDone(){
		disparo=false;
	}
}
