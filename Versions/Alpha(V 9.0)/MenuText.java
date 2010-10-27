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
		g.setFont(new Font(null,0,24));
		
		if(v!=null){
			int pos=0;
			for(pos=0;pos<v.length;pos++){
				g.drawString(v[pos],5,100+pos*50);
			}
		}
	}
	
	public void setStringVector(String vec[]){
		v=vec;
	}
}
