
public class Shot{
	private int r;
	private int angulo;
	
	public Shot(){
		
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
	
	public int getAngle(){
		return angulo;
	}
	
	public int getX(){
		return (int) ((double)r*Math.cos(toRadians()));
	}
	
	public int getY(){
		return (int) ((double)r*Math.sin(toRadians()));
	}
	
	private double toRadians(){
		return (((double)angulo/360)*2*Math.PI);
	}
}
