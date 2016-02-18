package gamemodel.tower;
/**
 *An interface for  selling and upgrading towers 
 *
 *@author  yongpinggao
 *@see TowerA,TowerB,and Towerc. 
 *@version 1.0
 *@since 1/31/16.
 */
public interface TowerManipulationListener {

/**
 *  performing  the action of  selling a tower 
 * 
 * @see TowerA,TowerB,and Towerc.
 */
    void sellTower();
/**
* This method perform the action of upgrading tower 
*
*@see  TowerA,TowerB,and Towerc.
*/
    void upgradeTower();
}
