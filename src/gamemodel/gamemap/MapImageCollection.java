package gamemodel.gamemap;
import javax.swing.*;

import gamemodel.tower.TowerID;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class MapImageCollection {

    private HashMap<String, ImageIcon> mapImageCollection;
    private String URL = "res/";
    private String format = ".png";
    public MapImageCollection() {
        mapImageCollection = new HashMap<String, ImageIcon>();


        mapImageCollection.put(CellState.GRASS.getCellStateName(), new ImageIcon(URL + CellState.GRASS.getCellStateName() + format));
        mapImageCollection.put(CellState.PATH.getCellStateName(), new ImageIcon((URL + CellState.PATH.getCellStateName() + format)));
        mapImageCollection.put(CellState.ENTRANCE.getCellStateName(), new ImageIcon(URL + CellState.ENTRANCE.getCellStateName() + format));
        mapImageCollection.put(CellState.EXIT.getCellStateName(), new ImageIcon(URL + CellState.EXIT.getCellStateName() + format));
        mapImageCollection.put(CellState.TOPLACETOWER.getCellStateName(), new ImageIcon(URL + CellState.TOPLACETOWER.getCellStateName() + format));
        mapImageCollection.put(CellState.CHOSEN.getCellStateName(), new ImageIcon(URL + CellState.CHOSEN.getCellStateName() + format));
    }


    public Image getImage(String name) {
        return mapImageCollection.get(name).getImage();
    }

    public ImageIcon getImageIcon(String name){
        return mapImageCollection.get(name);
    }
}
