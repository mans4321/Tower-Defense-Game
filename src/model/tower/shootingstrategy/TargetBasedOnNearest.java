package model.tower.shootingstrategy;

import model.critter.Critter;
import view.map.Position;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by yongpinggao on 3/14/16.
 */
public class TargetBasedOnNearest implements TowerShootingStrategy {
    @Override
    public Critter targetOnCritters(Set<Critter> crittersInRange, Position towerPosition) {

        if (crittersInRange.size() > 0) {
            Iterator<Critter> iterator = crittersInRange.iterator();
            Critter nearestCritter = iterator.next();

            while (iterator.hasNext()) {
                Critter c = iterator.next();
                if (c.getMovingBehavior().getPathList().size() < nearestCritter.getMovingBehavior().getPathList().size()) {
                    nearestCritter = c;
                }
            }
            return nearestCritter;
        }
        return null;
    }
}
