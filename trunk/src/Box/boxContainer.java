package Box;

import java.awt.Graphics;
import java.io.Serializable;

import Generic.Shot;

public abstract class boxContainer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract int[] update(Shot disps[]);
	public abstract void draw(Graphics g);
	public abstract void addBox(Caja box);
}