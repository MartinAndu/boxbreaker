import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelGame extends JPanel{

	private  BufferedImage tanque;
	private  BufferedImage fondo;
	private BufferedImage disparo;
	private BufferedImage centro;
	private  AffineTransform at;
	private Shot dispAct;
	private Tanque tank1;
	private boxContainer box[];

	private  Imagen I=new Imagen();

	public PanelGame(){
		super();
		setBounds(0,0,800,600);
		at=new AffineTransform();
		setVisible(true);
		tanque=I.loadImg("canon.GIF");
		centro=I.loadImg("center.GIF");
		fondo=I.loadImg("blue.JPG");
		disparo=I.loadImg("shot.GIF");
		dispAct=null;

		tank1=new Tanque();
		box=new boxContainer[4];
		box[0]=new boxCLineal(10,10,750,10);
		box[1]=new boxCLineal(10,450,750,450);
		box[2]=new boxCCircular(380,300,0,0,200);
		box[3]=new boxCCircular(380,300,0,0,100);
		for(int i=0;i<=10;i++){
			for (int y=0;y<4;y++){
				box[y].addBox(new Caja(0,(int)(Math.random()*7)));
			}

		}

	}

	public void paintComponent(Graphics g) {
		g.drawImage(fondo,0,0,null);

		//Dibuja las cajas
		for (int y=0;y<4;y++){
			box[y].update(dispAct);
			box[y].draw(g);
		}
		//

		//Dibuja el Tanque
		tank1.rotar();
		rotate(tank1.getAngle());
		((Graphics2D)g).setTransform(at);
		g.drawImage(tanque,400,300,null);
		rotate(0);
		((Graphics2D)g).setTransform(at);
		g.drawImage(centro,383,304,null);
		//
	
		//Dibuja los disparos
		if(tank1.seDisparo())
			if(dispAct==null)
				dispAct=new Shot(87,tank1.getAngle(),tank1.getEstado());
		if(dispAct!=null){
			if(dispAct.getX()<800 && dispAct.getY()<600 && dispAct.getY()>=0 && dispAct.getX()>=0){
				g.drawImage(disparo,dispAct.getX(),dispAct.getY(),null);
				dispAct.setR(dispAct.getR()+20);
			}else{
				dispAct= null;
			}
		}
		//
	
	}

	public  void rotate(int angle){	
		at =new AffineTransform(); 
		at.rotate(Math.toRadians(angle),400,321); 
	}

	public Tanque getTank(){
		return tank1;
	}
}
