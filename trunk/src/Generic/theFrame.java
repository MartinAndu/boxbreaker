package Generic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Container;

import javax.swing.ImageIcon;

import Resources.Imagen;



public class theFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu PPALe;
	private JButton Arcade;JButton Normal;private JButton Time;private JButton Multi; private JButton Versus;
	private JButton One; private JButton Mult;
	private JButton Salir; private JButton Volver; private JButton Back;
	private Menu Multiplayer;
	private Menu OnePlayer;
	private	FrameNivel Partida;
	private partyFrame part;
	private Imagen I=new Imagen();
	@SuppressWarnings({ "static-access", "deprecation" })
	public theFrame(){
		super("BoxBreaker Alpha 2");
		setBounds(150,150,200,320);
		setLayout(null);
		Container C= this.getContentPane();
	//	Caja.loadImages();
		//Shot.loadImages();
		part=new partyFrame(this);
		Partida=new FrameNivel();
		//Componentes de PPAL(Menú principal)
			PPALe=new Menu();
			PPALe.setBackground(I.loadImg("Images\\Gifs\\T.GIF"));

			One=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\UnJugador.GIF")));
			One.setBounds(15,15,155,50);
			One.addActionListener(this);
			One.setVisible(true);

			Mult=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\Multijugador.GIF")));
			Mult.setBounds(15,100,155,50);
			Mult.addActionListener(this);
			Mult.setVisible(true);

			Salir=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\Salir.GIF")));
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
			OnePlayer.setBackground(I.loadImg("Images\\Gifs\\T.GIF"));

			Arcade=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\ModoArcade.GIF")));
			Arcade.setBounds(15,15,155,50);
			Arcade.addActionListener(this);

			Normal=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\ModoNormal.GIF")));
			Normal.setBounds(15,75,155,50);
			Normal.addActionListener(this);

			Time=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\TimeLimit.GIF")));
			Time.setBounds(15,135,155,50);
			Time.addActionListener(this);

			Volver=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\Volver.GIF")));
			Volver.setBounds(15,200,155,50);
			Volver.addActionListener(this);

			//Agregado de Componentes
			OnePlayer.add(Arcade);
			OnePlayer.add(Normal);
			OnePlayer.add(Time);
			OnePlayer.add(Volver);
			OnePlayer.setVisible(true);
		//

		//Componentes de Multiplayer(Menú de Multijugador)
			Multiplayer=new Menu();
			Multiplayer.setBackground(I.loadImg("Images\\Gifs\\T.GIF"));

			Versus=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\Versus.GIF")));
			Versus.setBounds(15,15,155,50);
			Versus.addActionListener(this);

			Multi=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\red.GIF")));
			Multi.setBounds(15,100,155,50);
			Multi.addActionListener(this);

			Back=new JButton(new ImageIcon(I.loadImg("Images\\Gifs\\Volver.GIF")));
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

	@SuppressWarnings("deprecation")
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
			Partida.setTitle("Modo Normal");
			Partida.setTipo(1);
			Partida.show();
		}
		if(e.getSource()==Time){
			Partida.setTitle("Modo Time-Limit");
			Partida.setTipo(2);
			Partida.show();
		}
		if(e.getSource()==Arcade){
			Partida.setTitle("Modo Arcade");
			Partida.setTipo(3);
			Partida.show();
		}
		if(e.getSource()==Versus){
			Partida.setTitle("Modo Versus");
			Partida.setTipo(0);
			Partida.show();
		}
		if (e.getSource()==Multi){
			part.show();
			this.hide();
		}
	}
}



