package gamemodel.tower;

/**
 *An interface for  sell and upgrading towers 
 *
 *@author  yongpinggao
 *@see TowerA,TowerB,and TowerC. 
 *@version 1.0
 *@since 1/31/16.
 */
public interface TowerManipulationListener {

    /**
     * This method perform the action of  tower sell.
     * 
     * @see TowerA,TowerB,and Towerc.
     */
    void sellTower();
    
    /**
    * This method perform the action of  tower sell.
    *
    *@see  TowerA,TowerB,and Towerc.
    */
    void upgradeTower();
}
