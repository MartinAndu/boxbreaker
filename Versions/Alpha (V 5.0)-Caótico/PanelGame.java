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
	private  BufferedImage caja;
	private BufferedImage disparo;
	private  AffineTransform at;
	private Shot dispAct;
	private Lista cajas;
	private Tanque tank1;
	private  Imagen I=new Imagen();
	
	
	public PanelGame(){
		super();
		setBounds(0,0,800,600);
		at=new AffineTransform();
		setVisible(true);
		tanque=I.loadImg("canon.GIF");
		fondo=I.loadImg("blue.JPG");
		caja=I.loadImg("Box1.GIF");
		disparo=I.loadImg("shot.GIF");
		dispAct=null;
		
		tank1=new Tanque();
		int i;
		cajas=new Lista();
		
		for(i=0;i<=100;i++){
			cajas.add(new Caja(0,0));
		}
	}
	 
	public void paintComponent(Graphics g) {
		g.drawImage(fondo,0,0,null);
		
		//Dibuja las cajas
		int pos=1;
		Caja boxAct=new Caja(0,0);
		while(cajas.getData(pos)!=null){
			boxAct=(Caja)(cajas.getData(pos));
			g.drawImage(caja,boxAct.getX(),boxAct.getY(),null);
			boxAct.setToNextX();
			boxAct.setToNextY();
			g.drawString(Integer.toString(boxAct.getX()), boxAct.getX(),boxAct.getY());
			g.drawString(Integer.toString(pos), boxAct.getX()+15,boxAct.getY()+25);

			if(boxAct.getX()>=750 || boxAct.getX()<=0){
				boxAct.setDir(boxAct.getDir()-180);
			}else{
				if(boxAct.getY()>=530 || boxAct.getY()<=0)
					boxAct.setDir(boxAct.getDir()-180);
			}
			pos++;
		}
		
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
