package gamemodel.tower;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
/**
 * This class assign each tower to it's image icon
 * 
 *@author yongpinggao
 *@since  1/31/16
 *@version 1.0
 */
public class TowerImageCollection {



    private HashMap<String, ImageIcon> towerImageCollection;
    private String URL = "res/";
    private String format = ".png";
    public TowerImageCollection() {
        towerImageCollection = new HashMap<String, ImageIcon>();

        //TowerA
        towerImageCollection.put(TowerID.TOWERA1.getName(), new ImageIcon(URL + TowerID.TOWERA1.getName() + format));
        towerImageCollection.put(TowerID.TOWERA2.getName(), new ImageIcon(URL + TowerID.TOWERA2.getName() + format));
        towerImageCollection.put(TowerID.TOWERA3.getName(), new ImageIcon(URL + TowerID.TOWERA3.getName() + format));
        towerImageCollection.put(TowerID.TOWERAH.getName(), new ImageIcon(URL + TowerID.TOWERAH.getName() + format));

        //TowerB
        towerImageCollection.put(TowerID.TOWERB1.getName(), new ImageIcon(URL + TowerID.TOWERB1.getName() + format));
        towerImageCollection.put(TowerID.TOWERB2.getName(), new ImageIcon(URL + TowerID.TOWERB2.getName() + format));
        towerImageCollection.put(TowerID.TOWERB3.getName(), new ImageIcon(URL + TowerID.TOWERB3.getName() + format));
        towerImageCollection.put(TowerID.TOWERBH.getName(), new ImageIcon(URL + TowerID.TOWERBH.getName() + format));

        //TowerC
        towerImageCollection.put(TowerID.TOWERC1.getName(), new ImageIcon(URL + TowerID.TOWERC1.getName() + format));
        towerImageCollection.put(TowerID.TOWERC2.getName(), new ImageIcon(URL + TowerID.TOWERC2.getName() + format));
        towerImageCollection.put(TowerID.TOWERC3.getName(), new ImageIcon(URL + TowerID.TOWERC3.getName() + format));
        towerImageCollection.put(TowerID.TOWERCH.getName(), new ImageIcon(URL + TowerID.TOWERCH.getName() + format));
    }
/**
 * get the tower icon
 * @param name tower name
 * @return tower image
 */
    public Image getImage(String name) {
        return towerImageCollection.get(name).getImage();
    }
/**
 *get tower  name 
 * @param  name tower name
 * @return the image icon                                         //whta
 */
    public ImageIcon getImageIcon(String name){
        return towerImageCollection.get(name);
    }

}
