package Box;

import java.awt.image.BufferedImage;

import Generic.Imagen;
import Generic.Shot;


public class Caja {
	private double x;
	private double y;
	private int dir;
	private int Puntaje;
	private float Velocidad;
	private int spe;
	private int estado=0;
	private static BufferedImage Box[]=new BufferedImage[9];
	private static BufferedImage BoxLite[]=new BufferedImage[9];
	private static BufferedImage BoxMicro[]=new BufferedImage[9];
	
	private static int dAzules;
	private static int dBlancas;
	private static int dRojas;
	private static int dNaranjas;
	private static int dVerdes;
	private static int dVioletas;
	private static int dCelestes;
	private static int dPlateadas;
	private static int dDoradas;
	private static int Cant;
	private static int DCant;
	
	public Caja(int a){
		x=(int)(Math.random()*750);
		y=(int)(Math.random()*750);
		dir=(int)(Math.random()*360);
		Velocidad=1+(int)(Math.random()* 19);
		spe=getColor();
		Puntaje=calcularPuntaje();
		Cant++;
	}
	public Caja(int a, int b){
		x=(int)(Math.random()*750);
		y=(int)(Math.random()*750);
		dir=(int)(Math.random()*360);
		Velocidad=1+(int)(Math.random()* 19);
		spe=b;
		Puntaje=calcularPuntaje();
		Cant++;
	}
	private int calcularPuntaje(){
		switch (spe){
			case 0:
					return (20);
			case 1:
					return (40);
			case 2:
					return (100);
			case 3:
					return (200);
			case 4:
					return (500);
			case 5:
					return (1000);
			case 6:
					return (1200);
			case 7:
					return (5000);
			case 8:
					return (10000);
			default:
					return (0);
		}
	}
	
	private int getColor(){
		int color=(int)(1+Math.random()*64);
	
		if(color==1){
			return 8;
		}else{
			if(color>1 && color<4){
				return 7;
			}else{
				if(color>3 && color<8){
					return 6;
				}else{
					if(color>7 && color<16){
						return 5;
					}else{
						if(color>15 && color<32){
							return 4;
						}else{
							return (int)(Math.random()*4);
						}
					}
				}
			}
		}
	}
	public int getPoints(){
		return(Puntaje);
	}
	public float getVel(){
		return(Velocidad);
	}
	public int getSpe(){
		return(spe);
	}
	public void setX(double xVal){
		x=xVal;
	}
	public void setY(double yVal){
		y=yVal;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public int getDir(){
		return dir;
	}

	public void setToNextX(){
		x= x+(int) ((double)Velocidad*Math.cos(((double)dir/360)*2*Math.PI));
	}
	public void setToNextY(){
		y= y+(int) ((double)Velocidad*Math.sin(((double)dir/360)*2*Math.PI));
	}
	public void setDir(int dirVal){
		dir=dirVal;
	}

	public BufferedImage getImg(){
		if(estado==0){
				return Box[spe];
		}else{
			if(estado<10){
				return BoxLite[spe];
			}else{
				return BoxMicro[spe];
			}
		}
	}
	
	public void addToTrash(){
		switch(spe){
			case 0:
				dAzules++;
				break;
			case 1:
				dBlancas++;
				break;
			case 2:
				dRojas++;
				break;
			case 3:
				dNaranjas++;
				break;
			case 4:
				dVerdes++;
				break;
			case 5:
				dVioletas++;
				break;
			case 6:
				dCelestes++;
				break;
			case 7:
				dPlateadas++;
				break;
			case 8:
				dDoradas++;
				break;
		}
		Cant--;
		DCant++;
	}

	public boolean colision(Shot disp){
		if (((disp.getX()+7)>x) && ((disp.getY()+7)>y) && ((x+43)>disp.getX()) && ((y+43)>disp.getY())){
			addToTrash();
			estado=1;
			return(true);
		}
			return(false);
	}

	public int estado(){
		return estado;
	}
	public void setEst(int est){
		estado=est;
	}
	public static void loadImages(){
		int x;
		Imagen I=new Imagen();
		for(x=0;x<Box.length;x++){
			Box[x]=I.loadImg("Box"+String.valueOf(x+1)+".GIF");
			BoxLite[x]=I.loadImg("Box"+String.valueOf(x+1)+"Lite.GIF");
			BoxMicro[x]=I.loadImg("Box"+String.valueOf(x+1)+"Micro.GIF");
		}
	}
	public static int getDAzules(){
		return  dAzules;
	}
	public static int getDBlancas(){
		return dBlancas;
	}
	public static int getDRojas(){
		return dRojas;
	}
	public static int getDNaranjas(){
		return dNaranjas;
	}
	public static int getDVerdes(){
		return dVerdes;
	}
	public static int getDVioletas(){
		return dVioletas;
	}
	public static int getDCelestes(){
		return dCelestes;
	}
	public static int getDPlateadas(){
		return dPlateadas;
	}
	public static int getDDoradas(){
		return dDoradas;
	}
	public static int getCant(){
		return Cant;
	}
	public static int getDCant(){
		return DCant;
	}
	public static void reboot(){
		Cant=DCant=dAzules=dBlancas=dRojas=dVerdes=dNaranjas=dVioletas=dCelestes=dPlateadas=dDoradas=0;
	}
}
