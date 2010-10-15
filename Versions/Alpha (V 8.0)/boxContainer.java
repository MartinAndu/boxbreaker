import java.awt.Graphics;

public abstract class boxContainer{
	public abstract void update(Shot disparo);
	public abstract void draw(Graphics g);
	public abstract void addBox(Caja box);
}