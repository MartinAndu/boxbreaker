package Generic;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.Timer;

import Box.Caja;
import Resources.Audio;


public class FrameGame extends JFrame implements KeyListener,ActionListener,MouseListener,MouseWheelListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelGame Vista;
	private Pack PE;
	private GraphicsDevice gd = null;
	private GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	private boolean first=true;
	private int ejecutando;
	private Timer timer;
	private Marcador marcador;
	private int restTime;
	//private Pista musica;
	private int victory;
	private int escenario;
	private int Players;
	private IA PCTanks[];
	private ObjectOutputStream oos[];

	public FrameGame(FrameNivel contr){
		super("BoxBreaker");
		setUndecorated(true);
		setVisible(false);
		setLayout(null);
		setBounds(10,10,1000,600);
		setResizable(false);
		Vista=new PanelGame();
		this.add(Vista);
		timer = new Timer (25,this);
		addKeyListener(this);
		addMouseListener(this);
		addMouseWheelListener(this);
		ejecutando=0;
		marcador=new Marcador(contr);
		gd = ge.getDefaultScreenDevice();
		victory=0;
		PCTanks=new IA[4];
	}


	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:
				if(PE.getTank()[0]!=null && PE.getTank()[0].getPlayer()>=0)
					PE.getTank()[0].startRot((byte)1);
				break;
			case KeyEvent.VK_LEFT:
				if(PE.getTank()[0]!=null && PE.getTank()[0].getPlayer()>=0)
					PE.getTank()[0].startRot((byte)2);
				break;
			case KeyEvent.VK_UP:
				if(PE.getTank()[0]!=null && PE.getTank()[0].getPlayer()>=0)
					PE.getTank()[0].disparar();
				break;
			case KeyEvent.VK_ESCAPE:
				ejecutando=-1;
				marcador.setExit(true);
				break;
			case KeyEvent.VK_PAUSE:
				if(ejecutando==0){
					ejecutando=1;
				}else{
					ejecutando=0;
				}
				break;
			case KeyEvent.VK_W:
				if (PE.getTank()[1]!=null && PE.getTank()[1].getPlayer()>=0){
					PE.getTank()[1].disparar();
				}
				break;
			case KeyEvent.VK_D:
				if (PE.getTank()[1]!=null && PE.getTank()[1].getPlayer()>=0){
					PE.getTank()[1].startRot((byte)1);
				}
				break;
			case KeyEvent.VK_A:
				if (PE.getTank()[1]!=null && PE.getTank()[1].getPlayer()>=0){
					PE.getTank()[1].startRot((byte)2);
				}
				break;
			case KeyEvent.VK_NUMPAD8:
				if(PE.getTank()[2]!=null && PE.getTank()[2].getPlayer()>=-0){
					PE.getTank()[2].disparar();
				}
				break;
			case KeyEvent.VK_NUMPAD4:
				if(PE.getTank()[2]!=null&& PE.getTank()[2].getPlayer()>=-0){
					PE.getTank()[2].startRot((byte)2);
				}
				break;
			case KeyEvent.VK_NUMPAD6:
				if(PE.getTank()[2]!=null&& PE.getTank()[2].getPlayer()>=-0){
					PE.getTank()[2].startRot((byte)1);
				}
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			if(PE.getTank()[0]!=null && PE.getTank()[0].getPlayer()>=0)
				PE.getTank()[0].startRot((byte)0);
			break;
		case KeyEvent.VK_LEFT:
			if(PE.getTank()[0]!=null && PE.getTank()[0].getPlayer()>=0)
			PE.getTank()[0].startRot((byte)0);
			break;
		case KeyEvent.VK_D:
			if (PE.getTank()[1]!=null && PE.getTank()[1].getPlayer()>=0)
				PE.getTank()[1].startRot((byte)0);
			break;
		case KeyEvent.VK_A:
			if (PE.getTank()[1]!=null && PE.getTank()[1].getPlayer()>=0)
				PE.getTank()[1].startRot((byte)0);
			break;
		case KeyEvent.VK_NUMPAD4 :
			if(PE.getTank()[2]!=null && PE.getTank()[2].getPlayer()>=0)
				PE.getTank()[2].startRot((byte)0);
			break;
		case KeyEvent.VK_NUMPAD6:
			if(PE.getTank()[2]!=null && PE.getTank()[2].getPlayer()>=0)
				PE.getTank()[2].startRot((byte)0);
			break;
		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent e) {
		if(ejecutando==0){
			for (int t=0; t<Players;t++){
				if(PE.getTank()[t]!=null){
					if(PE.getTank()[t].getPlayer()<0)
						PCTanks[t].think();
				PE.getTank()[t].rotar();
				if(PE.getTank()[t].seDisparo())
					if(PE.getShot(t)==null && Power.tankStopped(t)!=true)
						PE.setShot(new Shot(PE.getTank()[t].getX(),PE.getTank()[t].getY(),PE.getTank()[t].getAncho(),PE.getTank()[t].getAngle(),PE.getTank()[t].getEstado(),t),t);
				if(PE.getShot(t)!=null){
					if(PE.getShot(t).getX()<1024 && PE.getShot(t).getY()<768 && PE.getShot(t).getY()>=0 && PE.getShot(t).getX()>=0){
						PE.getShot(t).update();
					}else{
						PE.setShot(null,t);
					}
				}
				}
			}

			int points[]=new int[4];
			for (int y=0;y<PE.getBoxes().length;y++){
				points=PE.getBoxes()[y].update(PE.getShots());
				for(int z=0;z<PE.getTank().length;z++){
					if(PE.getTank()[z]!=null){
						int oldPuntaje=PE.getTank()[z].getPoints();
						PE.getTank()[z].setPoints(points[z]);
						if(PE.getTank()[z].getPoints()>oldPuntaje && PE.getTank()[z].getEstado()!=1)
							PE.setShot(null,z);
					}
				}
			}
		//}

		Power.runEfecto();
		if (oos!=null){
			try{
			//	for (int x=0;x<oos.length;x++){
					System.out.println("Antes del Envio del Pack");
					synchronized (oos){
						if (PE instanceof Pack){
							System.out.println("Envio Pack");
							oos[0].writeObject(PE);
							System.out.println("Ya envie Pack");
						}
					}
				//}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		Vista.setPack(PE);
		Vista.repaint();
		}
	}

	public void createPack(Nivel nivel,Tanque tanks[]){
		Players=tanks.length;
		Caja.reboot();
		escenario=nivel.getEscenario();
		if(nivel.getCode()<10000){
			Nivel.load(nivel.getContainer(),nivel.getBoxCant());
		}else{
			Nivel.load(nivel.getContainer(),nivel.getBoxCant(),Caja.getColor());
		}
		Vista.setNivel(nivel.getCode());
		PE=new Pack(nivel.getContainer(),new Shot[tanks.length],tanks);

		Vista.setPack(PE);
		for(int pos=0;pos<tanks.length;pos++){
			if(tanks[pos]!=null && tanks[pos].getPlayer()<0){
				PCTanks[pos]=new IA(tanks[pos]);
			}
		}
		Power.setTanks(tanks);
	}
	public int getEstado(){
		return(ejecutando);
	}
	@SuppressWarnings("deprecation")
	public void stop(){
		timer.stop();
		ejecutando=-1;
		//musica.stop();
		marcador.setAzules(Caja.getDAzules());
		marcador.setBlancas(Caja.getDBlancas());
		marcador.setRojas(Caja.getDRojas());
		marcador.setVerdes(Caja.getDVerdes());
		marcador.setNaranjas(Caja.getDNaranjas());
		marcador.setVioletas(Caja.getDVioletas());
		marcador.setCelestes(Caja.getDCelestes());
		marcador.setPlateadas(Caja.getDPlateadas());
		marcador.setDoradas(Caja.getDDoradas());
		marcador.setCantD(Caja.getDCant());
		marcador.setTiempo(restTime);
		for(int pos=0;pos<Vista.getTank().length;pos++)
			if(Vista.getTank()[pos]!=null)
				marcador.setPuntos(Vista.getTank()[pos].getPoints(),Vista.getTank()[pos].getPlayer());

		marcador.setVictory(victory);
		victory=0;
		marcador.escribir();
		gd.setFullScreenWindow(null);
		this.hide();
		Power.stopEfecto();
		Audio.setURL("Sounds\\Victory_Fanfare.mid");
		Audio.speakPlease();
		Audio.change();
		marcador.show();
		Vista.setCond(null);
	}
	public synchronized void setGameTime(int t){
		restTime=t;
		Vista.setTime(t);
	}
	public void start(){
		gd.setFullScreenWindow(this);
		Audio.setURL(getMusicPath(escenario));
    	Audio.change();
		Vista.setWall(escenario);
		//musica.play();
		timer.start();
		ejecutando=0;
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
	public void prepare(){
		ejecutando=0;
	}
	public void setVictory(int a){
		victory=a;
	}
	public void setCond(String a){
		Vista.setCond(a);
	}
	public void setCondBox(int a){
		Vista.setCondBox(a);
	}
	public Pack getPack(){
		return (PE);
	}
	public void setOos(ObjectOutputStream []o){
		this.oos=o;
	}
	public int []setTankCoords(int cant,int tank){
		int a[]=new int[2];
		switch(cant){
		case 1:
			a[0]=480;
			a[1]=355;
			break;
		case 2:
			switch (tank){
			case 0:
				a[0]=480;
				a[1]=175;
				break;
			case 1:
				a[0]=480;
				a[1]=525;
				break;
			}
			break;
		case 3:
			switch (tank){
			case 0:
				a[0]=480;
				a[1]=175;
				break;
			case 1:
				a[0]=240;
				a[1]=525;
				break;
			case 2:
				a[0]=720;
				a[1]=525;
				break;
			}
			break;
		case 4:
			switch(tank){
			case 0:
				a[0]=240;
				a[1]=175;
				break;
			case 1:
				a[0]=480;
				a[1]=175;
				break;
			case 2:
				a[0]=240;
				a[1]=525;
				break;
			case 3:
				a[0]=480;
				a[1]=525;
			}
		}
		return(a);
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mousePressed(MouseEvent e) {
		if(PE.getTank()[3]!=null){
			PE.getTank()[3].disparar();
		}
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseWheelMoved(MouseWheelEvent e) {
		if(PE.getTank()[3]!=null){
			 if(e.getWheelRotation()<0){
				 PE.getTank()[3].mouseRotarDer();
			 }else{
				 PE.getTank()[3].mouseRotarIzq();
			 }
		}
	}


	public boolean isFirst() {
		return first;
	}


	public void setFirst(boolean first) {
		this.first = first;
	}
}
