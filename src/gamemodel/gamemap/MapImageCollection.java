package gamemodel.gamemap;
import javax.swing.*;

import gamemodel.tower.TowerID;

import java.awt.*;
import java.util.HashMap;

/**
 * The mapImageCollection assign each cell state name to the image represents the cell state.
 * 
 * For example, assigning the Grass cell state  to the storied image represents Grass.
 * To do this the cell state and it assigned image story in HashMap that type string for the cell state 
 * and IMageIcon for the assigned image.    
 *@author  Mansour 
 *@since   24/2/2016
 *
 */
public class MapImageCollection {

    private HashMap<String, ImageIcon> mapImageCollection;
    private String URL = "res/";
    private String format = ".png";
    /**
     * Sets the image to be displayed for each type of tile saved
     */
    public MapImageCollection() {
        mapImageCollection = new HashMap<String, ImageIcon>();


        mapImageCollection.put(CellState.GRASS.getCellStateName(), new ImageIcon(URL + CellState.GRASS.getCellStateName() + format));
        mapImageCollection.put(CellState.PATH.getCellStateName(), new ImageIcon((URL + CellState.PATH.getCellStateName() + format)));
        mapImageCollection.put(CellState.ENTRANCE.getCellStateName(), new ImageIcon(URL + CellState.ENTRANCE.getCellStateName() + format));
        mapImageCollection.put(CellState.EXIT.getCellStateName(), new ImageIcon(URL + CellState.EXIT.getCellStateName() + format));
        mapImageCollection.put(CellState.TOPLACETOWER.getCellStateName(), new ImageIcon(URL + CellState.TOPLACETOWER.getCellStateName() + format));
        mapImageCollection.put(CellState.CHOSEN.getCellStateName(), new ImageIcon(URL + CellState.CHOSEN.getCellStateName() + format));
    }

/**
 * 
 * @param name tower name
 * @return     tower image
 */
    public Image getImage(String name) {
        return mapImageCollection.get(name).getImage();
    }
/**
 * 
 * @param name tower name
 * @return     tower name 
 */
    public ImageIcon getImageIcon(String name) {
        return mapImageCollection.get(name);
    }
}
