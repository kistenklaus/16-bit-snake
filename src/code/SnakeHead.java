package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class SnakeHead {
	
	public List<SnakeTail> tail = new ArrayList<SnakeTail>();
	public static boolean alive=true;
	
	private int posX,posY;
	private int oldX,oldY;
	private int direktion =0;
	private float timer;
	private final float MS=0.1f;	//timer to move 1 tile
	
	public SnakeHead(int posX,int posY)
	{
		this.posX=posX;
		this.posY=posY;
	}
	
	public void lvlUp(int n)
	{
		for(int i=0;i<n;i++)
		{
			tail.add(new SnakeTail(Main.snake));
		}
	}
	public void update(float fD)
	{
		
		if(Keyboard.isKeyDown(KeyEvent.VK_A)&&direktion!=1)direktion=0;
		if(Keyboard.isKeyDown(KeyEvent.VK_D)&&direktion!=0)direktion=1;
		if(Keyboard.isKeyDown(KeyEvent.VK_S)&&direktion!=3)direktion=2;
		if(Keyboard.isKeyDown(KeyEvent.VK_W)&&direktion!=2)direktion=3;
		
		timer += fD/1000;
		if(timer>MS)
		{
			timer =0;
			
			setOldX(posX);
			setOldY(posY);
			tail.get(0).setOldX(posX);
			tail.get(0).setOldY(posY);
			switch(direktion){
			case 0:
				posX-=Main.TILEDIMENSIONS;
				break;
			case 1:
				posX+=Main.TILEDIMENSIONS;
				break;
			case 2:
				posY+=Main.TILEDIMENSIONS;
				break;
			case 3:
				posY-=Main.TILEDIMENSIONS;
				break;
			}
			
			tail.get(0).setX(posX);
			tail.get(0).setY(posY);
			tail.get(0).getBounding().setLocation(posX,posY);
			
			SnakeTail.update();
			
			for(int i=2;i<tail.size();i++)	//intersects with tail
			{
				if(tail.get(0).getBounding().intersects(tail.get(i).getBounding()))
				{
					alive =false;
				}
			}
			
			for(int i=0;i<Main.jummys.size();i++)
			{
				if(tail.get(0).getBounding().intersects(Main.jummys.get(i).getBounding()))
				{
					System.out.println("intersection");
					Main.jummys.get(i).eaten();
					lvlUp(1);
				}
			}
			
			
		}
		
		
	}
	public void draw(Graphics g)
	{
		SnakeTail.draw(g);
		if(SnakeHead.alive)
		{
			g.setColor(Color.RED);
		}else
		{
			g.setColor(Color.YELLOW);
		}
		g.fillOval(posX,posY,Main.TILEDIMENSIONS,Main.TILEDIMENSIONS);
	}
	
	
	
	public int getX(){return posX;	}
	public int getY(){return posY;	}

	public int getOldY() {
		return oldY;
	}

	public void setOldY(int oldY) {
		this.oldY = oldY;
	}

	public int getOldX() {
		return oldX;
	}

	public void setOldX(int oldX) {
		this.oldX = oldX;
	}
}





























