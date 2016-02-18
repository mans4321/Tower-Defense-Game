package gamemodel.tower;

/**
 * An interface responsible for placing the selected tower.
 * 
 *@author yongpinggao
 *
 *@see TowerA,TowerB,and Towerc. 
 *@since 1/30/16.
 *@version 1.0
 */
public interface TowerSelectionListener {

    /** 
     * Perform the action of placing tower on the map.
     * 
     * @param id tower id 
     * 
     */
    public void placeTower(TowerId id);
}
