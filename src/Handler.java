package com.tu.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {   // this going to maintain and update our render
	                     // will going to loop through each object in game and indviiual updata them and rendern them to screen 

	
	
	LinkedList<Gameobject> object = new LinkedList<Gameobject>();  // create a list for all gameobject
	
	public void tick(){
		
		for(int i =0; i < object.size(); i++){
			
			Gameobject tempObject = object.get(i); // get() is function in linked list this enable us to go through each object 
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics g){
		
		for(int i =0; i < object.size(); i++){
	Gameobject tempObject = object.get(i); // get() is function in linked list this enable us to go through each object 
			
			tempObject.render(g);
	}
	}
	public void addObject(Gameobject object){
		this.object.add(object);           /// adding object to the list 
	}
	
	public void removeObject(Gameobject object){
		this.object.remove(object);           /// removing object to the list 
	}
	}
	
