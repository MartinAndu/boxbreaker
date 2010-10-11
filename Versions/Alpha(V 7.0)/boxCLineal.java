import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class boxCLineal extends boxContainer{
	private double x0;
	private double y0;
	private double r;
	private double angle;
	private Lista cajas;
	
	 /** El<code> constructor</code>  recibe:
	  * <ul><li> x0Val(Valor x del punto de inicio del camino de cajas.)
	  * <li> y0Val(Valor y del punto de inicio del camino de cajas.)
	  * <li> x1Val(Valor x del punto de final del camino de cajas.)
	  * <li> y1Val(Valor y del punto de final del camino de cajas.)
	  */
	public boxCLineal(int x0Val,int y0Val,int x1Val,int y1Val){
		cajas=new Lista();
		x0=x0Val;
		y0=y0Val;
		r=stepDist(x0Val,y0Val,x1Val,y1Val);
		
		if(y1Val>=y0Val){
			angle=Math.acos((x1Val-x0Val)/r);
		}else{
			angle=Math.acos((x1Val-x0Val)/r)+(Math.PI-Math.acos((x1Val-x0Val)/r))*2;
		}
	}
	
	public void addBox(Caja box){
		box.setX(x0);
		box.setY(y0);
		cajas.add(box);
	}
	public void draw(Graphics g){
		int pos=1;
		Caja boxAct=new Caja(0,0);
		
		while(cajas.getData(pos)!=null){
			boxAct=(Caja)cajas.getData(pos);
			
			boxAct.setX(boxAct.getX()+boxAct.getVel()*Math.cos(angle));
			boxAct.setY(boxAct.getY()+((boxAct.getVel())*Math.sin(angle)));
			if(stepDist(x0,y0,boxAct.getX(),boxAct.getY())<=r){
				g.drawImage(boxAct.getImg(),(int)boxAct.getX(),(int)boxAct.getY(),null);
			}
			if(stepDist(x0,y0,boxAct.getX(),boxAct.getY())>=(r+boxAct.getVel())){
				boxAct.setX(x0);
				boxAct.setY(y0);
			}
			pos++;
		}
	}
	
	private double stepDist(double xs0,double ys0,double xs1,double ys1){
		return Math.sqrt(Math.pow((xs1-xs0),2)+Math.pow((ys1-ys0),2));
	}
	
}
	
