package Generic;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import Resources.Imagen;
import Resources.Pista;


@SuppressWarnings("unused")
public class Tanque implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Puntaje;
	private  int Estado;
	private float Velocidad;
	private int rotacion;
	private boolean disparo;
	private byte rotando;
	private int x;
	private int y;
	private int Player;
	private AffineTransform at;
	private int color;


	public Tanque(int x,int y,int color){
		Puntaje=0;
		Estado=0;
		Velocidad=5;
		rotacion=0;
		disparo=false;
		at=new AffineTransform();
		this.x=x+17;
		this.y=y+17;
		this.color=color;
		//Tanques congelados
	}

	public int getPoints(){
		return(Puntaje);
	}
	public  void setPoints(int p){
		Puntaje=Puntaje+p;
	}
	public  void setEstado(int a){
		Estado=a;
	}
	public int getEstado(){
		return(Estado);
	}
	public void setVelocidad(int a){
		Velocidad=a;
	}
	public void setPlayer(int p){
		Player=p;
	}
	public int getPlayer(){
		return Player;
	}
	public int getAngle(){
		return(rotacion);
	}
	public int getDegreesAngle(){
		return (int)Math.toDegrees(rotacion);
	}
	public void disparar(){
		disparo=true;
	}
	public void rotar(){
		if(rotando==1){
			rotacion+=Velocidad;
		}
		if(rotando==2){
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
	public void startRot(byte dir){
		rotando=dir;
	}
	private void rotate(int angle){
		at =new AffineTransform();
		at.rotate(Math.toRadians(angle),x+17,y+17);
	}
	public void draw(Graphics g){
		rotate(rotacion);
		((Graphics2D)g).setTransform(at);
		g.drawImage(getImage(),getCanonX(),getCanonY(),null);
		if(Velocidad==0){
			if(Estado!=1){
				g.drawImage(getFrozenImage(),getCanonX(),getCanonY()-1,null);
			}else{
				g.drawImage(getFrozenImage(),getCanonX(),getCanonY()-8,null);
			}
		}

		rotate(0);
		((Graphics2D)g).setTransform(at);
		g.drawImage(Imagen.loadImg("Images/Gifs/center.GIF"),x,y,null);
	}
	private BufferedImage getImage(){

		switch(Estado){
		case 0:{
			return Imagen.loadImg("Images/Gifs/canon"+(color+1)+"/canon.GIF");
		}case 1:{
			return Imagen.loadImg("Images/Gifs/canon"+(color+1)+"/superCanon.GIF");
		}case 2:
			return Imagen.loadImg("Images/Gifs/canon"+(color+1)+"/rapidCanon.GIF");
		default:
			return null;
	}
	}
	private BufferedImage getFrozenImage(){

		switch(Estado){
		case 0:{
			return Imagen.loadImg("Images/Gifs/stoppedCannon.png");
		}case 1:{
			return Imagen.loadImg("Images/Gifs/stoppedSuperCannon.png");
		}case 2:
			return Imagen.loadImg("Images/Gifs/stoppedRapidCannon.png");
		default:
			return null;
	}
	}
	private int getCanonY(){
		switch(Estado){
			case 0:
				return y;
			case 1:
				return y;
			case 2:
				return y+3;
			default:
				return 0;
		}
	}
	private int getCanonX(){
		switch(Estado){
		case 0:
			return x+18;
		case 1:
			return x+32;
		case 2:
			return x+37;
		default:
			return 0;
		}
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void mouseRotarDer(){
		rotacion+=Velocidad;
	}
	public void mouseRotarIzq(){
		rotacion-=Velocidad;
	}
	public int getAncho(){
		return (getImage().getWidth());
	}
}
