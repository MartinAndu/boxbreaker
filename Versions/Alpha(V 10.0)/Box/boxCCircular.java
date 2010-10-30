package Box;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Generic.Lista;
import Generic.Shot;


public class boxCCircular extends boxContainer{
	private double x0;
	private double y0;
	private double start;
	private double end;
	private double r;
	private Lista cajas;

	 /** El<code> constructor</code>  recibe:
	  * <ul><li> x0Val(posición en el eje x del centro de la circunferencia.)
	  * <li> y0Val(posición en el eje y del centro de la circunferencia.)
	  * <li> startVal(Inicio del arco-Por ahora sin utilidad.)
	  * <li> endVal(Final del arco-Por ahora sin utilidad.)
	  * <li> rVal(Longitud del radio.)
	  */
	public boxCCircular(int x0Val,int y0Val,int startVal,int endVal,int rVal){
		cajas=new Lista();
		x0=x0Val;
		y0=y0Val;
		start=toRadians(startVal);
		end=toRadians(endVal);
		r=rVal;
	}
	 /** Permite<code> agregar cajas</code>al contenedor
	  */
	public void addBox(Caja box) {
		box.setX(x0+r);
		box.setY(y0);
		cajas.add(box);
	}
	 /** Dibuja<code> el contenedor</code> y realiza todos los movimientos de las cajas:
	  */
	public void draw(Graphics g) {
		int pos=1;
		Caja boxAct;

		while(cajas.getData(pos)!=null){
			boxAct=(Caja)cajas.getData(pos);
			if(boxAct.estado()<15){
				if (boxAct.estado()>0){
					g.setColor(Color.BLUE);
					g.drawString(Integer.toString(boxAct.getPoints()),(int)boxAct.getX(),(int)boxAct.getY()-20-boxAct.estado());
				}
				g.drawImage(boxAct.getImg(),(int)boxAct.getX(),(int)boxAct.getY(),null);
			}
			pos++;
		}
	}

	public int update(Shot disparo){
		int pos=1;
		Caja boxAct;
		int puntaje=0;
		while(cajas.getData(pos)!=null){
			boxAct=(Caja)cajas.getData(pos);
			if(boxAct.estado()==0){
				if(disparo!=null)
					if(boxAct.colision(disparo))
						puntaje+=boxAct.getPoints();

				boxAct.setY(y0+r*Math.sin(2*Math.PI*((boxAct.getVel()+(getAngle(boxAct.getX(),boxAct.getY())/(Math.PI*2)*getDiam()))/getDiam())));
				boxAct.setX(x0+r*Math.cos(2*Math.PI*((boxAct.getVel()+(getAngle(boxAct.getX(),boxAct.getY())/(Math.PI*2)*getDiam()))/getDiam())));
			}else{
				if(boxAct.estado()<15){
					boxAct.setEst(boxAct.estado()+1);
				}else{
					cajas.delete(pos);
				}
			}
			pos++;
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
