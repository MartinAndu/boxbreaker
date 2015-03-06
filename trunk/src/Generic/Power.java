package Generic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Box.Caja;
import Resources.Imagen;
import Resources.Pista;

public class Power{
	private static int SegundosEfectoCajas=0;
	private static int SegundosEfectoTanque[];
	private static int SegundosDetenidos[];
	private static int SegundosEfectoFantasma=0;
	private static int SegundosEfectoT;

	private final static int cantEfectos=8;
	private final static int cajasRapidas=1;
	private final static int cajasLentas=2;
	private final static int cajasDetenidas=3;
	private final static int tanqueGrande=4;
	private final static int tanqueRapido=5;
	private final static int tanqueDetenido=6;
	private final static int cajasFantasmas=7;
	private final static int masPuntaje=8;
	private final static int menosPuntaje=9;

	private static Tanque tanks[];
	private static BufferedImage cajasRapidasI=Imagen.loadImg("Images/Efectos/cajasRapidas.GIF");
	private static BufferedImage cajasLentasI=Imagen.loadImg("Images/Efectos/cajasLentas.GIF");
	private static BufferedImage cajasDetenidasI=Imagen.loadImg("Images/Efectos/cajasDetenidas.GIF");
	private static BufferedImage tanqueGrandeI=Imagen.loadImg("Images/Efectos/tanqueGrande.GIF");
	private static BufferedImage tanqueRapidoI=Imagen.loadImg("Images/Efectos/tanqueRapido.GIF");
	private static BufferedImage tanqueDetenidoI=Imagen.loadImg("Images/Efectos/tanqueDetenido.GIF");
	private static BufferedImage cajasFantasmasI=Imagen.loadImg("Images/Efectos/ghostBoxes.GIF");
	private static BufferedImage masPuntajeI=Imagen.loadImg("Images/Efectos/masPuntaje.GIF");
	private static BufferedImage menosPuntajeI=Imagen.loadImg("Images/Efectos/menosPuntaje.GIF");

	private static int efectoActual;
	private static int estadoNuevo[];
	private static Pista sound;



	public static void startEfecto(int numEfecto,int tank){
		//1 segundo =40 vuelta

		efectoActual=numEfecto;
	
		switch (numEfecto){
			case (cajasRapidas):{
				SegundosEfectoCajas=200;
				Caja.setVelocidadExtra(20);
				sound=new Pista("Sounds\\WAV\\speedUP.wav",1);
				sound.play();
				break;
			}

			case (cajasLentas):{
				SegundosEfectoCajas=200;
				Caja.setVelocidadExtra(9999);
				break;
			}

			case (cajasDetenidas):{
				SegundosEfectoCajas=200;
				Caja.setVelocidadExtra(-9999);
				sound=new Pista("Sounds\\WAV\\speedDOWN.wav",1);
				sound.play();
				break;
			}
			
			case (cajasFantasmas):{
				SegundosEfectoCajas=400;
				SegundosEfectoFantasma=50;
				Caja.setFantasma(true);
				break;
			}

			case (tanqueGrande):{
				SegundosEfectoTanque[tank]=400;
				tanks[tank].setEstado(1);
				estadoNuevo[tank]=tanks[tank].getEstado();
				SegundosEfectoT=80;
				sound=new Pista("Sounds\\WAV\\powerUP.wav",1);
				sound.play();
				break;
			}

			case (tanqueRapido):{
				SegundosEfectoTanque[tank]=400;
				tanks[tank].setEstado(2);
				estadoNuevo[tank]=tanks[tank].getEstado();
				SegundosEfectoT=80;
				sound=new Pista("Sounds\\WAV\\powerUP.wav",1);
				sound.play();
				break;
			}
			case (tanqueDetenido):{
				SegundosDetenidos[tank]=200;
				tanks[tank].setVelocidad(0);
				SegundosEfectoT=80;
				sound=new Pista("Sounds\\WAV\\cold.wav",1);
				sound.play();
				break;
			}
			case (masPuntaje):{
				SegundosEfectoCajas=200;
				Caja.setMultiplo(2);
				break;
			}
			case (menosPuntaje):{
				SegundosEfectoCajas=200;
				Caja.setMultiplo(0.5);
				break;
			}
		}
	}
	
	public static void setTanks(Tanque t[]){
		estadoNuevo=new int[t.length];
		SegundosEfectoTanque=new int[t.length];
		SegundosDetenidos=new int[t.length];
		tanks=t;
	}
	
	public static void runEfecto(){
		if (SegundosEfectoCajas>0){
			SegundosEfectoCajas--;
			if (SegundosEfectoFantasma>0){
				SegundosEfectoFantasma--;
				if (SegundosEfectoFantasma==0){
					if (Caja.isFantasma()==true)
						Caja.setFantasma(false);
					else{
						Caja.setFantasma(true);
					}
					SegundosEfectoFantasma=50;
				}

			}

		}else{
			SegundosEfectoFantasma=0;
			Caja.setFantasma(false);
			Caja.setVelocidadExtra(0);
		}

		SegundosEfectoT--;
		for(int pos=0;pos<tanks.length;pos++){
			if (SegundosDetenidos[pos]>0){
				SegundosDetenidos[pos]--;
				if (SegundosDetenidos[pos]<80){
					if (SegundosDetenidos[pos]%2==0){
						tanks[pos].setVelocidad(5);
					}else{
						tanks[pos].setVelocidad(0);
					}
				}
			}else{
				if (SegundosEfectoTanque[pos]>0){
					SegundosEfectoTanque[pos]--;
					if (SegundosEfectoTanque[pos]<80){
						if (SegundosEfectoTanque[pos]%2==0){
							tanks[pos].setEstado(0);
						}else{
							tanks[pos].setEstado(estadoNuevo[pos]);
						}
					}
				}
			}
		}
	}
	public static void stopEfecto(){
		SegundosEfectoCajas=0;
		SegundosEfectoFantasma=0;
		efectoActual=0;
		for(int pos=0;pos<tanks.length;pos++){
			SegundosEfectoTanque[pos]=0;
			SegundosDetenidos[pos]=0;
			efectoActual=0;
		}
	}
	
	private static BufferedImage getImage(){
		switch (efectoActual){
			case (cajasRapidas):{
				return (cajasRapidasI);
			}
			case (cajasLentas):{
				return (cajasLentasI);
			}
			case (cajasDetenidas):{
				return (cajasDetenidasI);
			}
			case (tanqueGrande):{
				return (tanqueGrandeI);
			}
			case (tanqueRapido):{
				return (tanqueRapidoI);
			}
			case (tanqueDetenido):{
				return (tanqueDetenidoI);
			}
			case (cajasFantasmas):{
				return (cajasFantasmasI);
			}
			case (masPuntaje):{
				return (masPuntajeI);
			}
			case (menosPuntaje):{
				return (menosPuntajeI);
			}
			default:
				return (null);
		}
	}
	
	public static boolean tankStopped(int t){
		if(SegundosDetenidos[t]==0){
			return false;
		}else{
			return true;
		}
	}
	public static void draw(Graphics g){
		if (SegundosEfectoCajas>200-80 || SegundosEfectoT>0){
			g.drawImage(getImage(), 10,570, null);
		}
	}
	public static int getSegundosEfectoFantasma() {
		return SegundosEfectoFantasma;
	}

	public static int getCantefectos() {
		return cantEfectos;
	}
}