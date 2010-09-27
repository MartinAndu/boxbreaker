import java.awt.Graphics;


public class Tanque {
	private int Puntaje;
	private int Estado;
	private float Velocidad;
	public Tanque(){
		Puntaje=0;
		Estado=0;
		Velocidad=5;
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
	public void disparar(){
		//:(
	}
	public void rotar(int dir,PanelGame p){
		if(dir==0){
			p.rotate(5);
		}else{
			p.rotate(-5);
		}
			
	}
}
