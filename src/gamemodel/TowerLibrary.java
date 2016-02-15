package gamemodel;


import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by yongpinggao on 1/30/16.
 */
public class TowerLibrary {

    private HashMap<TowerID, Tower> towerCollection;

    public TowerLibrary(){
        towerCollection = new HashMap<TowerID, Tower>();

        towerCollection.put(TowerID.TOWERA1, new TowerA(1));
        towerCollection.put(TowerID.TOWERA2, new TowerA(2));
        towerCollection.put(TowerID.TOWERA3, new TowerA(3));

        towerCollection.put(TowerID.TOWERB1, new TowerB(1));
        towerCollection.put(TowerID.TOWERB2, new TowerB(2));
        towerCollection.put(TowerID.TOWERB3, new TowerB(3));

        towerCollection.put(TowerID.TOWERC1, new TowerC(1));
        towerCollection.put(TowerID.TOWERC2, new TowerC(2));
        towerCollection.put(TowerID.TOWERC3, new TowerC(3));
    }

    public HashMap<TowerID, Tower> getTowerCollection() {
        return towerCollection;
    }
}
