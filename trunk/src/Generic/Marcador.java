package Generic;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Resources.Audio;
import Resources.Imagen;



public class Marcador extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int v[];
	private MenuText panel;
	private FrameNivel control;
	private boolean exit=false;
	@SuppressWarnings("static-access")
	public Marcador(FrameNivel contrl){
		super();
		setLayout(null);
		setUndecorated(true);
		setVisible(false);
		setBounds(150,150,607,331);
		
		panel=new MenuText();
		panel.setBounds(0,0,607,331);
		Imagen I=new Imagen();
		panel.setBackground(I.loadImg("Images/Gifs/newMarcador.jpg"));
		add(panel);
		
		control=contrl;
		
		v=new int[17];
		v[13]=v[14]=v[15]=v[16]=-1;
		panel.setVisible(true);
		
		addKeyListener(this);
	}
	
	public void setPuntos(int puntos,int tankNum) {
		if(tankNum>=0){
			v[13+tankNum]=puntos;
		}else{
			v[13+Math.abs(tankNum+1)]=puntos;
		}
	}
	public void setTiempo(int tiempo) {
		v[0]=tiempo;
	}
	public void setAzules(int azules){
		v[1]=azules;
	}
	public void setBlancas(int blancas){
		v[2]=blancas;
	}
	public void setRojas(int rojas){
		v[3]=rojas;
	}
	public void setVerdes(int verdes){
		v[4]=verdes;
	}
	public void setNaranjas(int naranjas){
		v[5]=naranjas;
	}
	public void setVioletas(int violetas){
		v[6]=violetas;
	}
	public void setCelestes(int celestes){
		v[7]=celestes;
	}
	public void setPlateadas(int plateadas){
		v[8]=plateadas;
	}
	public void setDoradas(int doradas){
		v[9]=doradas;
	}
	private void setCant(int i){
		v[10]=i;
	}
	public void setCantD(int i){
		v[11]=i;
	}
	public void setVictory(int a){
		switch(a){
		case 1:
			v[11]=0;
			break;
		case 2:
			v[12]=1;
			break;
		default:
			v[12]=2;
		}
	}
	
	public void escribir(){
		control.setTotalPoints(control.getTotalPoints()+v[0]);
		setCant(control.getTotalPoints());
		
		panel.setIntVector(v);
		panel.repaint();
	}

	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			this.hide();
			v[13]=v[14]=v[15]=v[16]=-1;
			if(control.getTipo()==3 && !exit){
				control.setTime(v[1]);
				control.loadNextLevel();
			}else{
				exit=false;
				control.setTotalPoints(0); 
				Audio.speakPlease();
				Audio.setURL("Sounds//recuerdoz2.mid");
		    	Audio.change();
			}
		}
	}
	
	public void setExit(boolean bool){
		exit=bool;
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	
