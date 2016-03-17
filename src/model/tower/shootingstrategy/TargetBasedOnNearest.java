package model.tower.shootingstrategy;

import model.critter.Critter;

import java.util.Iterator;
import java.util.Set;

/**
 * A specific strategy that define to target nearest critter.
 * TargetBasedOnNearest class implements TowerShootingStrategy
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0  
 */
public class TargetBasedOnNearest implements TowerShootingStrategy {
	 /**
     * Overrides targetOnCritters
     * {@inheritDoc}
     */
    @Override
    public Critter targetOnCritters(Set<Critter> crittersInRange) {
        if(crittersInRange.size() > 0){
            Iterator<Critter> iterator = crittersInRange.iterator();
            Critter nearestCritter = iterator.next();
            while(iterator.hasNext()){
                Critter c = iterator.next();
                if(c.getPathList().size() < nearestCritter.getPathList().size()){
                    nearestCritter = c;
                }
            }
            return nearestCritter;
        } else return null;
    }
}
