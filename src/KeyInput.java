package com.tu.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	
	public KeyInput(Handler handler){
		
		this.handler= handler;
		
	}
	public void keyPressed( KeyEvent e){
		
		int key = e.getKeyCode();
		System.out.println(key);
/*		
for( int i =0; i < handler.object.size(); i++){
			
			Gameobject tempObject = handler.object.get(i);
				
				if(tempObject.getId()==  ID.Player){
				
				if(key == KeyEvent.VK_A) tempObject.setvelY(-5);
					
	 		}
				if(tempObject.getId() == ID.Player2){
				
					if(key == KeyEvent.VK_M) tempObject.setvelY(-5);
				}	
				}*/
	}
	

	
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
for(int i =0; i < handler.object.size(); i++){
			
			Gameobject tempObject = handler.object.get(i);
				
				if(tempObject.getId()==  ID.Player){
				
				if(key == KeyEvent.VK_A) tempObject.setvelY(0);
					
	 		}
				if(tempObject.getId() == ID.Player2){
				
					if(key == KeyEvent.VK_M) tempObject.setvelY(0);
				}	
				}
	}
	
	

}
