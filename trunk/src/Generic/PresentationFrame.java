package Generic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Resources.Audio;
import Resources.Imagen;




import java.awt.Container;


public class PresentationFrame extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu PPAL;
    @SuppressWarnings("static-access")
	public PresentationFrame(){
    	this.addKeyListener(this);
    	setBounds(200,200,472,314);
    	Container c= getContentPane();
    	PPAL=new Menu();
    	PPAL.setBounds(0,0,472,314);
    	PPAL.setBackground(new Imagen().loadImg("Images/Gifs/presentacion.GIF"));
    	c.add(PPAL);
    	setContentPane(c);
    	setUndecorated(true);
    	setVisible(true);
    	Audio.setURL("Sounds//dandan.mid");
    	Audio.startAudio();
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    	hide();
    	Audio.setURL("Sounds//recuerdoz2.mid");
    	Audio.change();
    }

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    @SuppressWarnings({ "deprecation", "unused" })
	public void hide(){
    	super.hide();
    	theFrame a=new theFrame();
    }

}
