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
	private  AffineTransform at;
	private Shot dispAct;
	private Tanque tank1;
	private boxCLineal path1;
	private boxCLineal path2;
	private boxCCircular path3;
	private  Imagen I=new Imagen();
	
	public PanelGame(){
		super();
		setBounds(0,0,800,600);
		at=new AffineTransform();
		setVisible(true);
		tanque=I.loadImg("canon.GIF");
		fondo=I.loadImg("blue.JPG");
		disparo=I.loadImg("shot.GIF");
		dispAct=null;
		
		tank1=new Tanque();
		int i;
		path1=new boxCLineal(700,500,10,10);
		path2=new boxCLineal(600,10,10,400);
		path3=new boxCCircular(400,321,0,0,200);
		for(i=0;i<=10;i++){
			path1.addBox(new Caja(0,(int)(Math.random()*7)));
			path2.addBox(new Caja(0,(int)(Math.random()*7)));
			path3.addBox(new Caja(0,(int)(Math.random()*7)));
		}
	}
	 
	public void paintComponent(Graphics g) {
		g.drawImage(fondo,0,0,null);
		
		//Dibuja las cajas
		path1.draw(g);
		path2.draw(g);
		path3.draw(g);
		//
		
		//Dibuja el Tanque
		if (tanque!=null){
			rotate(tank1.getAngle());
			((Graphics2D)g).setTransform(at);
			g.drawImage(tanque,400,300,null);
		}
		//
		
		//Dibuja los disparos
		if(tank1.seDisparo())
			addDisp(tank1.getEstado(),tank1.getAngle());
		if(dispAct!=null){
			if(dispAct.getR()<1000){
				rotate(dispAct.getAngle());
				((Graphics2D)g).setTransform(at);
				g.drawImage(disparo,dispAct.getR(),310,null);
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
	
	public void addDisp(int estado,int angulo){
		if(dispAct==null){
			dispAct=new Shot();
			dispAct.setR(502);
			dispAct.setAngle(angulo);
		}
	}
	
	public Tanque getTank(){
		return tank1;
	}
}
