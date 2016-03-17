package protocol;

import model.tower.Tower;

/**
 * draw all the panels interface
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public interface DrawingPanelDelegate {
    
    /**
     * reload Panel Based On Tower
     * @param Tower tower 
     * /
    void reloadPanelBasedOnTower(Tower tower);
}
