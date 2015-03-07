package Generic;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Menu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage Background;
	
	public Menu(){
		super();
		setLayout(null);
		setBounds(0,0,200,320);
		Background=null;
	}
	
	public void setBackground(BufferedImage I){
		Background=I;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(Background!=null){
			g.drawImage(Background,0,0,null);
		}
	}
}
