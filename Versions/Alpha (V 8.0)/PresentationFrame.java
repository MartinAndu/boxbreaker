import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;


public class PresentationFrame extends JFrame implements KeyListener {
	private Menu PPAL;
    public PresentationFrame(){
    	this.addKeyListener(this);
    	Imagen I=new Imagen();
    	setBounds(0,0,472,314);
    	Container c= getContentPane();
    	PPAL=new Menu();
    	PPAL.setBounds(0,0,472,314);
    	PPAL.setBackground(I.loadImg("presentacion.GIF"));
    	c.add(PPAL);
    	setContentPane(c);
    	setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    	hide();
    }

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    public void hide(){
    	//try{
    	super.hide();
    	
    	//}catch(Exception ex){
    		
    	//}
    }

}
