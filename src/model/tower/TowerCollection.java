package model.tower;


import com.google.gson.annotations.Expose;
import com.sun.tools.classfile.TypeAnnotation;
import model.gamelog.Log;
import model.gamelog.LogType;
import model.gamelog.LoggerCollection;
import view.map.Drawing;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongpinggao on 3/13/16.
 */
public class TowerCollection {

    @Expose
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


    public void setTowers(HashMap<Integer, Tower> towers) {
        this.towers = towers;
    }
}
