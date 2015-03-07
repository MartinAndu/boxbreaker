package Generic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;















import Resources.Audio;
import Resources.Imagen;

public class FrameNivel extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu panel=new Menu();
	@SuppressWarnings("rawtypes")
	private JList levelList;
	@SuppressWarnings("rawtypes")
	private JList esceList;
	@SuppressWarnings("rawtypes")
	private JComboBox levels;
	@SuppressWarnings("rawtypes")
	private JComboBox tankSkin[];
	@SuppressWarnings("rawtypes")
	private JComboBox tankControls[];
	@SuppressWarnings("rawtypes")
	private JComboBox playerNum;
	private JCheckBox soundSwitch;
	private JButton back;
	private JButton jugar;
	private int tipo;
	private Thread condicion;
	private Thread Tiempo;
	private FrameGame Game;
	private JLabel lblNivel;
	private JLabel lblEsce;
	private JLabel lblSound;
	private Nivel nivel;
	private int tiempo;
	private int puntajeTotal;
	private boolean accionUsuario=true;
	private boolean inBonus=false;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrameNivel(){
		super();
		setBounds(10,10,600,600);
		setLayout(null);
		setVisible(false);
		setResizable(false);

		Game=new FrameGame(this);

		panel=new Menu();
		panel.setVisible(true);
		panel.setLayout(null);
		panel.setBounds(0,0,600,600);
		panel.setBackground(Imagen.loadImg("Images\\Gifs\\Selector.JPG"));

		lblNivel=new JLabel("Niveles:");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setBounds(10,10,100,40);

		lblEsce=new JLabel("Escenarios:");
		lblEsce.setForeground(Color.WHITE);
		lblEsce.setBounds(220,10,100,40);

		lblSound=new JLabel("Desactivar Sonido:");
		lblSound.setForeground(Color.WHITE);
		lblSound.setBounds(10,260,100,50);

		levels=new JComboBox();
		levels.setBounds(100,10,200,200);
		levelList=new JList();
		levelList.setBounds(10,50,200,200);

		esceList=new JList();
		esceList.setBounds(220,50,200,200);
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

		playerNum=new JComboBox();
		playerNum.setBounds(220,305,40,20);
		playerNum.addItem("2");
		playerNum.addItem("3");
		playerNum.addItem("4");
		playerNum.addActionListener(this);

		int pos;
		tankSkin=new JComboBox[4];
		for(pos=0;pos<tankSkin.length;pos++){
			tankSkin[pos]=new JComboBox();
			tankSkin[pos].setBounds(110,305+pos*(30),100,20);
			tankSkin[pos].addItem("Azul");
			tankSkin[pos].addItem("Negro");
			tankSkin[pos].addItem("Verde");
			tankSkin[pos].addItem("Violeta");
			tankSkin[pos].addItem("Naranja");
			panel.add(tankSkin[pos]);
		}
		tankControls=new JComboBox[4];
		for(pos=0;pos<tankControls.length;pos++){
			tankControls[pos]=new JComboBox();
			tankControls[pos].setBounds(10,305+pos*(30),100,20);
			loadControlCombo(pos);
			panel.add(tankControls[pos]);
			tankControls[pos].addActionListener(this);
		}

		jugar=new JButton("Empezar");
		jugar.addActionListener(this);
		jugar.setBounds(480,500,90,50);

		back=new JButton("Cancelar");
		back.addActionListener(this);
		back.setBounds(380,500,90,50);

		soundSwitch=new JCheckBox();
		soundSwitch.setBounds(110,275,20,20);

		add(panel);
		panel.add(soundSwitch);
		panel.add(jugar);
		panel.add(back);
		panel.add(lblNivel);
		panel.add(lblEsce);
		panel.add(lblSound);
		panel.add(levelList);
		panel.add(esceList);
		panel.add(playerNum);
	}
	public FrameNivel(int a){
	}
	public void setMultiplayerFrame(FrameGame g){
		Game=g;
	}
	@SuppressWarnings("deprecation")
	public void multiplayer(int num, int sce, int index){
		nivel=Nivel.getLevel(1,index);
		Tiempo=null;
		Tiempo=new Thread(new thread1(nivel.getTime(),Game));//Setea el tiempo en segundos=primer parametro
		Game.prepare();
		nivel.setEscenario(sce);
		Game.createPack(nivel,getTanks(num,1));
		Tiempo.start();
		Game.show();
		Game.start();
		hide();
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jugar){
			if(inputDifferent() || tipo!=0){
				if(soundSwitch.isSelected()){
					Audio.silencePlease();
				}else{
					Audio.speakPlease();
				}


				switch(tipo){
					case 0:
						nivel=Nivel.getLevel(Nivel.normal,levelList.getSelectedIndex());
						Tiempo=null;
						Tiempo=new Thread(new thread1(nivel.getTime(),Game));//Setea el tiempo en segundos=primer parametro
						Game.prepare();
						nivel.setEscenario(esceList.getSelectedIndex());
						Game.createPack(nivel,getTanks(playerNum.getSelectedIndex()+2));
						Tiempo.start();
						Game.show();
						Game.start();
						hide();
						break;
					case 1:
						nivel=Nivel.getLevel(Nivel.normal,levelList.getSelectedIndex());
						int t=(int)(Math.random()*3)+1;
						condicion=null;
						condicion=new Thread(new Condicion(t,Game,nivel.getBoxCant()*nivel.getContainer().length));
						Game.prepare();
						nivel.setEscenario(esceList.getSelectedIndex());
						Game.createPack(nivel,getTanks(1));
						condicion.start();
						Game.show();
						Game.start();
						hide();
						break;
					case 2:
						nivel=Nivel.getLevel(Nivel.normal,levelList.getSelectedIndex());
						Tiempo=null;
						Tiempo=new Thread(new thread1(nivel.getTime(),Game));//Setea el tiempo en segundos=primer parametro
						Game.prepare();
						nivel.setEscenario(esceList.getSelectedIndex());
						Game.createPack(nivel,getTanks(1));
						Tiempo.start();
						Game.show();
						Game.start();
						hide();
						break;
					case 3:
						nivel=Nivel.getLevel(Nivel.arcade,levelList.getSelectedIndex());
						Tiempo=null;
						Tiempo=new Thread(new thread1(nivel.getTime(),Game));//Setea el tiempo en segundos=primer parametro
						Game.prepare();
						Game.createPack(nivel,getTanks(1));
						Tiempo.start();
						Game.show();
						Game.start();
						hide();
						break;
				}
			}else{
				JOptionPane.showMessageDialog(null,"Dos o mas Controles se están interfieriendo","BoxBreaker", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource()==back){
			hide();
		}


			if(e.getSource()==playerNum){
				switch(playerNum.getSelectedIndex()){
				case 0:
					tankSkin[0].show();tankSkin[1].show();tankSkin[2].hide();tankSkin[3].hide();
					tankControls[0].show();tankControls[1].show();tankControls[2].hide();tankControls[3].hide();
					panel.repaint();
				break;
				case 1:
					tankSkin[0].show();tankSkin[1].show();tankSkin[2].show();tankSkin[3].hide();
					tankControls[0].show();tankControls[1].show();tankControls[2].show();tankControls[3].hide();
					panel.repaint();
				break;
				case 2:
					tankSkin[0].show();tankSkin[1].show();tankSkin[2].show();tankSkin[3].show();
					tankControls[0].show();tankControls[1].show();tankControls[2].show();tankControls[3].show();
				break;
			}
		}
	}
	@SuppressWarnings("deprecation")
	public void loadNextLevel(){
		if(nivel.getCode()+1<7){
			Power.stopEfecto();
			if(tiempo<nivel.getBonus() || inBonus){
				inBonus=false;
				nivel=Nivel.getLevel(Nivel.arcade,nivel.getCode()+1);
				Tiempo=null;
				Tiempo=new Thread(new thread1(nivel.getTime(),Game));//Setea el tiempo en segundos=primer parametro
				Game.prepare();
				Game.createPack(nivel,getTanks(1));
				Tiempo.start();
				Game.show();
				Game.start();
			}else{
				inBonus=true;
				Tiempo=null;
				Tiempo=new Thread(new thread1(tiempo,Game));//Setea el tiempo en segundos=primer parametro
				Game.prepare();
				Game.createPack(Nivel.getLevel(Nivel.bonus,0),getTanks(1));
				Tiempo.start();
				Game.show();
				Game.start();
			}
		}
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void setTipo(int tip){
		tipo=tip;
		@SuppressWarnings("rawtypes")
		DefaultListModel model=new DefaultListModel();
		levelList.setModel(model);
		if(tipo==0){
			playerNum.show();playerNum.setSelectedIndex(0);
			tankSkin[0].show();tankSkin[1].show();tankSkin[2].hide();tankSkin[3].hide();
			tankControls[0].show();tankControls[1].show();tankControls[2].hide();tankControls[3].hide();
		}else{
			playerNum.hide();
			tankSkin[0].show();tankSkin[1].hide();tankSkin[2].hide();tankSkin[3].hide();
			tankControls[0].show();tankControls[1].hide();tankControls[2].hide();tankControls[3].hide();
		}
		if(tipo<3){
			esceList.show();
			lblEsce.show();
			lblNivel.setText("Niveles:");
			model.addElement("Standard");
			model.addElement("Los 5 Círculos");
			model.addElement("Olas");

			esceList.setSelectedIndex(0);
		}else{
			esceList.hide();
			lblEsce.hide();
			lblNivel.setText("Niveles:");
			model.addElement("Nivel 1");
			model.addElement("Nivel 2");
			model.addElement("Nivel 3");
			model.addElement("Nivel 4");
			model.addElement("Nivel 5");
			model.addElement("Nivel 6");
			model.addElement("Nivel 7");
		}
		levelList.setSelectedIndex(0);
	}
	public int getTipo(){
		return tipo;
	}

	public void setTime(int t){
		tiempo=t;
	}
	public int getTime(){
		return tiempo;
	}
	public void setTotalPoints(int tp){
		puntajeTotal=tp;
	}
	public int getTotalPoints(){
		return puntajeTotal;
	}

	private Tanque[] getTanks(int num){
		Tanque tanks[]=new Tanque [4];
		int a[];
		for(int pos=0;pos<num;pos++){
			if(tankControls[pos].getSelectedIndex()<4){
				a=Game.setTankCoords(num,pos);
				tanks[tankControls[pos].getSelectedIndex()]=new Tanque(a[0],a[1],tankSkin[pos].getSelectedIndex());
				tanks[tankControls[pos].getSelectedIndex()].setEstado(0);
				tanks[tankControls[pos].getSelectedIndex()].setPlayer(pos);
			}
		}

		int t=0;
		for(int pos=0;pos<num;pos++){
			if(tankControls[pos].getSelectedIndex()==4){
				a=Game.setTankCoords(num,pos);
				while(t<tanks.length && tanks[t]!=null)
					t++;

				tanks[t]=new Tanque(a[0],a[1],tankSkin[pos].getSelectedIndex());
				tanks[t].setEstado(0);
				tanks[t].setPlayer(-pos-1);
			}
		}
		return tanks;
	}

	@SuppressWarnings("unchecked")
	private void loadControlCombo(int pos){
		tankControls[pos].addItem("Teclado1");
		tankControls[pos].addItem("Teclado2");
		tankControls[pos].addItem("Teclado3");
		tankControls[pos].addItem("Mouse");
		tankControls[pos].addItem("PC");
	}

	private boolean inputDifferent(){
		boolean ret=true;
		for(int x=0;x<playerNum.getSelectedIndex()+1;x++){
			for(int y=x+1;y<playerNum.getSelectedIndex()+2;y++){
				if(tankControls[x].getSelectedIndex()==tankControls[y].getSelectedIndex())
					if(tankControls[x].getSelectedIndex()!=4 && tankControls[y].getSelectedIndex()!=4)
						ret=false;
			}
		}
		return ret;
	}
	private Tanque[] getTanks(int num,int skun){
		Tanque tanks[]=new Tanque [num];
		int a[];
		for(int pos=0;pos<tanks.length;pos++){
			a=Game.setTankCoords(num,pos);
			tanks[pos]=new Tanque(a[0],a[1],1);
			tanks[pos].setEstado(0);
		}
		return tanks;
	}
	public boolean isAccionUsuario() {
		return accionUsuario;
	}
	public void setAccionUsuario(boolean accionUsuario) {
		this.accionUsuario = accionUsuario;
	}
}
