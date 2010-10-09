import java.awt.image.BufferedImage;


public class Caja {
	private double x;
	private double y;
	private int dir;
	private int Puntaje;
	private float Velocidad;
	private int spe;
	public BufferedImage img;
	
	public Caja(int a,int b){
		x=(int)(Math.random()*750);
		y=(int)(Math.random()*530);
		Puntaje=a;
		dir=(int)(Math.random()*360);
		Velocidad=1+(int)(Math.random()* 19);
		spe=b;
	}
	public Caja(int a, int b,Imagen I){
		x=(int)(Math.random()*750);
		y=(int)(Math.random()*530);
		Puntaje=a;
		dir=(int)(Math.random()*360);
		Velocidad=1+(int)(Math.random()* 19);
		spe=b;
		img=I.loadImg(getImgPath());
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
		return img;
	}
	private String getImgPath(){
		switch(spe){
			case 0:
				return("Box1.GIF");
			
			case 1:
				return("Box2.GIF");
			
			case 2:
				return("Box3.GIF");
				
			case 3:
				return("Box4.GIF");
				
			case 4:
				return("Box5.GIF");
				
			case 5:
				return("Box6.GIF");
			
			default:
				return(null);	
		}
	}
}
