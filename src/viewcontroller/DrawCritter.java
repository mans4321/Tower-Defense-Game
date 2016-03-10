package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import gamemodel.critter.Critter;

public class DrawCritter {
	
	
	/**
     * Method to draw a critter in the map
     * @param g Graphics object
     * @param c critter to be drawn
     * @param observer image observer
     */
    public static void drawCritters(Graphics g, Critter c, ImageObserver observer) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(c.getImage(), c.getPosX(), c.getPosY(),observer);
        g2d.dispose();

    }

	/**
     * Method to draw the health bar in critters
     * @param g Graphics
     * @param healthBar value of health 
     * @param c critter
     */
    public static  void drawHealthBar(Graphics g, float healthBar, Critter c) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.GREEN);
        g2d.fillRect(c.getPosX(), c.getPosY() - 5, (int) (healthBar * DrawMap.CELL_SIZE), 3);
        g2d.dispose();
    }
}
