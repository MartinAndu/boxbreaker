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
	private  AffineTransform at;
	private  Imagen I=new Imagen();
	public PanelGame(){
		super();
		setBounds(0,0,800,600);
		at=new AffineTransform();
		setVisible(true);
		tanque=I.loadImg("canon.GIF");
		fondo=I.loadImg("blue.JPG");
		caja=I.loadImg("Box1.GIF");
	}
	 
	public void paintComponent(Graphics g) {
		g.drawImage(fondo,0,0,null);
		g.drawImage(caja,(int)(Math.random()*700),(int)(Math.random()*550),null);
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if (tanque!=null){
			((Graphics2D)g).setTransform(at);
			g.drawImage(tanque,400,330,null);
			((Graphics2D)g).setTransform(at);
		}
	}
	
	public  void rotate(int angle){	
		at =new AffineTransform(); 
		at.rotate(Math.toRadians(angle),393,341); 
	}
}
