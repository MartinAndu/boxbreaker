package Generic;
import Red.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Resources.Imagen;
public class partyFrame extends JFrame implements MouseMotionListener,ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton join;
	private JButton create;
	private MenuText panel;
	private MenuText panelJoin;
	private MenuText panelCreate;
	private int Menu;
	private JLabel lblEsce;
	private JLabel lblSound;
	@SuppressWarnings("rawtypes")
	private JComboBox[] tankSkin;
	@SuppressWarnings("rawtypes")
	private JList esceList;
	private JLabel lblNivel;
	@SuppressWarnings("rawtypes")
	private JList levelList;
	private JCheckBox soundSwitch;
	private JLabel lblPlayers;
	@SuppressWarnings("unused")
	private JTextField jtfPlayers;
	@SuppressWarnings("rawtypes")
	private JComboBox players;
	private JButton crear;
	private JLabel lblIP;
	private JTextField jtfIP;
	private JButton unirse;
	private JLabel lblPort;
	private JTextField jtfPort;
	private JButton atras;
	private theFrame anterior;
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	public partyFrame(theFrame ppal){
		super("En-Red");
		anterior=ppal;
		Menu=0;
		Container C=getContentPane();
		setLayout(null);
		//setUndecorated(true);
		setVisible(false);
		setBounds(200,300,400,300);
		Imagen I=new Imagen();
		
		panel=new MenuText();
		panel.setBounds(0,0,400,300);
		panel.setBackground(I.loadImg("Images/Gifs/Party.jpg"));
		
		panelCreate=new MenuText();
		panelCreate.setBounds(0,0,400,300);
		panelCreate.setBackground(I.loadImg("Images/Gifs/Party.jpg"));
		panelCreate.setVisible(false);
		
		panelJoin=new MenuText();
		panelJoin.setBounds(0,0,400,300);
		panelJoin.setBackground(I.loadImg("Images/Gifs/Party.jpg"));
		panelJoin.setVisible(false);
		//JLabels
		lblEsce=new JLabel("Escenarios:");
		lblEsce.setForeground(Color.WHITE);
		lblEsce.setBounds(220,10,100,40);
		lblEsce.setVisible(true);
		lblSound=new JLabel("Activar Sonido:");
		lblSound.setForeground(Color.WHITE);
		lblSound.setBounds(10,150,100,50);
		lblSound.setVisible(true);
		lblNivel=new JLabel("Niveles:");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setBounds(10,10,100,40);
		lblNivel.setVisible(true);
		lblPlayers=new JLabel("Jugadores:");
		lblPlayers.setBounds(10,120,100,40);
		lblPlayers.setForeground(Color.WHITE);
		lblPlayers.setVisible(true);
		lblIP=new JLabel("Ingrese IP:");
		lblIP.setBounds(10,50,100,20);
		lblIP.setForeground(Color.WHITE);
		lblIP.setVisible(true);
		lblPort=new JLabel("Ingrese Puerto: ");
		lblPort.setBounds(220,50,100,20);
		lblPort.setForeground(Color.WHITE);
		lblPort.setVisible(true);

		//JTextField IP
		jtfIP=new JTextField();
		jtfIP.setBounds(10,70,100,20);
		jtfIP.setForeground(Color.BLACK);
		jtfIP.setVisible(true);

		//JTextField Puerto
		jtfPort=new JTextField();
		jtfPort.setBounds(220,70,100,20);
		jtfPort.setForeground(Color.BLACK);
		jtfPort.setVisible(true);

		//JButton Atras
		atras=new JButton(new ImageIcon(I.loadImg("Images/Gifs/atras.gif")));
		atras.setBounds(10,200,154,50);
		atras.addActionListener(this);
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		atras.setVisible(true);

		//JButton Create, para crear una partida
		create=new JButton(new ImageIcon(I.loadImg("Images/Gifs/create.GIF")));
		create.setBounds(100,50,154,50);
		create.addActionListener(this);
		create.setContentAreaFilled(false);
		create.setBorderPainted(false);

		//JButton Join, para unirse a partida
		join=new JButton(new ImageIcon(I.loadImg("Images/Gifs/unirse.GIF")));
		join.setBounds(100,150,154,50);
		join.addActionListener(this);
		join.setContentAreaFilled(false);
		join.setBorderPainted(false);

		//JButon unirse
		unirse=new JButton(new ImageIcon(I.loadImg("Images/Gifs/unirse.GIF")));
		unirse.setBounds(200,200,154,50);
		unirse.addActionListener(this);
		unirse.setContentAreaFilled(false);
		unirse.setBorderPainted(false);
		unirse.setVisible(true);


		//JButton Crear
		crear=new JButton(new ImageIcon(I.loadImg("Images/Gifs/create.GIF")));
		crear.setBounds(200,200,154,50);
		crear.addActionListener(this);
		crear.setContentAreaFilled(false);
		crear.setBorderPainted(false);
		crear.setVisible(true);

		//Players Combo
		players=new JComboBox();
		for(int pos=2;pos<5;pos++){
			players.addItem(String.valueOf(pos));
		}
		players.setBounds(100,130,40,20);
		players.setVisible(true);

		//Skins
		tankSkin=new JComboBox[4];
		for(int pos=0;pos<tankSkin.length;pos++){
			tankSkin[pos]=new JComboBox();
			tankSkin[pos].setBounds(10+(pos*100),295,100,20);
			tankSkin[pos].addItem("Azul");
			tankSkin[pos].addItem("Negro");
			tankSkin[pos].addItem("Verde");
			tankSkin[pos].addItem("Violeta");
			tankSkin[pos].addItem("Naranja");
			tankSkin[pos].setVisible(true);
			panel.add(tankSkin[pos]);
		}

		//JList
		esceList=new JList();
		esceList.setBounds(220,50,200,140);
		esceList.setVisible(true);
		levelList=new JList();
		levelList.setBounds(10,50,200,60);
		levelList.setVisible(true);

		//CheckBox
		soundSwitch=new JCheckBox();
		soundSwitch.setBounds(110,150,20,20);
		soundSwitch.setVisible(true);

		//Agregar cosas al panel y setear el contentPane
		panel.add(atras);
		/*panelJoin.add(atras);
		panelCreate.add(atras);*/
		panelJoin.add(jtfPort);
		panelJoin.add(lblPort);
		panelJoin.add(unirse);
		panelJoin.add(jtfIP);
		panelJoin.add(lblIP);
		panelJoin.add(lblSound);
		panelCreate.add(players);
		panelCreate.add(lblPlayers);
		panelJoin.add(soundSwitch);
		panelCreate.add(soundSwitch);
		panel.add(create);
		panel.add(join);
		panelCreate.add(crear);
		panelCreate.add(esceList);
		panelCreate.add(lblNivel);
		panelCreate.add(lblSound);
		panelCreate.add(lblEsce);
		panelCreate.add(levelList);
		C.add(panelJoin);
		C.add(panelCreate);
		C.add(panel);
		setContentPane(C);
		this.addMouseMotionListener(this);



		//add(panel);
	}

	public void mouseDragged(MouseEvent me){

	}
	@SuppressWarnings("static-access")
	public void mouseMoved(MouseEvent me){
		Point a=me.getPoint();
		Imagen I=new Imagen();
		switch(Menu){
		case 0:
			//Caso '
			if ((a.x >=100)&&(a.x<=(254))){
				if ((a.y>=50)&(a.y<=100)){
					create.setIcon(new ImageIcon(I.loadImg("Images/Gifs/createH.png")));
					
				}else{
					if ((a.y>=150)&(a.y<=200)){
					join.setIcon(new ImageIcon(I.loadImg("Images/Gifs/unirseH.png")));
					
					}else{
						create.setIcon(new ImageIcon(I.loadImg("Images/Gifs/create.GIF")));
						join.setIcon(new ImageIcon(I.loadImg("Images/Gifs//unirse.GIF")));
					}
				}

			}else{
				create.setIcon(new ImageIcon(I.loadImg("Images/Gifs/create.GIF")));
				join.setIcon(new ImageIcon(I.loadImg("Images/Gifs/unirse.GIF")));
			}
			//Fin Caso 0
			break;
		case 1:
			//Caso 1
			if ((a.x >=200)&&(a.x<=354)&&(a.y>200)&&(a.y<=250)){
				crear.setIcon(new ImageIcon(I.loadImg("Images/Gifs/createH.png")));
			}else{
				crear.setIcon(new ImageIcon(I.loadImg("Images/Gifs/create.GIF")));
			}
			break;
			//fin Caso 1
		case 2:
			//Caso 2
			if ((a.x >=200)&&(a.x<=354)&&(a.y>200)&&(a.y<=250)){
				unirse.setIcon(new ImageIcon(I.loadImg("Images/Gifs/unirseH.png")));
			}else{
				unirse.setIcon(new ImageIcon(I.loadImg("Images/Gifs/unirse.GIF")));
			}
			break;
		}
		if ((a.x >=10)&&(a.x<=164)&&(a.y>200)&&(a.y<=250)){
			atras.setIcon(new ImageIcon(I.loadImg("Images/Gifs/atrasH.png")));
		}else{
			atras.setIcon(new ImageIcon(I.loadImg("Images/Gifs/atras.gif")));
		}
			//10,200,154,50
	}
	@SuppressWarnings({ "deprecation", "unused" })
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==join){
			Menu=2;
			panelJoin.show();
			panelCreate.hide();
			panel.hide();
			setType(2);
			panelJoin.add(atras);
			panelJoin.add(lblSound);
			panelJoin.add(soundSwitch);
			
		}
		if (e.getSource()==create){
			Menu=1;
			panelJoin.hide();
			panelCreate.show();
			panel.hide();
			setType(1);
			panelCreate.add(lblSound);
			panelCreate.add(atras);
			panelCreate.add(soundSwitch);
		}
		if (e.getSource()==atras){
			if (Menu!=0){
				setType(0);
				panelCreate.hide();
				panelJoin.hide();
				panel.show();
				Menu=0;
				panel.add(atras);
			}else{
				anterior.show();
				this.hide();
			}
		}
		if (e.getSource()==crear){
			servidor server=new servidor(Integer.valueOf(String.valueOf(players.getItemAt(players.getSelectedIndex()))),levelList.getSelectedIndex() ,esceList.getSelectedIndex());
		}
		
		if (e.getSource()==unirse){
			cliente client=new cliente(Integer.valueOf(jtfPort.getText()),jtfIP.getText());
		}

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setType(int a){
		/*lblSound.setVisible(true);
		soundSwitch.setVisible(true);*/
		switch(a){
		case 0:
			break;
		case 1:
			DefaultListModel model=new DefaultListModel();
			lblNivel.setText("Niveles:");
			levelList.setModel(model);
			model.addElement("Standard");
			model.addElement("Los 5 Círculos");
			model.addElement("Olas");

			DefaultListModel model2=new DefaultListModel();
			esceList.setModel(model2);
			lblEsce.setText("Escenarios:");
			model2.addElement("Standard");
			model2.addElement("Apolo");
			model2.addElement("Luna llena");
			model2.addElement("Park");
			model2.addElement("Invierno");
			model2.addElement("Nocturn");
			model2.addElement("Camino a la Montaña");
			esceList.setSelectedIndex(0);
			break;
		case 2:
			break;
		}

	}
	//public void Action

}
