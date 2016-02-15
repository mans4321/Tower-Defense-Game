package gamemodel;
import javax.swing.*;


import java.awt.*;
import java.util.HashMap;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class ImageCollection {

    private HashMap<String, ImageIcon> imageCollection;
    private String URL = "res/";
    private String format = ".png";
    public ImageCollection() {
        imageCollection = new HashMap();


        imageCollection.put(CellState.GRASS.getCellStateName(), new ImageIcon(URL + CellState.GRASS.getCellStateName() + format));
        imageCollection.put(CellState.PATH.getCellStateName(), new ImageIcon(URL + CellState.PATH.getCellStateName() + format));
        imageCollection.put(CellState.ENTRANCE.getCellStateName(), new ImageIcon(URL + CellState.ENTRANCE.getCellStateName() + format));
        imageCollection.put(CellState.EXIT.getCellStateName(), new ImageIcon(URL + CellState.EXIT.getCellStateName() + format));
        imageCollection.put(CellState.TOPLACETOWER.getCellStateName(), new ImageIcon(URL + CellState.TOPLACETOWER.getCellStateName() + format));
        imageCollection.put(CellState.CHOSEN.getCellStateName(), new ImageIcon(URL + CellState.CHOSEN.getCellStateName() + format));



        //TowerA
        imageCollection.put(TowerID.TOWERA1.getName(), new ImageIcon(URL + TowerID.TOWERA1.getName() + format));
        imageCollection.put(TowerID.TOWERA2.getName(), new ImageIcon(URL + TowerID.TOWERA2.getName() + format));
        imageCollection.put(TowerID.TOWERA3.getName(), new ImageIcon(URL + TowerID.TOWERA3.getName() + format));
        imageCollection.put(TowerID.TOWERAH.getName(), new ImageIcon(URL + TowerID.TOWERAH.getName() + format));

        //TowerB
        imageCollection.put(TowerID.TOWERB1.getName(), new ImageIcon(URL + TowerID.TOWERB1.getName() + format));
        imageCollection.put(TowerID.TOWERB2.getName(), new ImageIcon(URL + TowerID.TOWERB2.getName() + format));
        imageCollection.put(TowerID.TOWERB3.getName(), new ImageIcon(URL + TowerID.TOWERB3.getName() + format));
        imageCollection.put(TowerID.TOWERBH.getName(), new ImageIcon(URL + TowerID.TOWERBH.getName() + format));

        //TowerC
        imageCollection.put(TowerID.TOWERC1.getName(), new ImageIcon(URL + TowerID.TOWERC1.getName() + format));
        imageCollection.put(TowerID.TOWERC2.getName(), new ImageIcon(URL + TowerID.TOWERC2.getName() + format));
        imageCollection.put(TowerID.TOWERC3.getName(), new ImageIcon(URL + TowerID.TOWERC3.getName() + format));
        imageCollection.put(TowerID.TOWERCH.getName(), new ImageIcon(URL + TowerID.TOWERCH.getName() + format));




    }


    Image getImage(String name) {
        return imageCollection.get(name).getImage();
    }

    ImageIcon getImageIcon(String name){
        return imageCollection.get(name);
    }
}
