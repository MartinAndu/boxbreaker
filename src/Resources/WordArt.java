package Resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class WordArt{
	private String text;
	private BufferedImage image;
	private int y;
	
	public WordArt(int word,String text){
		image=Imagen.loadImg("Images\\WordArt\\"+Integer.toString(word)+".GIF");
		this.text=text;
		y=300;
	}
	
	public void draw(Graphics g){
		g.drawImage(image,400,y,null);
		g.setFont(new Font(null,0,80));
		g.setColor(Color.BLACK);
		g.drawString(text,image.getWidth()+20+400,y+60);
		y+=10;
	}
	
	public int getY(){
		return y;
	}
}
