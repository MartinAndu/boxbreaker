
public class Caja {
	private int Puntaje;
	private float Velocidad;
	private int spe;
	public Caja(int a, int b){
		Puntaje=a;
		Velocidad=1+(int)(Math.random()* 2);
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
	
}
