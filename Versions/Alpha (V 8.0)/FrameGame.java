import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class FrameGame extends JFrame implements KeyListener,ActionListener{
	private String mode;
	private PanelGame Vista;
	private Pack PE;
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
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:
				Vista.getTank().startRot((byte)1);
				break;
			case KeyEvent.VK_LEFT:
				Vista.getTank().startRot((byte)2);
				break;
			case KeyEvent.VK_UP:
				Vista.getTank().disparar();
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			Vista.getTank().startRot((byte)0);
			break;
		case KeyEvent.VK_LEFT:
			Vista.getTank().startRot((byte)0);
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent e) {
		Vista.repaint();
	}
	public void createPack(){
		boxContainer cont[]=new boxContainer[3];
		cont[0]=new boxCLineal(700,500,10,10);
		cont[1]=new boxCLineal(600,10,10,400);
		cont[2]=new boxCCircular(400,321,0,0,200);
		for(int i=0;i<=10;i++){
			for (int y=0;y<3;y++){
				cont[y].addBox(new Caja(0,(int)(Math.random()*7)));
			}
		}
	}
}
