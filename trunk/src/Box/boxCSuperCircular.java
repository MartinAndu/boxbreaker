package Box;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import Generic.Lista;
import Generic.Shot;

public class boxCSuperCircular extends boxContainer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x0;
	private double y0;
	private double start;
	private double end;
	private double r;
	private int wait;
	private int largo;
	private int defaultSep=-1;
	private int defaultVel;
	private Lista cajas;


	 /** El<code> constructor</code>  recibe:
	  * <ul><li> x0Val(posición en el eje x del centro de la circunferencia.)
	  * <li> y0Val(posición en el eje y del centro de la circunferencia.)
	  * <li> startVal(Inicio del arco-Por ahora sin utilidad.)
	  * <li> endVal(Final del arco-Por ahora sin utilidad.)
	  * <li> rVal(Longitud del radio.)
	  */
	public boxCSuperCircular(int x0Val,int y0Val,int startVal,int endVal,int rVal,int waitVal){
		cajas=new Lista();
		x0=x0Val;
		y0=y0Val;
		start=toRadians(startVal);
		end=toRadians(endVal);
		r=rVal;
		wait=waitVal;
	}

	public boxCSuperCircular(int x0Val,int y0Val,int startVal,int endVal,int rVal,int defSep,int defVel,int waitVal){
		cajas=new Lista();
		x0=x0Val;
		y0=y0Val;
		start=toRadians(startVal);
		end=toRadians(endVal);
		r=rVal;
		defaultSep=defSep;
		defaultVel=defVel;
		wait=waitVal;
	}
	 /** Permite<code> agregar cajas</code>al contenedor
	  */
	public void addBox(Caja box) {
		if(defaultSep==-1){
			box.setY(y0+r*Math.sin(start));
			box.setX(x0+r*Math.cos(start));
		}else{
			box.setY(y0+r*Math.sin((largo/(Math.PI*2*r))*Math.PI*2));
			box.setX(x0+r*Math.cos((largo/(Math.PI*2*r))*Math.PI*2));
			largo+=defaultSep;
			box.setVel(defaultVel);
		}
		cajas.add(box);
	}
	 /** Dibuja<code> el contenedor</code> y realiza todos los movimientos de las cajas:
	  */
	public void draw(Graphics g) {
		int pos=1;
		Caja boxAct=(Caja)cajas.getData(pos);

		while(boxAct!=null){
			if(boxAct.estado()<15){
				if (boxAct.estado()>0){
					g.setColor(Color.BLUE);
					g.drawString(Integer.toString(boxAct.getPoints()),(int)boxAct.getX(),(int)boxAct.getY()-20-boxAct.estado());
				}
				g.drawImage(boxAct.getImg(),(int)boxAct.getX(),(int)boxAct.getY(),null);
				if (boxAct.getE()>0){
					g.drawImage(Caja.getEffectImg(),(int)boxAct.getX()+10,(int)boxAct.getY()+10,null);
				}
			}
			pos++;
			boxAct=(Caja)cajas.getNext();
		}
	}

	public int[] update(Shot disps[]){
		int pos=1;
		int pos2;
		Caja boxAct=(Caja)cajas.getData(pos);
		double angle=0;
		int puntaje[]=new int[disps.length];
		while(boxAct!=null){
			if(boxAct.estado()==0){
				for(pos2=0;pos2<disps.length;pos2++){
					if(disps[pos2]!=null)
						if(boxAct.colision(disps[pos2],true))
							puntaje[pos2]+=boxAct.getPoints();
				}
				angle=2*Math.PI*((boxAct.getVel()+(getAngle(boxAct.getX(),boxAct.getY())/(Math.PI*2)*getDiam()))/getDiam());
				boxAct.setY(y0+r*Math.sin(angle));
				boxAct.setX(x0+r*Math.cos(angle));

				if(angle>=end){
					boxAct.setY(y0+r*Math.sin(start));
					boxAct.setX(x0+r*Math.cos(start));
				}
			}else{
				if(boxAct.estado()<wait){
					boxAct.setEst(boxAct.estado()+1);
				}else{
					boxAct.setEst(0);
					boxAct.setSpe(Caja.getColor());
					boxAct.setX(x0+r);
					boxAct.setY(y0);
				}
			}
			pos++;
			boxAct=(Caja)cajas.getNext();
		}
		return(puntaje);
	}

	private double toRadians(double angulo){
		return ((angulo/360)*2*Math.PI);
	}

	private double getAngle(double x,double y){
		if(y>=y0){
			return Math.acos((x-x0)/r);
		}else{
			return Math.acos((x-x0)/r)+(Math.PI-Math.acos((x-x0)/r))*2;
		}
	}

	private double getDiam(){
		return (Math.PI*r*2);
	}
}
