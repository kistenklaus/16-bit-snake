package code;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	static final int WIDTH=500,HEIGHT=500;
	static final int TILEDIMENSIONS=WIDTH/20;
	static List<Jummy> jummys = new ArrayList<Jummy>();
	static SnakeHead snake = new SnakeHead(250,250);
	
	public static void main(String[] args) {
		
		
		Gui gui = new Gui(WIDTH,HEIGHT);
		gui.makeStrat();
		
		snake.lvlUp(5);
		
		jummys.add(new Jummy(Color.GREEN));
		jummys.add(new Jummy(Color.GREEN));
		
		long lastFrame = System.currentTimeMillis();
		while(true)
		{
			long thisFrame= System.currentTimeMillis();
			float fD=thisFrame-lastFrame;
			lastFrame=thisFrame;
			
			if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);
			if(SnakeHead.alive){
				snake.update(fD);
			}else{
				System.out.println("dead");
			}
			gui.repaintScreen();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
