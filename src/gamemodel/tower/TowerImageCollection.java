package gamemodel.tower;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * This class assign each tower to it's image icon.
 * 
 * @author yongpinggao
 * @since  1/31/16
 * @version 1.0
 */
public class TowerImageCollection {

    private HashMap<String, ImageIcon> towerImageCollection;
    private String URL = "res/";
    private String format = ".png";
    
    /**
     * Collection of images for the towers
     */
    public TowerImageCollection() {
        towerImageCollection = new HashMap<String, ImageIcon>();

        //TowerA
        towerImageCollection.put(TowerId.TOWERA1.getName(), new ImageIcon(URL + TowerId.TOWERA1.getName() + format));
        towerImageCollection.put(TowerId.TOWERA2.getName(), new ImageIcon(URL + TowerId.TOWERA2.getName() + format));
        towerImageCollection.put(TowerId.TOWERA3.getName(), new ImageIcon(URL + TowerId.TOWERA3.getName() + format));
        towerImageCollection.put(TowerId.TOWERAH.getName(), new ImageIcon(URL + TowerId.TOWERAH.getName() + format));

        //TowerB
        towerImageCollection.put(TowerId.TOWERB1.getName(), new ImageIcon(URL + TowerId.TOWERB1.getName() + format));
        towerImageCollection.put(TowerId.TOWERB2.getName(), new ImageIcon(URL + TowerId.TOWERB2.getName() + format));
        towerImageCollection.put(TowerId.TOWERB3.getName(), new ImageIcon(URL + TowerId.TOWERB3.getName() + format));
        towerImageCollection.put(TowerId.TOWERBH.getName(), new ImageIcon(URL + TowerId.TOWERBH.getName() + format));

        //TowerC
        towerImageCollection.put(TowerId.TOWERC1.getName(), new ImageIcon(URL + TowerId.TOWERC1.getName() + format));
        towerImageCollection.put(TowerId.TOWERC2.getName(), new ImageIcon(URL + TowerId.TOWERC2.getName() + format));
        towerImageCollection.put(TowerId.TOWERC3.getName(), new ImageIcon(URL + TowerId.TOWERC3.getName() + format));
        towerImageCollection.put(TowerId.TOWERCH.getName(), new ImageIcon(URL + TowerId.TOWERCH.getName() + format));
    }
    
    /**
     * get the tower icon.
     * @param name tower name
     * @return tower image
     */
    public Image getImage(String name) {
        return towerImageCollection.get(name).getImage();
    }
    
    /**
     *get tower  name. 
     * @param  name tower name
     * @return the image icon 
     */
    public ImageIcon getImageIcon(String name) {
        return towerImageCollection.get(name);
    }

}
