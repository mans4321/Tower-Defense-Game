package viewcontroller;
import gamemodel.critter.*;
import gamemodel.gamemap.*;
import gamemodel.tower.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yongpinggao on 1/29/16.
 */
public class DrawMap {


    // cell image size in pixels
    public final static int CELL_SIZE = 30;

    private final static float ALPHA = 0.3f;
    // input: coordinate(x,y)(pixels), cell size of a cell. And cols number
    // output: nth cell in whole map
    public static int coordinateConverter(int x, int y, int cols) {
        return x / CELL_SIZE + (y / CELL_SIZE) * cols;
    }

    public static int[] indexConverter(int index, int cols){
        int x = index % cols;
        int y = index / cols;
        return new int[]{x * CELL_SIZE, y * CELL_SIZE};
    }

    public static void drawMap(Graphics g, int mapCols, int mapRows, ArrayList<CellState> cellList, ImageObserver observer){
        Graphics2D g2d = (Graphics2D) g.create();
        MapImageCollection imageCollection = new MapImageCollection();

        for(int i = 0; i < CELL_SIZE * mapCols; i = i + CELL_SIZE){
            for(int j = 0; j < CELL_SIZE * mapRows; j = j + CELL_SIZE){


                switch (cellList.get(coordinateConverter(i, j, mapCols))){
                    case GRASS:
                        g2d.drawImage(imageCollection.getImage(CellState.GRASS.getCellStateName()), i, j, observer);
                        break;
                    case PATH:
                        g2d.drawImage(imageCollection.getImage(CellState.PATH.getCellStateName()), i, j, observer);
                        break;
                    case ENTRANCE:
                        g2d.drawImage(imageCollection.getImage(CellState.ENTRANCE.getCellStateName()), i, j, observer);
                        break;
                    case EXIT:
                        g2d.drawImage(imageCollection.getImage(CellState.EXIT.getCellStateName()), i, j, observer);
                        break;
                    case TOPLACETOWER:
                        g2d.drawImage(imageCollection.getImage(CellState.TOPLACETOWER.getCellStateName()), i, j, observer);
                        break;
                    case TOWER:
                        g2d.drawImage(imageCollection.getImage(CellState.GRASS.getCellStateName()), i, j, observer);
                        break;
                    case CHOSEN:
                        g2d.drawImage(imageCollection.getImage(CellState.GRASS.getCellStateName()), i, j, observer);
                        g2d.drawImage(imageCollection.getImage(CellState.CHOSEN.getCellStateName()), i, j, observer);
                        break;

                }
            }
        }
        g2d.dispose();
    }

//    g.drawImage(new ImageIcon("res/tower1.png").getImage(),240,270,this);
    public static void drawTower(Graphics g, int cols, HashMap<Integer, Tower> towerMap, ImageObserver observer){

        Graphics2D g2d = (Graphics2D) g.create();;
        for (Map.Entry<Integer, Tower> entry : towerMap.entrySet()) {
            Integer index = entry.getKey();
            Tower tower = entry.getValue();
            if(tower.getTid() != TowerID.TOWERNULL) { // if TowerID == TOWERNULL, skip, draw nothing.
                int[] arr = indexConverter(index, cols);
                g2d.drawImage(new TowerImageCollection().getImage(tower.getTid().getName()) , arr[0], arr[1], observer);

            }
        }

        g2d.dispose();

    }

    public static void drawCritters(Graphics g, Critter c, ImageObserver observer){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(c.getImage(), c.getPosX(), c.getPosY(),observer);
        g2d.dispose();

    }

    public static void drawTowerRange(Graphics g, HashMap<Integer, Tower> towerMap, ImageObserver observer){

        Graphics2D g2d = (Graphics2D) g.create();
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alphaComposite);
        // Some rendering configuration
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        for (Map.Entry<Integer, Tower> entry : towerMap.entrySet()) {
            Tower tower = entry.getValue();
            if(tower.getTid() != TowerID.TOWERNULL) { // if TowerID == TOWERNULL, skip, draw nothing.

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

    public static void drawMissiles(Graphics g, Tower tower, Critter critter) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(MissileCollection.missiles.get(tower.getTid()));
        g2d.drawLine(tower.getPosX(), tower.getPosY(), critter.getPosX()+ CELL_SIZE/2, critter.getPosY()+ CELL_SIZE/2);
        g2d.dispose();

    }

    public static  void drawHealthBar(Graphics g, float healthBar, Critter c){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.GREEN);
        g2d.fillRect(c.getPosX(), c.getPosY() - 5, (int) (healthBar * CELL_SIZE), 3);
        g2d.dispose();
    }



}