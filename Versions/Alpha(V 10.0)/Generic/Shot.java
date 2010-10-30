package Generic;
public class Shot{
	private int r;
	private double angulo;
	private int tipo;
	public Shot(int rVal,int angVal,int stVal){
		r=rVal;
		angulo=Math.toRadians(angVal);
		tipo=stVal;
	}
	
	public void setR(int rVal){
		r=rVal;
	}
	
	public void setAngle(int angVal){
		angulo=angVal;
	}
	
	public int getR(){
		return r;
	}
	
	public double getAngle(){
		return angulo;
	}
	
	public int getX(){
		return 400+(int)(r*Math.cos(angulo));
	}
	
	public int getY(){
		return 315+(int)(r*Math.sin(angulo));
	}	
}
