package Generic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import Resources.Imagen;
import Resources.Pista;

public class Shot implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int r;
	private double angulo;
	private int tipo;
	private int miTanque;
	private Pista shotSound;
	public Shot(int xVal,int yVal,int rVal,int angVal,int stVal,int tankVal){
		r=rVal;
		angulo=Math.toRadians(angVal);
		tipo=stVal;
		x=xVal-17;
		y=yVal-17;
		miTanque=tankVal;
	}

	public void setR(int rVal){
		r=rVal;
	}

	public void setAngle(int angVal){
		angulo=angVal;
	}

	public int getR(){
		return r;
	}

	public double getAngle(){
		return angulo;
	}

	public int getX(){
		return x+30+(int)(r*Math.cos(angulo));
	}

	public int getY(){
		switch(tipo){
			case 0:
				return y+32+(int)(r*Math.sin(angulo));
			case 1:
				return y+27+(int)(r*Math.sin(angulo));
			case 2:
				return y+32+(int)(r*Math.sin(angulo));
			default:
				return 0;
		}
	}

	private BufferedImage getImage(){
		switch(tipo){
			case 0:
				return Imagen.loadImg("Images/Gifs/shot.GIF");
			case 1:
				return Imagen.loadImg("Images/Gifs/superShot.GIF");
			case 2:
				return Imagen.loadImg("Images/Gifs/rapidShot.GIF");
			default:
				return null;
		}
	}

	public void draw(Graphics g){
		switch(tipo){
			case 0:
				g.drawImage(getImage(),getX(),getY(),null);
				break;
			case 1:
				g.drawImage(getImage(),getX(),getY(),null);
				break;
			case 2:
				g.drawImage(getImage(),getX(),getY(),null);
				break;
			default:
				break;
		}
	}

	public void update(){
		switch(tipo){
			case 0:
				r+=20;
				break;
			case 1:
				r+=25;
				break;
			case 2:
				r+=40;
				break;
		}
	}

	public int getAncho(){
		return getImage().getWidth();
	}

	public int getAlto(){
		return getImage().getHeight();
	}

	public int shootedBy(){
		return miTanque;
	}

	public Pista getShotSound() {
		return shotSound;
	}

	public void setShotSound(Pista shotSound) {
		this.shotSound = shotSound;
	}
}
