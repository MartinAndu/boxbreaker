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
	
	private int tankAngle;
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
	}
	 
	public void paintComponent(Graphics g) {
		int pos=1;
		g.drawImage(fondo,0,0,null);
		g.drawImage(caja,400,100,null);
		//((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (tanque!=null){
			rotate(tankAngle);
			((Graphics2D)g).setTransform(at);
			g.drawImage(tanque,400,300,null);
		}
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
	
	public void setTankAngle(int angulo){
		tankAngle=angulo;
	}
}
