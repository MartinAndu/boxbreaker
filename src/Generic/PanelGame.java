package Generic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Box.boxContainer;
import Resources.Imagen;
import Resources.WordArt;
import Box.Caja;

public class PanelGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage fondo;
	private BufferedImage Bar=Imagen.loadImg("Images\\Bar.PNG");
	private Shot disps[];
	private Tanque tanks[];
	private boxContainer box[];
	private int tiempo;
	private String condicion;
	private int condBox;
	private WordArt word;

	@SuppressWarnings("static-access")
	public PanelGame(){
		super();
		setBounds(0,0,1024,768);
		setVisible(true);
		Imagen I=new Imagen();
		fondo=I.loadImg(getWallPath(0));
		disps=null;
	}

	public void paintComponent(Graphics g) {
		System.out.println("Repinte!");
		g.drawImage(fondo,0,0,null);

		//Dibuja las cajas
		System.out.println("Length Box: "+box.length);
		for (int y=0;y<box.length;y++){
			System.out.println(y);
			box[y].draw(g);
		}
		//


		//Dibuja efectos
		Power.draw(g);
		//

		//Dibuja el Tanque
		for (int t=0;t<tanks.length;t++){
			if(tanks[t]!=null)
				tanks[t].draw(g);
		}
		//

		//Dibuja los disparos
		for(int pos=0;pos<disps.length;pos++)
			if (disps[pos]!=null)
				disps[pos].draw(g);

		//
		if(word!=null){
			word.draw(g);
			if(word.getY()>768)
				word=null;
		}
		g.drawImage(Bar,0,0,null);
		g.setFont(new Font(null,Font.BOLD,16));
		g.setColor(Color.black);
		for(int pos=0;pos<tanks.length;pos++){
			if(tanks[pos]!=null){
				if(tanks[pos].getPlayer()>=0){
					g.drawString("Jugador "+(tanks[pos].getPlayer()+1)+":",10+tanks[pos].getPlayer()*160,22);
				}else{
					g.drawString("Jugador  "+(Math.abs(tanks[pos].getPlayer()+1)+1)+":",10+Math.abs(tanks[pos].getPlayer()+1)*160,22);

				}
				g.drawString(String.valueOf(tanks[pos].getPoints()),95+(pos*160),22);
			}
		}
		g.drawString("Tiempo:"+tiempo,650,22);
		g.setColor(Color.red);
		if (condicion!=null){
			g.drawString(condicion,370,22);
			g.drawString("Cajas "+ Caja.getName(condBox)+" Destruidas: "+Caja.getType(condBox),750,22);
		}else {
			g.drawString("Cajas Destruidas: "+Caja.getDCant(),800,22);
		}
	}



	public Tanque[] getTank(){
		return tanks;
	}
	public void setPack(Pack paquete){
		tanks=paquete.getTank();
		disps=paquete.getShots();
		box=paquete.getBoxes();
	}
	public void setTime(int t){
		tiempo=t;
	}

	@SuppressWarnings("static-access")
	public void setWall(int wall){
		fondo=new Imagen().loadImg(getWallPath(wall));
	}

	private String getWallPath(int num){
		switch(num){
		case 0:
			return ("Images/Walls/blue.JPG");
		case 1:
			return ("Images/Walls/Newton.JPG");
		case 2:
			return ("Images/Walls/Noche.JPG");
		case 3:
			return ("Images/Walls/Park.JPG");
		case 4:
			return ("Images/Walls/Invierno.JPG");
		case 5:
			return ("Images/Walls/Hidro.JPG");
		case 6:
			return ("Images/Walls/Montaña.JPG");
		default:
			return null;
		}
	}
	public void setCond(String a){
		condicion=a;
	}
	public void setCondBox(int a){
		condBox=a;
	}
	public void setNivel(int nivel){
		if(nivel>=0){
			if(nivel<10000){
				word=new WordArt(0,String.valueOf(nivel+1));
			}else{
				word=new WordArt(1,"");
			}
		}else{
			word=null;
		}
	}
}
