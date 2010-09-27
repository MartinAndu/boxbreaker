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
		super("BoxBreaker Alpha 1");
		setBounds(0,0,200,320);
		setLayout(null);
		Container C= this.getContentPane();
		Game=new FrameGame();
		//Componentes de PPALe(Menú principal)
			PPALe=new Menu();
			PPALe.setBackground(I.loadImg("Panel1.GIF"));
			
			One=new JButton("Un Jugador");
			One.setBounds(40,10,110,70);
			One.addActionListener(this);
			One.setVisible(true);
			
			Mult=new JButton("Multijugador");
			Mult.setBounds(40,100,110,70);
			Mult.addActionListener(this);
			Mult.setVisible(true);
			
			Salir=new JButton("Salir");
			Salir.setBounds(40,200,110,70);
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
			OnePlayer.setBackground(I.loadImg("Panel2.GIF"));
			
			Normal=new JButton("Modo Normal");
			Normal.setBounds(40,10,110,70);
			Normal.addActionListener(this);
			
			Time=new JButton("TimeLimit");
			Time.setBounds(40,100,110,70);
			Time.addActionListener(this);
			
			Volver=new JButton("Volver");
			Volver.setBounds(40,200,110,70);
			Volver.addActionListener(this);
			
			//Agregado de Componentes
			OnePlayer.add(Normal);
			OnePlayer.add(Time);
			OnePlayer.add(Volver);
			OnePlayer.setVisible(true);
		//
			
		//Componentes de Multiplayer(Menú de Multijugador)
			Multiplayer=new Menu();
			Multiplayer.setBackground(I.loadImg("Panel3.GIF"));
			
			Versus=new JButton("Modo Versus");
			Versus.setBounds(40,10,110,70);
			Versus.addActionListener(this);
			
			Multi=new JButton("Modo en Red");
			Multi.setBounds(40,100,110,70);
			Multi.addActionListener(this);
			
			Back=new JButton("Volver");
			Back.setBounds(40,200,110,70);
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
			OnePlayer.repaint();
		}
		if (e.getSource()==Mult){
			PPALe.hide();
			Multiplayer.show();
			Multiplayer.repaint();
		}
		if (e.getSource()==Volver){
			OnePlayer.hide();
			PPALe.show();
			PPALe.repaint();
		}
		if (e.getSource()==Back){
			Multiplayer.hide();
			PPALe.show();
			PPALe.repaint();
		}
		if (e.getSource()==Salir){
			System.exit(0);
		}
		
		if(e.getSource()==Normal){
			Game.setVisible(true);
		}

	}
}



