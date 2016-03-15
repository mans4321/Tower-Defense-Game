package viewcontroller;

import gamemodel.gamemap.*;


import java.awt.*;

import java.awt.image.ImageObserver;
import java.util.ArrayList;


/**
 * This class draws the tile map for the game
 * @author yongpinggao
 * @since 1/29/16
 *
 */
public class DrawMap {


    // cell image size in pixels
    public final static int CELL_SIZE = 30;

    private final static float ALPHA = 0.3f;

    /**
     * converts the pixel coordinates into the specific cell in the map
     * @param x x pixel
     * @param y y pixel
     * @param cols number of columns
     * @return the nth cell number in the map
     */
    public static int coordinateConverter(int x, int y, int cols) {
        return x / CELL_SIZE + (y / CELL_SIZE) * cols;
    }
    
    /**
     * index converter
     * @param index 
     * @param cols
     * @return
     */
    public static int[] indexConverter(int index, int cols) {
        int x = index % cols;
        int y = index / cols;
        return new int[]{x * CELL_SIZE, y * CELL_SIZE};
    }
    
    /**
     * Constructor class, draws the map 
     * @param g Graphics object 
     * @param mapCols number of cols of the map
     * @param mapRows number of rows of the map
     * @param cellList the list with all tiles information
     * @param observer image observer
     */
    public static void drawMap(Graphics g, int mapCols, int mapRows, ArrayList<CellState> cellList, ImageObserver observer) {
        Graphics2D g2d = (Graphics2D) g.create();
        MapImageCollection imageCollection = new MapImageCollection();

        for(int i = 0; i < CELL_SIZE * mapCols; i = i + CELL_SIZE) {
            for(int j = 0; j < CELL_SIZE * mapRows; j = j + CELL_SIZE) {


                switch (cellList.get(coordinateConverter(i, j, mapCols))) {
                    case GRASS:
                        g2d.drawImage(imageCollection.getImage(CellState.GRASS.getCellStateName()), 
                        		i, j, observer);
                        break;
                    case PATH:
                        g2d.drawImage(imageCollection.getImage(CellState.PATH.getCellStateName()), 
                        		i, j, observer);
                        break;
                    case ENTRANCE:
                        g2d.drawImage(imageCollection.getImage(CellState.ENTRANCE.getCellStateName()), 
                        		i, j, observer);
                        break;
                    case EXIT:
                        g2d.drawImage(imageCollection.getImage(CellState.EXIT.getCellStateName()), 
                        		i, j, observer);
                        break;
                    case TOPLACETOWER:
                        g2d.drawImage(imageCollection.getImage(CellState.TOPLACETOWER.getCellStateName()), 
                        		i, j, observer);
                        break;
                    case TOWER:
                        g2d.drawImage(imageCollection.getImage(CellState.GRASS.getCellStateName()), 
                        		i, j, observer);
                        break;
                    case CHOSEN:
                        g2d.drawImage(imageCollection.getImage(CellState.GRASS.getCellStateName()), 
                        		i, j, observer);
                        g2d.drawImage(imageCollection.getImage(CellState.CHOSEN.getCellStateName()), 
                        		i, j, observer);
                        break;

                }
            }
        }
        g2d.dispose();
    }

}