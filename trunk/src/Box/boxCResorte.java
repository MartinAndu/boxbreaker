package Box;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import Generic.Lista;
import Generic.Shot;

public class boxCResorte extends boxContainer implements Serializable{
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
	private Lista cajas;

	public boxCResorte(int x0Val,int y0Val,int angVal){
		x0=x0Val;
		y0=y0Val;
		angle=Math.toRadians(angVal);
		cajas=new Lista();
		this.limSup=0;
		this.limInf=768;
		this.limIzq=0;
		this.limDer=1024;
	}

	public boxCResorte(int x0Val,int y0Val,int angVal,int limSup,int limInf,int limIzq,int limDer){
		x0=x0Val;
		y0=y0Val;
		angle=Math.toRadians(angVal);
		cajas=new Lista();
		this.limSup=limSup;
		this.limInf=limInf;
		this.limIzq=limIzq;
		this.limDer=limDer;
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

				if(boxAct.getX()+43>=limDer || boxAct.getX()<=limIzq){
					boxAct.setDir(Math.PI-boxAct.getDir());
				}

				if(boxAct.getY()+43>=limInf || boxAct.getY()<=limSup){
					boxAct.setDir(Math.PI*2-boxAct.getDir());
				}

			}else{
				if(boxAct.estado()<15){
					boxAct.setEst(boxAct.estado()+1);
				}else{
					cajas.delete(pos);
					pos--;
				}
			}
			pos++;
			boxAct=(Caja)cajas.getNext();
		}
		return(puntaje);
	}
}
