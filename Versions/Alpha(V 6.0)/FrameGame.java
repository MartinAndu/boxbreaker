import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class FrameGame extends JFrame implements KeyListener,ActionListener{
	private String mode;
	private PanelGame Vista;
	public FrameGame(){
		super("BoxBreaker");
		setBounds(10,10,800,600);
		setVisible(false);
		setLayout(null);
		
		Vista=new PanelGame();	
		this.add(Vista);
		
		Timer timer = new Timer (25,this); 
		timer.start();
		
		addKeyListener(this);
	}
	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyText(e.getKeyCode())=="Derecha"){
			Vista.getTank().rotar(0);
		}
		if(e.getKeyText(e.getKeyCode())=="Izquierda"){
			Vista.getTank().rotar(1);
		}
		if(e.getKeyText(e.getKeyCode())=="Arriba"){
			Vista.getTank().disparar();
		}	
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		Vista.repaint();
	}
}
