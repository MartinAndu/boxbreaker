import java.awt.image.BufferedImage;


public class Caja {
	private double x;
	private double y;
	private int dir;
	private int Puntaje;
	private float Velocidad;
	private int spe;
	private static BufferedImage Box1=new Imagen().loadImg("Box1.GIF");
	private static BufferedImage Box2=new Imagen().loadImg("Box2.GIF");
	private static BufferedImage Box3=new Imagen().loadImg("Box3.GIF");
	private static BufferedImage Box4=new Imagen().loadImg("Box4.GIF");
	private static BufferedImage Box5=new Imagen().loadImg("Box5.GIF");
	private static BufferedImage Box6=new Imagen().loadImg("Box6.GIF");
		
	public Caja(int a, int b){
		x=(int)(Math.random()*750);
		y=(int)(Math.random()*530);
		Puntaje=a;
		dir=(int)(Math.random()*360);
		Velocidad=1+(int)(Math.random()* 19);
		spe=b;
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
		switch(spe){
			case 0:
				return(Box1);
			
			case 1:
				return(Box2);
			
			case 2:
				return(Box3);
				
			case 3:
				return(Box4);
				
			case 4:
				return(Box5);
				
			case 5:
				return(Box6);
			
			default:
				return(null);	
		}
	}
}
