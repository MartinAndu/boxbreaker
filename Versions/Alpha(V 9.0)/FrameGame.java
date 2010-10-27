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
	private boolean first;
	private boolean ejecutando;
	private Thread Tiempo;
	private Marcador marcador;
	public FrameGame(){
		super("BoxBreaker");
		setBounds(10,10,800,600);
		setVisible(false);
		setLayout(null);
		this.setResizable(false);
		Vista=new PanelGame();
		this.add(Vista);
		first=false;
		createPack();
		Vista.setPack(PE);
		Timer timer = new Timer (25,this);
		timer.start();
		addKeyListener(this);
		ejecutando=true;
		marcador=new Marcador();
	}


	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:
				PE.getTank().startRot((byte)1);
				break;
			case KeyEvent.VK_LEFT:
				PE.getTank().startRot((byte)2);
				break;
			case KeyEvent.VK_UP:
				PE.getTank().disparar();
				break;
			case KeyEvent.VK_ESCAPE:
				stop();
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			PE.getTank().startRot((byte)0);
			break;
		case KeyEvent.VK_LEFT:
			PE.getTank().startRot((byte)0);
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent e) {
		if (first){
			createPack();
		}else{
			PE.getTank().rotar();
			if(PE.getTank().seDisparo())
				if(PE.getShots()==null)
					PE.setShots(new Shot(87,PE.getTank().getAngle(),PE.getTank().getEstado()));
			if(PE.getShots()!=null){
				if(PE.getShots().getX()<800 && PE.getShots().getY()<600 && PE.getShots().getY()>=0 && PE.getShots().getX()>=0){
					PE.getShots().setR(PE.getShots().getR()+20);
				}else{
					PE.setShots(null);
				}
			}
			for (int y=0;y<3;y++){
				PE.getTank().setPoints(PE.getBoxes()[y].update(PE.getShots()));
			}
		}
		/*if (PE.getShots()==null){
			createPack();
		}*/
		Vista.setPack(PE);
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
		Tanque tank1=new Tanque();
		PE=new Pack(cont,null,tank1);
	}
	public boolean getEstado(){
		return(ejecutando);
	}
	public void stop(){
		createPack();
		ejecutando=false;
		marcador.setTiempo(30);
		marcador.setPuntos(Vista.getTank().getPoints());
		marcador.escribir();
		this.hide();
		marcador.show();
	}
	public synchronized void setGameTime(int t){
		Vista.setTime(t);
	}
	public void start(){
		ejecutando=true;
		Tiempo=new Thread(new thread1(25,this));//Setea el tiempo en segundos=primer parametro
		Tiempo.start();
	}
}
