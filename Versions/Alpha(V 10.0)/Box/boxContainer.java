package Box;

import java.awt.Graphics;
import Generic.Shot;


public abstract class boxContainer{
	public abstract int update(Shot disparo);
	public abstract void draw(Graphics g);
	public abstract void addBox(Caja box);
}