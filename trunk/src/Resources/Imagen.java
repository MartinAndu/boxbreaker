package Resources;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagen {
	
	public static BufferedImage loadImg(String path){
		 BufferedImage I=null;
		 
		 try{
			  I=ImageIO.read(new File(path));
		 }catch(IOException e){
			 e.printStackTrace();	 
		 }
		 return I;
	}	
}
