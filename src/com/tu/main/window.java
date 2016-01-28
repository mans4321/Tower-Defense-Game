package com.tu.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class window extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -663275516478359514L;

	public window ( int width , int height, String title , Game game ){
		
		JFrame frame = new JFrame(title);   // the frame of our window in build lib in java
		
		
		frame.setPreferredSize(new Dimension(width , height));
		frame.setMaximumSize(new Dimension(width , height));               // no need to explain
		frame.setMinimumSize(new Dimension(width , height));
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // to make game exit and stop working 
		frame.setResizable(false);                              // 
		frame.setLocationRelativeTo(null);                      // if we did include this the window will start in the top lift but with this the window is going  to be in middle 
		frame.add(game);                                        // add the game class in the frame 
		frame.setVisible(true);                                 /// see the screen
		game.start();                                           // run the start function 
		
	}
}
