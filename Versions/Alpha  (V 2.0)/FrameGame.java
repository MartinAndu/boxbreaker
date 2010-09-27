import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class FrameGame extends JFrame implements KeyListener{
	private String mode;
	private PanelGame Vista;
	private Tanque tank1;
	public FrameGame(){
		super("BoxBreaker");
		setBounds(10,10,800,600);
		setVisible(false);
		setLayout(null);
		
		Vista=new PanelGame();	
		this.add(Vista);
		
		tank1=new Tanque();
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyText(e.getKeyCode())=="Derecha"){
			tank1.rotar(0,Vista);
		}
		if(e.getKeyText(e.getKeyCode())=="Izquierda"){
			tank1.rotar(1,Vista);
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
