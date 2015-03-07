package Box;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import Generic.Lista;
import Generic.Shot;

public class boxCSuperPulso extends boxContainer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x0;
	private double y0;
	private double rFinal;
	private double rAct;
	private double angle;
	private double apertura;
	private int velocidad;
	private int length;
	private int wait;
	private Lista cajas;

	public boxCSuperPulso(int x0Val,int y0Val,int angVal,int aperVal,int rFVal,int velVal,int waitVal){
		cajas=new Lista();
		x0=x0Val;
		y0=y0Val;
		rAct=0;
		rFinal=rFVal;
		angle=Math.toRadians(angVal);
		velocidad=velVal;
		length=1;
		wait=waitVal;
		apertura=Math.toRadians(aperVal);
	}

	@Override
	public void addBox(Caja box) {
		box.setY(y0);
		box.setX(x0);
		box.setDir(length);
		box.setVel(velocidad);
		length++;
		cajas.add(box);
	}

	@Override
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

	@Override
	public int[] update(Shot disps[]) {
		int pos=1;
		int pos2;
		Caja boxAct=(Caja)cajas.getData(pos);
		double angle=0;
		int puntaje[]=new int[disps.length];
		rAct+=boxAct.getVel();
		if(rAct>=rFinal){
			rAct=0;
		}
		while(boxAct!=null){
			if(boxAct.estado()==0){
				for(pos2=0;pos2<disps.length;pos2++){
					if(disps[pos2]!=null)
						if(boxAct.colision(disps[pos2],true))
							puntaje[pos2]+=boxAct.getPoints();
				}

				if(rAct!=0){
					angle=(boxAct.getDir()/length)*apertura+this.angle;
					boxAct.setY(y0+rAct*Math.sin(angle));
					boxAct.setX(x0+rAct*Math.cos(angle));
				}else{
					boxAct.setX(x0);
					boxAct.setY(y0);
				}

			}else{
				if(boxAct.estado()<wait){
					boxAct.setEst(boxAct.estado()+1);
				}else{
					if(rAct==0){
						boxAct.setY(y0);
						boxAct.setX(x0);
						boxAct.setEst(0);
					}
				}
			}
			pos++;
			boxAct=(Caja)cajas.getNext();
		}
		return(puntaje);
	}
}
