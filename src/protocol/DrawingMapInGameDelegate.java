package protocol;

import model.map.GameMap;
import model.tower.TowerCollection;

/**
 * draw map interface in the game (towers, critters, etc.)
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public interface DrawingMapInGameDelegate extends DrawingMapDelegate{
    void refreshMap(GameMap map, TowerCollection towerCollection);
    void refreshCrittersInMap();
    void refreshShootingEffectInMap(TowerCollection towerCollection);
}
