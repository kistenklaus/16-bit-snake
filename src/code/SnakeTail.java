package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class SnakeTail{
	
	private int posX,posY;
	private int oldX,oldY;
	
	private Rectangle bounding;
	//private SnakeHead sneak;
	
	static private List<SnakeTail> tail = new ArrayList<SnakeTail>();
	
	public SnakeTail(SnakeHead snake)
	{
		this.posX=snake.getX();
		this.posY=snake.getY();
		tail=snake.tail;
		
		bounding= new Rectangle(posX,posY,Main.TILEDIMENSIONS,Main.TILEDIMENSIONS);
	}
	
	public static void update() 
	{
		for(int i=1;i<tail.size();i++)
		{
			
		tail.get(i).setOldX(tail.get(i).getX());	//oldPos <- newPos
		tail.get(i).setOldY(tail.get(i).getY());
		
		tail.get(i).setX(tail.get(i-1).getOldX());	//newPos <- oldPos(i-1) 
		tail.get(i).setY(tail.get(i-1).getOldY());
		
		
		tail.get(i).getBounding().setLocation(tail.get(i).getX(), tail.get(i).getY());	//moving the Bounding of all Tail parts
		}
		
		
		
		
	}
	
	
	public void setOldX(int x){oldX=x;	}
	public void setOldY(int y){oldY=y;	}
	public void setX(int x){posX=x;	}
	public void setY(int y){posY=y;	}
	public int getX(){return posX;	}
	public int getY(){return posY;	}
	public int getOldX(){return oldX;	}
	public int getOldY(){return oldY;	}
	public Rectangle getBounding(){return bounding;	}
	

	public static void draw(Graphics g)
	{
		if(SnakeHead.alive)
		{
			g.setColor(Color.WHITE);
		}else
		{
			g.setColor(Color.RED);
		}
		
		for(int i=0;i<tail.size();i++)
		{
			//g.fillRect(tail.get(i).getX(), tail.get(i).getY(), Main.TILEDIMENSIONS, Main.TILEDIMENSIONS);
			g.fillOval(tail.get(i).getX(), tail.get(i).getY(), Main.TILEDIMENSIONS, Main.TILEDIMENSIONS);
		}
		
		
	}
}
