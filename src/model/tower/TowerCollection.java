package model.tower;


import model.gamelog.Log;
import model.gamelog.LogType;
import model.gamelog.LoggerCollection;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by yongpinggao on 3/13/16.
 */
public class TowerCollection {


    private HashMap<Integer, Tower> towers;

    public TowerCollection(){
        this.towers = new HashMap<>();
    }

    public HashMap<Integer, Tower> getTowers() {
        return towers;
    }

    public void addTowerAtIndex(int index, Tower tower){
        towers.put(index, tower);
    }

    public void removeTowerAtIndex(int index){
        towers.remove(index);
    }

}
