package protocol;

import model.map.GameMap;

/**
 * Base interface
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public interface DrawingMapDelegate {
    void refreshMap(GameMap map);
}
