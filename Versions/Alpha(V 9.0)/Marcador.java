import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Marcador extends JFrame implements MouseListener{
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
		
		v=new String[2];
		panel.setVisible(true);
	
		addMouseListener(this);
	}
	
	public void setPuntos(int puntos) {
		v[0]="Puntos: "+String.valueOf(puntos);
	}

	public void setTiempo(int tiempo) {
		v[1]="Tiempo: "+String.valueOf(tiempo);
	}

	public void paintComponent(Graphics g){
	
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
		this.hide();
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void escribir(){
		panel.setStringVector(v);
		panel.repaint();
	}
}
