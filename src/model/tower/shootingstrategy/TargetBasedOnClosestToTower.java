package model.tower.shootingstrategy;

import model.critter.Critter;
import view.map.Position;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by yongpinggao on 3/25/16.
 */
public class TargetBasedOnClosestToTower implements TowerShootingStrategy {
    @Override
    public Critter targetOnCritters(Set<Critter> crittersInRange, Position towerPosition) {
        
        if (!crittersInRange.isEmpty()) {
            Iterator<Critter> iterator = crittersInRange.iterator();
            Critter closestCritter = iterator.next();

            while (iterator.hasNext()) {
                Critter c = iterator.next();
                
                if (
                    c.getMovingBehavior().getCurrentPosition().distanceTo(towerPosition.getCenterPosition()) 
                    <
                    closestCritter.getMovingBehavior().getCurrentPosition().distanceTo(towerPosition.getCenterPosition())
                ) {
                    closestCritter = c;
                }
            }
            return closestCritter;
        }
        
        return null;
    }
}
