package Generic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JFrame;
import javax.swing.JPanel;



public class Marcador extends JFrame implements KeyListener{
	private String v[];
	private MenuText panel;
	public Marcador(){
		super();
		setLayout(null);
		setUndecorated(true);
		setVisible(false);
		setBounds(150,150,450,332);
		
		panel=new MenuText();
		panel.setBounds(0,0,450,332);
		Imagen I=new Imagen();
		panel.setBackground(I.loadImg("Marcador.jpg"));
		add(panel);
		
		v=new String[13];
		panel.setVisible(true);
	
		addKeyListener(this);
	}
	
	public void setPuntos(int puntos) {
		v[0]="Puntos: "+String.valueOf(puntos);
	}
	public void setTiempo(int tiempo) {
		v[1]="Tiempo: "+String.valueOf(tiempo);
	}
	public void setAzules(int azules){
		v[2]="Azules * "+String.valueOf(azules);
	}
	public void setBlancas(int blancas){
		v[3]="Blancas * "+String.valueOf(blancas);
	}
	public void setRojas(int rojas){
		v[4]="Rojas * "+String.valueOf(rojas);
	}
	public void setVerdes(int verdes){
		v[5]="Verdes * "+String.valueOf(verdes);
	}
	public void setNaranjas(int naranjas){
		v[6]="Naranjas * "+String.valueOf(naranjas);
	}
	public void setVioletas(int violetas){
		v[7]="Azules * "+String.valueOf(violetas);
	}
	public void setCelestes(int celestes){
		v[8]="Celestes * "+String.valueOf(celestes);
	}
	public void setPlateadas(int plateadas){
		v[9]="Plateadas * "+String.valueOf(plateadas);
	}
	public void setDoradas(int doradas){
		v[10]="Doradas * "+String.valueOf(doradas);
	}
	public void setCant(int i){
		v[11]="Cajas Restantes: "+String.valueOf(i);
	}
	public void setCantD(int i){
		v[12]="Cajas Destruidas: "+String.valueOf(i);
	}
	
	public void escribir(){
		panel.setStringVector(v);
		panel.repaint();
	}

	public void keyPressed(KeyEvent e) {
		this.hide();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	
