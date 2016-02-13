package gamemodel.tower;

import java.util.Set;

import gamemodel.critter.*;

/**
 * Created by yongpinggao on 2/7/16.
 */
public interface TowerShootingBehavior {

    public Critter shoot();

    Critter targetBasedOnWeakest(Set<Critter> crittersInRange);

    Critter targetBasedOnStrongest(Set<Critter> crittersInRange);

    Critter targetBasedOnNearestToEnd(Set<Critter> crittersInRange);
}
