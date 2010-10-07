import java.awt.Graphics;


public class Tanque {
	private int Puntaje;
	private int Estado;
	private float Velocidad;
	private int rotacion;
	private PanelGame PG;
	public Tanque(PanelGame Vista){
		Puntaje=0;
		Estado=0;
		Velocidad=5;
		rotacion=0;
		PG=Vista;
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
		PG.addDisp(Estado,rotacion);
	}
	public void rotar(int dir){
		if(dir==0){
			rotacion+=Velocidad;
			PG.setTankAngle(rotacion);
		}else{
			rotacion-=Velocidad;
			PG.setTankAngle(rotacion);
		}
		
	}
}
