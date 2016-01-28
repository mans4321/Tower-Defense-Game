package com.tu.main;

import java.awt.Graphics;

public abstract class Gameobject { // this for all game object 

	 protected int x,y;   
	 protected ID id;  // ID class
	 protected int velX, velY;  // the speed in x&y direction 
	 
	 public Gameobject(int x, int y , ID id){
		 
		 this.x=x;
		 this.y=y;
		 this.id=id;
}
	 
	 public abstract void tick();
	 public abstract void render(Graphics g);
	 
	 
	 public void setX(int x){
		  this.x=x;
	 }
	 public int getX(int x){
		 return x;
	 }
	 
	 
	 public void setY(int y){
		  this.y=y;
	 }
	 public int getY(int y){
		 return y;
	 }
	 
	 public void setvelX(int velX){
		  this.velX=velX;
	 }
	 public int getvelX(int velX){
		 return velX;
	 }
	 
	 public void setvelY(int velY){
		 this.velY= velY;
	 }
	 public int getvelY(int velY){
		 return velY;
	 }
	 
	 public void setId(ID id){
		 this.id=id;
	 }
	 
	 public ID getId(ID id){
		 return id;
	 }
	 
	 
	 
}