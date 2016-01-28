package com.tu.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2235182218241326437L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;   // the window size and of course u can put as want 
	
	private Thread thread;               // this what going to run the entire game 
	private boolean running = false;
	
	private Handler handler;
	
	
	public Game(){
		new window(WIDTH,HEIGHT,"Let's build a game", this ); // assign the values to window
		handler = new Handler();           
	}
	
	public synchronized void start(){    // when u deal with thread u have to have synchronized method  
		
	if(running)
	  return;
				 //we can add in case if running is true that thread is made(we do not overload it)
	
	running= true ;
	thread = new Thread(this);
	thread.start();                // start the thread 
	
	
	
      }
	
	public synchronized void stop(){
		                
		                     // stop the thread 
		try{
			  thread.join();
			  running = false;
			  
		}catch(Exception e){
			e.printStackTrace();
		
		}
		}
	
	public void run(){        // we include because we implements runnable 
	             
		 /// this game loop to make the game running it is a famous one u can look it up
		 
		long lastTime = System.nanoTime();
		double amount0fTicks=60.0;
		double ns = 1000000000/ amount0fTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running){
			
			long now = System.nanoTime();
			delta += (now - lastTime) /ns;
			lastTime = now;
			
		while (delta >=1){
			tick();
			delta --;
		}
		
		if(running)
			render(); 
		frames ++;
		
		if(System.currentTimeMillis()- timer > 1000){
			
			timer +=1000;
			
			System.out.println("FPS: " + frames);
			
			frames =0;
			
		}
				
	}
              stop();	
}
	private void tick(){      // updating the images background in fix time // this for the game loop
		
		handler.tick();
		
	}
	
	private void render(){     // this for the game loop
		                                         
		// https://www.youtube.com/watch?v=Zh7YiiEuJFw   minute 4 
		BufferStrategy bs = this.getBufferStrategy();    // this refer to the canvas class
		
		if (bs == null){
			
			this.createBufferStrategy(3); // recommend to be 3  // this tell the complier to buffer 3 screen if three is available space  
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();   // creating our Graph (drawing)
		
		//////////// here where we draw
		g.setColor(Color.red);             // set the color 
		g.fillRect(0, 0, WIDTH, HEIGHT);     // 
		handler.render(g);
        ////
		g.dispose();                    
		bs.show();
	}
	public static void main(String args[]){
		
		
		new Game();             // call the Game class
		
	}

}
