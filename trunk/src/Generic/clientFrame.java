package Generic;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import Resources.Audio;

public class clientFrame extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int escenario;
	private ObjectOutputStream oos;
	private PanelGame Vista;
	private GraphicsDevice gd = null;
	private GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	public clientFrame(ObjectOutputStream stream, int sce){
		super("BoxBreaker Client");
		escenario=sce;
		oos=stream;
		setUndecorated(true);
		setVisible(false);
		setLayout(null);
		setBounds(10,10,1000,600);
		setResizable(false);
		this.addKeyListener(this);
		Vista=new PanelGame();
		this.add(Vista);
		Vista.setWall(escenario);
    	gd = ge.getDefaultScreenDevice();
		
	}
	public void start(){
		this.setVisible(true);
		gd.setFullScreenWindow(this);
		Audio.setURL(getMusicPath(escenario));
    	Audio.change();
		Vista.setWall(escenario);
		//musica.play();
	}
	private String getMusicPath(int level){
		switch(level){
			case 0:
				return("Sounds\\earth.MID");
			case 1:
				return("Sounds\\fairToDispair.MID");
			case 2:
				return("Sounds\\Ganon.MID");
			case 3:
				return ("Sounds\\goldSaucer.mid");
			case 4:
				return ("Sounds\\ffIV.MID");
			case 5:
				return("Sounds\\hydrocity.mid");
			case 6:
				return("Sounds\\Marble.mid");
			default:
				return null;
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			try{
				synchronized (oos){
					oos.writeObject(new Integer(1) );
				}
			}catch(Exception ex){

			}
			break;
		case KeyEvent.VK_LEFT:
			try{
				synchronized (oos){
					oos.writeObject(new Integer(2) );
				}
			}catch(Exception ex){

			}
			break;
		case KeyEvent.VK_UP:
			try{
				synchronized (oos){
					oos.writeObject(new Integer(3) );
				}
			}catch(Exception ex){

			}
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			try{
				synchronized (oos){
					oos.writeObject(new Integer(0) );
				}
			}catch(Exception ex){

			}
			break;
		case KeyEvent.VK_LEFT:
			try{
				synchronized (oos){
					oos.writeObject(new Integer(0) );
				}
			}catch(Exception ex){

			}
			break;
		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void setPack(Pack pack){
		Vista.setPack(pack);
		Vista.repaint();
	}

}
