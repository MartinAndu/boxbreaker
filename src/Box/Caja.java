package Box;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import Generic.Power;
import Generic.Shot;
import Resources.Imagen;
import Resources.Pista;


public class Caja implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x;
	private double y;
	private double dir;
	private int Puntaje;
	private float Velocidad;
	private int spe;
	private int estado=0;
	/*private static BufferedImage Box[]=new BufferedImage[9];
	private static BufferedImage BoxLite[]=new BufferedImage[9];
	private static BufferedImage BoxMicro[]=new BufferedImage[9];
	private static BufferedImage BoxFantasma[]=new BufferedImage[9];*/
	private static Pista endSound;
	private static BufferedImage hayEfecto=Imagen.loadImg("Images/Boxes/hayEfectos.GIF");

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

	//variables para efectos
        private int efecto;
        private static boolean fantasma=false;
        private static int VelocidadExtra=0;
        private static double multiplo=1;


        public Caja(int a){
    		x=(int)(Math.random()*750);
    		y=(int)(Math.random()*750);
    		dir=(int)(Math.random()*360);
    		Velocidad=1+(int)(Math.random()* 19);
    		spe=getColor();
    	    efecto=getEfecto();
    		Puntaje=calcularPuntaje();
    		Cant++;
    	}
    	public Caja(int a, int b){
    		x=(int)(Math.random()*750);
    		y=(int)(Math.random()*750);
    		dir=(int)(Math.random()*360);
    		Velocidad=1+(int)(Math.random()* 19);
    		spe=b;
    		efecto=getEfecto();
    		Puntaje=calcularPuntaje();
    		Cant++;
    	}
    	public int getE(){
    		return (efecto);
    	}
    	public void setVel(int velocidad) {
    		Velocidad = velocidad;
    	}
    	private int getEfecto(){
            	double n=Math.random();
    	        if (n>0.5 && n<0.7)
    	            return ((int)((Math.random()*9)+1));
            	else{
    	            return (0);
            	}
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

    	public static int getColor(){
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
    		return((int)(Puntaje*multiplo));
    	}
            public float getVel(){
              if (VelocidadExtra==-9999)
                return (Velocidad/100);
              if (VelocidadExtra==9999)
            	return (Velocidad/2);

               return(Velocidad+VelocidadExtra);
            }
            public static void setVelocidadExtra(int velocidadExtra) {
               VelocidadExtra = velocidadExtra;
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
    	public double getDir(){
    		return dir;
    	}

    	public static boolean isFantasma() {
    		return fantasma;
    	}
    	public static void setFantasma(boolean fantasma) {
    		Caja.fantasma = fantasma;
    	}
    	public void setToNextX(){
    		x= x+(int) ((double)Velocidad*Math.cos(((double)dir/360)*2*Math.PI));
    	}
    	public void setToNextY(){
    		y= y+(int) ((double)Velocidad*Math.sin(((double)dir/360)*2*Math.PI));
    	}
    	public void setDir(double dirVal){
    		dir=dirVal;
    	}

    	public BufferedImage getImg(){
    		if(estado==0){
    			if (Power.getSegundosEfectoFantasma()>0){
    				if (Power.getSegundosEfectoFantasma()>25)
    					return getBoxFantasma(spe);
    				else
    					return (null);
    			}
    			return  getBox(spe);
    		}else{
    			if(estado<10){
    				return getBoxLite(spe);
    			}else{
    				return getBoxMicro(spe);
    			}
    		}
    	}

    	public void addToTrash(boolean trash){
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
    		if(trash)
    			Cant--;
    		DCant++;
    	}

    	public boolean colision(Shot disp,boolean trash){
    		if (((disp.getX()+disp.getAncho())>x) && ((disp.getY()+disp.getAlto())>y) && ((x+43)>disp.getX()) && ((y+43)>disp.getY())){
    			//Efecto de cajas fantasmas
    			if (fantasma==false){
    				addToTrash(trash);
    				estado=1;
    			    if (efecto>0){
    	              	  Power.startEfecto(efecto,disp.shootedBy());
    	              	  //cambia de efecto
    	              	  efecto=(int)(Math.random()*9)+1;
    			    }
    			    endSound=new Pista("Sounds\\WAV\\blip.wav",1);
    				endSound.play();
    				return(true);
    			}
    		}
    			return(false);
    	}
    	public int getPuntaje() {
    		return Puntaje;
    	}
    	public float getVelocidad() {
    		return Velocidad;
    	}
    	public int getEstado() {
    		return estado;
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage[] getBox() {
    		Imagen I=new Imagen();
    		BufferedImage Box[]=new BufferedImage[9];
    		for (int x=0;x<9;x++){
    			Box[x]=I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+".GIF");
    		}
    		return Box;
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage getBox(int x){
    		Imagen I=new Imagen();
    		return(I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+".GIF"));
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage[] getBoxLite() {
    		Imagen I=new Imagen();
    		BufferedImage Box[]=new BufferedImage[9];
    		for (int x=0;x<9;x++){
    			Box[x]=I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+"Lite.GIF");
    		}
    		return Box;
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage getBoxLite(int x){
    		Imagen I=new Imagen();
    		return(I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+"Lite.GIF"));
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage[] getBoxMicro() {
    		Imagen I=new Imagen();
    		BufferedImage Box[]=new BufferedImage[9];
    		for (int x=0;x<9;x++){
    			Box[x]=I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+"Micro.GIF");
    		}
    		return Box;
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage getBoxMicro(int x){
    		Imagen I=new Imagen();
    		return(I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+"Micro.GIF"));
    	}
    	@SuppressWarnings("static-access")
		public static BufferedImage getBoxFantasma(int x){
    		Imagen I=new Imagen();
    		return(I.loadImg("Images/Boxes/BoxF"+String.valueOf(x+1)+".GIF"));
    	}
    	public static BufferedImage getHayEfecto() {
    		return hayEfecto;
    	}
    	public static int getdAzules() {
    		return dAzules;
    	}
    	public static int getdBlancas() {
    		return dBlancas;
    	}
    	public static int getdRojas() {
    		return dRojas;
    	}
    	public static int getdNaranjas() {
    		return dNaranjas;
    	}
    	public static int getdVerdes() {
    		return dVerdes;
    	}
    	public static int getdVioletas() {
    		return dVioletas;
    	}
    	public static int getdCelestes() {
    		return dCelestes;
    	}
    	public static int getdPlateadas() {
    		return dPlateadas;
    	}
    	public static int getdDoradas() {
    		return dDoradas;
    	}
    	public static int getVelocidadExtra() {
    		return VelocidadExtra;
    	}
    	public int estado(){
    		return estado;
    	}
    	public void setEst(int est){
    		estado=est;
    	}
    	/*public static void loadImages(){
    		int x;
    		Imagen I=new Imagen();
    		for(x=0;x<Box.length;x++){
    			Box[x]=I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+".GIF");
    			BoxLite[x]=I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+"Lite.GIF");
    			BoxMicro[x]=I.loadImg("Images/Boxes/Box"+String.valueOf(x+1)+"Micro.GIF");
    			BoxFantasma[x]=I.loadImg("Images/Boxes/BoxF"+String.valueOf(x+1)+".GIF");
    		}

    	}*/
    	public void setSpe(int color){
    		spe=color;
    		Puntaje=calcularPuntaje();
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
    	public static BufferedImage getEffectImg(){
    		if (fantasma==true)
    			return (null);
    		return hayEfecto;
    	}

    	public static String getName(int color){
    		switch(color){
    		case 0:
    			return "Azules";
    		case 1:
    			return "Blancas";
    		case 2:
    			return "Rojas";
    		case 3:
    			return "Naranjas";
    		case 4:
    			return "Verdes";
    		case 5:
    			return "Violetas";
    		case 6:
    			return "Celestes";
    		case 7:
    			return "Plateadas";
    		case 8:
    			return "Doradas";
    		default:
    			return "";
    		}
    	}

    	public static double getChance(int color){
    		switch(color){
    		case 0:
    			return (0.125);
    		case 1:
    			return (0.125);
    		case 2:
    			return (0.125);
    		case 3:
    			return (0.125);
    		case 4:
    			return (0.25);
    		case 5:
    			return (0.125);
    		case 6:
    			return (0.0625);
    		case 7:
    			return (0.03125);
    		case 8:
    			return (0.015625);
    		default:
    			return 1;
    		}
    	}

    	public static int getType(int color){
    		switch(color){
    		case -1:
    			return Caja.getDCant();
    		case 0:
    			return Caja.getDAzules();
    		case 1:
    			return Caja.getDBlancas();
    		case 2:
    			return Caja.getDRojas();
    		case 3:
    			return Caja.getDNaranjas();
    		case 4:
    			return Caja.getDVerdes();
    		case 5:
    			return Caja.getDVioletas();
    		case 6:
    			return Caja.getDCelestes();
    		case 7:
    			return Caja.getDPlateadas();
    		case 8:
    			return Caja.getDDoradas();
    		default:
    			return 0;
    		}
    	}
    	public static void setMultiplo(double multiplo) {
    		Caja.multiplo = multiplo;
    	}
    }