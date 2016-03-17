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
    /**
     * refresh Map
     * @param GameMap game map 
     * @param TowerCollection towerCollection
     * /
    void refreshMap(GameMap map, TowerCollection towerCollection);
    /**
     * refresh Critters In Map
     * /
    void refreshCrittersInMap();
    /**
     * refresh Map
     * @param TowerCollection towerCollection
     * /
    void refreshShootingEffectInMap(TowerCollection towerCollection);
}
