package Box;

import java.awt.Graphics;

import Generic.Lista;

public class boxCPoligon extends boxContainer{
	//TODO
	private double x0;
	private double y0;
	private double r;
	private int lados;
	private double longitud;
	private Lista cajas;
	
	public boxCPoligon(int x0Val,int y0Val,int rVal,int ldsVal){
		x0=x0Val;
		y0=y0Val;
		r=rVal;
		lados=ldsVal;
		longitud=stepDist(r,0,r*Math.cos(((Math.PI*2)/lados)),r*Math.sin(((Math.PI*2)/lados)));
	}
	
	public void addBox(Caja box) {
		box.setX(x0);
		box.setY(y0);
		cajas.add(box);
	}
	
	public void draw(Graphics g) {
		int pos=1;
		Caja boxAct=new Caja(0,0);
		double aux=0;
		while(cajas.getData(pos)!=null){
			boxAct=(Caja)cajas.getData(pos);
			aux=(getPos(boxAct.getX(),boxAct.getY())+boxAct.getVel());
			pos++;
		}
	}
	
	private double stepDist(double xs0,double ys0,double xs1,double ys1){
		return Math.sqrt(Math.pow((xs1-xs0),2)+Math.pow((ys1-ys0),2));
	}
	
	private double getPos(double x,double y){
		return ((getAngle(x,y)/(Math.PI*2))*longitud*lados);
	}
	
	private double getAngle(double x,double y){
		if(y>=y0){
			return Math.acos((x-x0)/r);
		}else{
			return Math.acos((x-x0)/r)+(Math.PI-Math.acos((x-x0)/r))*2;
		}
	}
}
