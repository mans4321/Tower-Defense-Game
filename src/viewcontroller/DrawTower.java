package viewcontroller;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.util.HashMap;
import java.util.Map;

import gamemodel.critter.Critter;
import gamemodel.tower.MissileCollection;
import gamemodel.tower.Tower;
import gamemodel.tower.TowerId;
import gamemodel.tower.TowerImageCollection;

public class DrawTower {
	
	
	 //g.drawImage(new ImageIcon("res/tower1.png").getImage(),240,270,this);
    /**
     * Method to draw a tower in the map
     * @param g Graphics object
     * @param cols number of columns in the map
     * @param towerMap the map of towers
     * @param observer image observer
     */
	  public static void drawTower(Graphics g, int cols, HashMap<Integer, Tower> towerMap, ImageObserver observer) {

	        Graphics2D g2d = (Graphics2D) g.create();;
	        for (Map.Entry<Integer, Tower> entry : towerMap.entrySet()) {
	            Integer index = entry.getKey();
	            Tower tower = entry.getValue();
	            if (tower.getTid() != TowerId.TOWERNULL) { // if TowerID == TOWERNULL, skip, draw nothing.
	                int[] arr = DrawMap.indexConverter(index, cols);
	                g2d.drawImage(new TowerImageCollection().getImage(tower.getTid().getName()) , arr[0], arr[1], observer);

	            }
	        }

	        g2d.dispose();

	    }

	/**
     * Method to draw the circle around the tower that displays the tower range
     * @param g Graphics
     * @param towerMap list of towers
     * @param observer
     */
    public static void drawTowerRange(Graphics g, HashMap<Integer, Tower> towerMap, ImageObserver observer) {

        Graphics2D g2d = (Graphics2D) g.create();
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alphaComposite);
        // Some rendering configuration
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
        		RenderingHints.VALUE_ANTIALIAS_ON);
        
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        for (Map.Entry<Integer, Tower> entry : towerMap.entrySet()) {
            Tower tower = entry.getValue();
            if (tower.getTid() != TowerId.TOWERNULL) { // if TowerID == TOWERNULL, skip, draw nothing.

                int posX = tower.getPosX();
                int posY = tower.getPosY();
                int range = tower.getRange();

                Ellipse2D rangeCircle = new Ellipse2D.Float(posX - range/2,posY - range/2,range,range);
                g2d.draw(rangeCircle);
                g2d.fill(rangeCircle);

            }
        }

        g2d.dispose();
    }
    
    /**
     * Method to draw the missiles 
     * @param g graphics
     * @param tower the tower shooting the missiles
     * @param critter the criter being targeted
     */
    public static void drawMissiles(Graphics g, Tower tower, Critter critter) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(MissileCollection.missiles.get(tower.getTid()));
        g2d.drawLine(tower.getPosX(), tower.getPosY(), critter.getPosX()+ DrawMap.CELL_SIZE/2, 
        		critter.getPosY()+ DrawMap.CELL_SIZE/2);
        g2d.dispose();

    }
}
