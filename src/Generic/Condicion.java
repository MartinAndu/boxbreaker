package
Generic; 
import
Box.Caja; 
public class Condicion implements Runnable { 
//private int Cants[]; 
private int cantTotal; 
private int tiempoLimite; 
private int tipoCaja;
private String nombre;
//private int tipo; 
private FrameGame game; 
private boolean completo;
	public Condicion (int t, FrameGame g,int cant){ 
		game=g; 
		tiempoLimite=t; 
		completo=false;
		tipoCaja=(int)(Math.random()*9-1);
		nombre=Caja.getName(tipoCaja);
		switch(t){ 
			case 1: 
				tiempoLimite=(int)(Math.random()*20)+10; 
				cantTotal=(int)(Caja.getChance(tipoCaja)*cant*(tiempoLimite/11)); 
				break; 
			case 2: 
				tiempoLimite=(int)(Math.random()*20)+20; 
				cantTotal=(int)(Caja.getChance(tipoCaja)*cant*(tiempoLimite/11)); 
				break;
			case 3: 
				tiempoLimite=(int)(Math.random()*20)+30; 
				cantTotal=(int)(Caja.getChance(tipoCaja)*cant*(tiempoLimite/11)); 
				break; 
			default: 
				break; 
		}
	}
	public void run() { 
		// TODO Auto-generated method stub 
		String cond=new String("Mision: Romper "+cantTotal+" Cajas "+nombre);
		game.setCond(cond);
		game.setCondBox(tipoCaja);
		while(game.getEstado()!=-1){ 
			game.setGameTime(tiempoLimite); 
				if (Caja.getType(tipoCaja)>=cantTotal){ 
					game.setVictory(2); 
					game.stop();
					completo=true;
				}else{ 
					if (tiempoLimite==0){ 
						game.setVictory(1); 
						game.stop();
						completo=true;
					}else{ 
						if(game.getEstado()==0)
							tiempoLimite--; 
					}
				}
				try{ 
					Thread.sleep(1000);
				}catch(Exception e){ 
					e.printStackTrace();
				}
		}
		if(!completo)
			game.stop();
	}
}