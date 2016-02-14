package gamemodel.tower;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

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

    public Image getImage(String name) {
        return towerImageCollection.get(name).getImage();
    }

    public ImageIcon getImageIcon(String name){
        return towerImageCollection.get(name);
    }

}