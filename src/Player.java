package com.tu.main;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends Gameobject {

	
	          Random r = new Random();
	          
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		
	}
  
	      /// if we extends form abstract class we need implemented method 
	public void tick() {
		
		x +=velX;
		y +=velY;
	}

	
	public void render(Graphics g) {
		if(id==ID.Player)g.setColor(Color.white);
		if(id==ID.Player2)g.setColor(Color.red);
		
		g.fillRect(x, y, 23, 23);
	
	}

	      
}
