package Generic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Box.Caja;


import java.awt.image.ImageObserver;



public class theFrame extends JFrame implements ActionListener {
	private Menu PPALe;
	private JButton Normal;private JButton Time;private JButton Multi; private JButton Versus;
	private JButton One; private JButton Mult;
	private JButton Salir; private JButton Volver; private JButton Back;
	private Menu Multiplayer;
	private Menu OnePlayer;
	private FrameGame Game;
	private Imagen I=new Imagen();
	public theFrame(){
		super("BoxBreaker Alpha 2");
		setBounds(150,150,200,320);
		setLayout(null);
		Container C= this.getContentPane();
		Caja.loadImages();
		Game=new FrameGame();
		//Componentes de PPAL(Menú principal)
			PPALe=new Menu();
			PPALe.setBackground(I.loadImg("T.GIF"));
			
			One=new JButton(new ImageIcon(I.loadImg("UnJugador.GIF")));
			One.setBounds(15,15,155,50);
			One.addActionListener(this);
			One.setVisible(true);
			
			Mult=new JButton(new ImageIcon(I.loadImg("Multijugador.GIF")));
			Mult.setBounds(15,100,155,50);
			Mult.addActionListener(this);
			Mult.setVisible(true);
			
			Salir=new JButton(new ImageIcon(I.loadImg("Salir.GIF")));
			Salir.setBounds(15,200,155,50);
			Salir.addActionListener(this);
			Salir.setVisible(true);
			
			//Agregado de Componentes
			PPALe.add(One);
			PPALe.add(Mult);
			PPALe.add(Salir);
			PPALe.setVisible(true);
		//
		
		//Componentes de OnePlayer(Menú un solo jugador)
			OnePlayer=new Menu();
			OnePlayer.setBackground(I.loadImg("T.GIF"));
			
			Normal=new JButton(new ImageIcon(I.loadImg("ModoNormal.GIF")));
			Normal.setBounds(15,15,155,50);
			Normal.addActionListener(this);
			
			Time=new JButton(new ImageIcon(I.loadImg("TimeLimit.GIF")));
			Time.setBounds(15,100,155,50);
			Time.addActionListener(this);
			
			Volver=new JButton(new ImageIcon(I.loadImg("Volver.GIF")));
			Volver.setBounds(15,200,155,50);
			Volver.addActionListener(this);
			
			//Agregado de Componentes
			OnePlayer.add(Normal);
			OnePlayer.add(Time);
			OnePlayer.add(Volver);
			OnePlayer.setVisible(true);
		//
			
		//Componentes de Multiplayer(Menú de Multijugador)
			Multiplayer=new Menu();
			Multiplayer.setBackground(I.loadImg("T.GIF"));
			
			Versus=new JButton(new ImageIcon(I.loadImg("Versus.GIF")));
			Versus.setBounds(15,15,155,50);
			Versus.addActionListener(this);
			
			Multi=new JButton(new ImageIcon(I.loadImg("red.GIF")));
			Multi.setBounds(15,100,155,50);
			Multi.addActionListener(this);
			
			Back=new JButton(new ImageIcon(I.loadImg("Volver.GIF")));
			Back.setBounds(15,200,155,50);
			Back.addActionListener(this);
			
			//Agregado de Componentes
			Multiplayer.add(Versus);
			Multiplayer.add(Multi);
			Multiplayer.add(Back);
			Multiplayer.setVisible(true);
		//
			
		//Agregado de Componentes al Container
			C.add(PPALe);
			C.add(OnePlayer);
			C.add(Multiplayer);
			setContentPane(C);
			setVisible(true);
		//
			
		OnePlayer.hide();
		Multiplayer.hide();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==One){
			PPALe.hide();
			OnePlayer.show();
			//OnePlayer.repaint();
		}
		if (e.getSource()==Mult){
			PPALe.hide();
			Multiplayer.show();
			//Multiplayer.repaint();
		}
		if (e.getSource()==Volver){
			OnePlayer.hide();
			PPALe.show();
			//PPALe.repaint();
		}
		if (e.getSource()==Back){
			Multiplayer.hide();
			PPALe.show();
			//PPALe.repaint();
		}
		if (e.getSource()==Salir){
			System.exit(0);
		}
		
		if(e.getSource()==Normal){
			Game.show();
			Game.start();
		}

	}
}



