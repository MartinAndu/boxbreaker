package Generic;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Imagen {
	public Imagen(){
		
	}
	
	public  BufferedImage  loadImg(String path){
		 BufferedImage I=null;
		 try{
			  I= ImageIO.read(getClass().getClassLoader().getResource(path));
		 }catch(Exception e){
			 e.printStackTrace();	 
		 }
		 return I;
	}	
}
