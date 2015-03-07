package Box;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import Generic.Lista;
import Generic.Shot;

public class boxCSuperResorte extends boxContainer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x0;
	private double y0;
	private double angle;
	private int limIzq;
	private int limDer;
	private int limSup;
	private int limInf;
	private int wait;
	private Lista cajas;

	public boxCSuperResorte(int x0Val,int y0Val,int angVal,int waitVal){
		x0=x0Val;
		y0=y0Val;
		angle=Math.toRadians(angVal);
		cajas=new Lista();
		this.setLimSup(0);
		this.setLimInf(768);
		this.setLimIzq(0);
		this.setLimDer(1024);
		wait=waitVal;
	}
	public boxCSuperResorte(int x0Val,int y0Val,int angVal,int limSup,int limInf,int limIzq,int limDer,int waitVal){
		x0=x0Val;
		y0=y0Val;
		angle=Math.toRadians(angVal);
		cajas=new Lista();
		this.setLimSup(limSup);
		this.setLimInf(limInf);
		this.setLimIzq(limIzq);
		this.setLimDer(limDer);
		wait=waitVal;
	}
	public void addBox(Caja box) {
		box.setY(y0);
		box.setX(x0);
		box.setDir(angle);
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
		int puntaje[]=new int[disps.length];
		Caja boxAct=(Caja)cajas.getData(pos);

		while(boxAct!=null){
			if(boxAct.estado()==0){
				for(pos2=0;pos2<disps.length;pos2++){
					if(disps[pos2]!=null)
						if(boxAct.colision(disps[pos2],true))
							puntaje[pos2]+=boxAct.getPoints();
				}
				boxAct.setX(boxAct.getX()+boxAct.getVel()*Math.cos(boxAct.getDir()));
				boxAct.setY(boxAct.getY()+((boxAct.getVel())*Math.sin(boxAct.getDir())));

				if(boxAct.getX()+43>=1024 || boxAct.getX()<=0){
					boxAct.setDir(Math.PI-boxAct.getDir());
				}

				if(boxAct.getY()+43>=768 || boxAct.getY()<=0){
					boxAct.setDir(Math.PI*2-boxAct.getDir());
				}

			}else{
				if(boxAct.estado()<wait){
					boxAct.setEst(boxAct.estado()+1);
				}else{
					boxAct.setEst(0);
					boxAct.setSpe(Caja.getColor());
					boxAct.setX(x0);
					boxAct.setY(y0);
				}
			}
			pos++;
			boxAct=(Caja)cajas.getNext();
		}
		return(puntaje);
	}
	public int getLimIzq() {
		return limIzq;
	}
	public void setLimIzq(int limIzq) {
		this.limIzq = limIzq;
	}
	public int getLimDer() {
		return limDer;
	}
	public void setLimDer(int limDer) {
		this.limDer = limDer;
	}
	public int getLimSup() {
		return limSup;
	}
	public void setLimSup(int limSup) {
		this.limSup = limSup;
	}
	public int getLimInf() {
		return limInf;
	}
	public void setLimInf(int limInf) {
		this.limInf = limInf;
	}
}
