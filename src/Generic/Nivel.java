package Generic;

import Box.*;


public class Nivel {
	public static final int arcade=0;
	public static final int normal=1;
	public static final int bonus=2;
	
	private  boxContainer cont[];
	private int escenario=-1;
	private int time;
	private int boxCant;
	private int codigo;
	private int cantMision;
	private int boxMision;
	private int Bonus;
	private boolean mision;
	
	public Nivel(boxContainer[] c,int sce,int t,int bc,int code){
		cont=c;
		escenario=sce;
		time=t;
		boxCant=bc;
		setMision(false);
		Bonus=time+1;
		codigo=code;
	}
	
	public Nivel(boxContainer[] c,int sce,int t,int bc,int bonusVal,int code){
		cont=c;
		escenario=sce;
		time=t;
		boxCant=bc;
		setMision(false);
		Bonus=bonusVal;
		codigo=code;
	}
	public Nivel(boxContainer[] c,int sce,int t,int bc,int code,int bm,int cm){
		cont=c;
		escenario=sce;
		time=t;
		boxCant=bc;
		cantMision=cm;
		boxMision=bm;
		setMision(true);
		codigo=code;
	}
	
	public boxContainer[] getContainer(){
		return cont;
	}
	
	public int getEscenario(){
		return escenario;
	}
	
	public void setEscenario(int sce){
		escenario=sce;
	}
	
	public int getTime(){
		return time;
	}
	
	public int getBoxCant(){
		return boxCant;
	}
	
	public int getBoxMision(){
		return boxMision;
	}
	
	public int getCantMision(){
		return cantMision;
	}
	
	public int getBonus(){
		return Bonus;
	}
	
	public int getCode(){
		return codigo;
	}
	
	public static Nivel getLevel(int tipo,int nivel){
		boxContainer c[];
		
		switch(tipo){
		case arcade:
			switch(nivel){
			case 0 :
				c=new boxContainer[2];
				c[0]=new boxCLineal(0,200,1024,200);
				c[1]=new boxCLineal(0,600,1024,600);
				return (new Nivel(c,0,60,10,15,nivel));
			case 1:
				c=new boxContainer[2];
				c[0]=new boxCLineal(200,0,200,768);
				c[1]=new boxCLineal(824,0,824,768);
				return (new Nivel(c,0,50,10,10,nivel));
			case 2:
				c=new boxContainer[2];
				c[0]=new boxCResorte(0,200,45);
				c[1]=new boxCResorte(970,200,135);
				return (new Nivel(c,4,50,10,10,nivel));
			case 3:
				c=new boxContainer[2];
				c[0]=new boxCResorte(0,0,60);
				c[1]=new boxCCircular(494,373,0,360,400);
				return (new Nivel(c,4,50,10,10,nivel));
			case 4:
				c=new boxContainer[3];
				c[0]=new boxCCircular(494,373,0,360,200,60,10);
				c[1]=new boxCCircular(494,373,0,360,300,90,10);
				c[2]=new boxCCircular(494,373,0,360,400,120,10);
				return (new Nivel(c,5,60,20,10,nivel));
			case 5:
				c=new boxContainer[3];
				c[0]=new boxCPulso(500,200,45,90,1000,10);
				c[1]=new boxCPulso(10,200,0,90,1000,10);
				c[2]=new boxCPulso(1014,200,90,90,1000,10);
				return  (new Nivel(c,5,80,20,10,nivel));
			case 6:
				c=new boxContainer[3];
				c[0]=new boxCLineal(0,0,1024,768);
				c[1]=new boxCResorte(0,550,60,550,768,0,1024);
				c[2]=new boxCLineal(0,768,1024,0);
				return  (new Nivel(c,6,70,20,10,nivel));
			}
			
		case normal:
			switch(nivel){
			case 0:
				c=new boxContainer[4];
				c[0]=new boxCSuperLineal(950,768,600,10,200);
				c[1]=new boxCSuperLineal(400,10,0,650,200);
				c[2]=new boxCSuperCircular(494,373,0,360,200,200);
				c[3]=new boxCSuperResorte(50,600,45,200);
				return (new Nivel(c,-1,100,10,-nivel-1));
			case 1:
				c=new boxContainer[5];
				c[0]=new boxCSuperCircular(160,150,0,360,150,88,10,200);
				c[1]=new boxCSuperCircular(820,150,0,360,150,88,10,200);
				c[2]=new boxCSuperCircular(160,550,0,360,150,88,10,200);
				c[3]=new boxCSuperCircular(820,550,0,360,150,88,10,200);
				c[4]=new boxCSuperCircular(494,373,0,360,150,88,10,200);
				return (new Nivel(c,-1,50,10,-nivel-1));
			case 2:
				c=new boxContainer[3];
				c[0]=new boxCSuperPulso(500,200,45,90,1000,10,200);
				c[1]=new boxCSuperPulso(10,200,0,90,1000,10,200);
				c[2]=new boxCSuperPulso(1014,200,90,90,1000,10,200);
				return (new Nivel(c,-1,50,20,-nivel-1));
			}
			
		case bonus:
			switch(nivel){
			case 0:
				c=new boxContainer[2];
				c[0]=new boxCResorte(0,0,45,0,768,0,200);
				c[1]=new boxCResorte(800,0,45,0,768,800,1024);
				return (new Nivel(c,3,0,5,nivel+10000));
			}
		default:
			return null;
		}
	}
	
	public static void load(boxContainer[] cont,int cant){
		int i;
		int y;
		switch(cant){
		case 0:
			break;
		default:
			for(i=0;i<=cant;i++){
				for (y=0;y<cont.length;y++){
					cont[y].addBox(new Caja(0));
				}
			}
			break;
		}
	}
	
	public static void load(boxContainer[] cont,int cant,int defType){
		int i;
		int y;
		switch(cant){
		case 0:
			break;
		default:
			for(i=0;i<=cant;i++){
				for (y=0;y<cont.length;y++){
					cont[y].addBox(new Caja(0,defType));
				}
			}
			break;
		}
	}

	public boolean isMision() {
		return mision;
	}

	public void setMision(boolean mision) {
		this.mision = mision;
	}
}
