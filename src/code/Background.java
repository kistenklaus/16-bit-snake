package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Background{
	
	
	private BufferedImage background;
	
	public Background()
	{
		Random ran = new Random();
		background= new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = background.getGraphics();
		for(int x=0;x < Main.WIDTH/Main.TILEDIMENSIONS;x++)
		{
			for(int y=0;y< Main.HEIGHT/Main.TILEDIMENSIONS;y++)
			{
				g.setColor(new Color(ran.nextInt(101),160,ran.nextInt(101)));
				g.drawRect(x*Main.TILEDIMENSIONS, y*Main.TILEDIMENSIONS, Main.TILEDIMENSIONS, Main.TILEDIMENSIONS);
			}
		}
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(background, 0, 0, null);
	}
}
