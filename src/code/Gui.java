package code;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Gui extends JFrame{

	
	private int width,height;
	
	private BufferStrategy strat;
	private Background background;
	
	public Gui(int width,int height)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, width);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		addKeyListener(new Keyboard());
		
		this.width=width;
		this.height=height;
		
		background = new Background();
	}
	
	public void makeStrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	public void repaintScreen(){
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}
	
	private void draw(Graphics g){
		
		g.clearRect(0, 0, width, height);
		background.draw(g);
		Jummy.draw(g);
		Main.snake.draw(g);
				
		
	}
}
