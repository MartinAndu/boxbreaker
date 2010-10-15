//Clase utilitaria contenedora. Escencial para el envio de informacion en red, asi como para el intercambio de informacion entre 
public class Pack {
	private boxContainer box[];
	private Shot shot[];
	private Tanque tank;
	public Pack(boxContainer a[],Shot b[],Tanque c){
		box=a;
		shot=b;
		tank=c;
	}
	public boxContainer[] getBoxes(){
		return(box);
	}
	public Shot[] getShots(){
		return(shot);
	}
	public Tanque getTank(){
		return(tank);
	}
}
