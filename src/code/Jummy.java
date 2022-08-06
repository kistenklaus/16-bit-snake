package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Jummy {
	private int posX,posY;
	private Rectangle bounding;
	private Color color;
	
	public Jummy(Color color){
		Random ran = new Random();
		posX=Main.TILEDIMENSIONS*Math.round(ran.nextInt(Main.WIDTH)/Main.TILEDIMENSIONS);
		posY=Main.TILEDIMENSIONS*Math.round(ran.nextInt(Main.HEIGHT)/Main.TILEDIMENSIONS);

		this.color=color;
		
		bounding= new Rectangle(posX,posY,Main.TILEDIMENSIONS,Main.TILEDIMENSIONS);
	}
	
	public void eaten(){
		Random ran = new Random();
		posX=Main.TILEDIMENSIONS*Math.round(ran.nextInt(Main.WIDTH)/Main.TILEDIMENSIONS);
		posY=Main.TILEDIMENSIONS*Math.round(ran.nextInt(Main.HEIGHT)/Main.TILEDIMENSIONS);
		
		bounding= new Rectangle(posX,posY,Main.TILEDIMENSIONS,Main.TILEDIMENSIONS);
	}
	
	public static void draw(Graphics g)
	{
		for(int i=0;i<Main.jummys.size();i++)
		{
			g.setColor(Main.jummys.get(i).getColor());
			g.fillOval(Main.jummys.get(i).getX(), Main.jummys.get(i).getY(), Main.TILEDIMENSIONS, Main.TILEDIMENSIONS);
		}
	}
	
	public Rectangle getBounding(){return bounding;	}
	public Color getColor(){return color;	}
	public int getX(){return posX;	}
	public int getY(){return posY;	}
	

}
