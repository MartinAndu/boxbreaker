package Generic;
import java.io.Serializable;

import Box.boxContainer;

//Clase utilitaria contenedora. Escencial para el envio de informacion en red, asi como para el intercambio de informacion entre
public class Pack implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boxContainer box[];
	private Shot shot[];
	private Tanque tank[];
	public Pack(boxContainer a[],Shot b[],Tanque c[]){
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
	public Shot getShot(int pos){
		return(shot[pos]);
	}
	public Tanque[] getTank(){
		return(tank);
	}
	public void setShots(Shot a[]){
		shot=a;
	}
	public void setShot(Shot a,int pos){
		shot[pos]=a;
	}
}
