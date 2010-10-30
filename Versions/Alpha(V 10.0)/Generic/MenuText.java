package Generic;
import java.awt.Font;
import java.awt.Graphics;



public class MenuText extends Menu{
	private String v[];
	
	public MenuText(){
		super();
		v=null;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font(null,0,20));
		
		if(v!=null){
			int pos=0;
			g.drawString(v[0],5,90);
			g.drawString(v[1],5,90+20);
			
			for(pos=2;pos<v.length;pos++){
				g.drawString(v[pos],5,110+pos*20);
			}
		}
	}
	
	public void setStringVector(String vec[]){
		v=vec;
	}
}
