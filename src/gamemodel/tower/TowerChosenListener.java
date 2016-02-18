package gamemodel.tower;

/**
 * Interface update the tower view Specifications to the chosen tower
 * 
 *@author  yongpinggao 
 *@since 1/31/16.
 *@version 1.0
 *
 */
public interface TowerChosenListener {
    
    /**
     * update the tower view Specifications to the chosen tower.
     * @param id  tower id 
     */
    void updateInfo(TowerID id);
}
