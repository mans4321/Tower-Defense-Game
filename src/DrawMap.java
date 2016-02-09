

import javax.swing.*;


import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class DrawMap {


    // cell image size in pixels
    public final static int CELL_SIZE = 30;
    // input: coordinate(x,y)(pixels), cell size of a cell. And cols number
    // output: nth cell in whole map
    public static int coordinateConverter(int x, int y, int cols) {
        return x / CELL_SIZE + (y / CELL_SIZE) * cols;
    }

    public static void drawMap(Graphics g, int mapCols, int mapRows, ArrayList<CellState> cellList, ImageObserver observer){
        Graphics2D g2d = (Graphics2D) g;
        ImageCollection imageCollection = new ImageCollection();

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
    }

//    g.drawImage(new ImageIcon("res/tower1.png").getImage(),240,270,this);
    public static void drawTower(Graphics g, int mapCols, int mapRows, ArrayList<TowerID> towerIDArrayList, ImageObserver observer){
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < CELL_SIZE * mapCols; i = i + CELL_SIZE){
            for(int j = 0; j < CELL_SIZE * mapRows; j = j + CELL_SIZE){

                TowerID id = towerIDArrayList.get(coordinateConverter(i, j, mapCols));

                // if TowerID == TOWERNULL, skip, draw nothing.
                if(id != TowerID.TOWERNULL)
                g2d.drawImage(new ImageCollection().getImage(id.getName()) , i, j, observer);
            }
        }

    }


}
