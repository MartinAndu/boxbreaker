package Generic;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class MenuText extends Menu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int v[];
	
	public MenuText(){
		super();
		v=null;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font(null,0,18));
		
		if(v!=null){
			int pos=0;
			g.drawString(getTitle(0)+Integer.toString(v[0]),10,70);
		
			for(pos=13;pos<v.length;pos++){
				if(v[pos]!=-1){
					if(pos<15){
						g.drawString(getTitle(pos)+Integer.toString(v[pos]),180+(pos-13)*170,70);
					}else{
						g.drawString(getTitle(pos)+Integer.toString(v[pos]),180+(pos-15)*170,90);
					}
				}	
			}
			
			for(pos=1;pos<11;pos++){
				if(pos<10){
					g.setColor(getColor(pos-1));
					g.fillRect(200+pos*20,(int)(270-150*getScale(v[pos])),20,(int)(150*getScale(v[pos])));
					g.setColor(Color.black);
					g.drawRect(200+pos*20,(int)(270-150*getScale(v[pos])),20,(int)(150*getScale(v[pos])));
				}
				g.drawString(getTitle(pos)+Integer.toString(v[pos]),10,90+pos*18);
			}
			
			g.setFont(new Font(null,0,40));
			g.setColor(Color.RED);
			g.drawString(getTitle(12),140,90);
		}
	}
	
	public void setIntVector(int vec[]){
		v=vec;
	}
	
	private Color getColor(int pos){
		switch(pos){
		case 0:
			return Color.blue;
		case 1:
			return Color.white;
		case 2:
			return Color.red;
		case 3:
			return Color.orange;
		case 4:
			return Color.green;
		case 5:
			return Color.magenta;
		case 6:
			return Color.cyan;
		case 7:
			return Color.lightGray;
		case 8:
			return Color.yellow;
		default:
			return null;
		}
	}
	
	private String getTitle(int pos){
		switch(pos){
		case 0:
			return "Tiempo: ";
		case 1:
			return "Azules *";
		case 2:
			return "Blancas *";
		case 3:
			return "Rojas *" ;
		case 4:
			return "Naranjas *";
		case 5:
			return "Verdes *";
		case 6:
			return "Violetas *";
		case 7:
			return "Celestes *";
		case 8:
			return "Plateadas *";
		case 9:
			return "Doradas *";
		case 10:
			return "Puntaje Total: ";
		case 11:
			return "Cajas Destruidas: ";
		case 12:
			switch(v[12]){
			case 0:
				return "Mision Icompleta";
			case 1:
				return "Mision Completa";
			default:
				return "";
			}
		case 13:
			return "Jugador 1: ";
		case 14:
			return "Jugador 2: ";
		case 15:
			return "Jugador 3: ";
		case 16:
			return "Jugador 4: "; 
		default:
			return null;
		}
	}
	
	private double getScale(int num){
		return ((double)num/(double)v[11]);
	}
}
