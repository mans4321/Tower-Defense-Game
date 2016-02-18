package gamemodel.tower;

import java.util.Set;

import gamemodel.critter.*;

/**
 * An interface responsible for tower shooting behavior.
 * For example ,which critter tower should shoot weakest,strongest,or Nearest To exist point   
 *
 * @see TowerA,TowerB,and Towerc.
 * @author yongpinggao .
 * @version 1.0
 *@since  2/7/16
 * 
 */
public interface TowerShootingBehavior {
/**
 * 
 *
 */
    public Critter shoot();
/**
 * Shooting the Weakest critter in the set
 * 
 * @param crittersInRange a set of the critter in the tower range
 * 
 */
    Critter targetBasedOnWeakest(Set<Critter> crittersInRange);
/**
 * Shooting the strongest critter in the set
 * 
 * @param crittersInRange a set of the critter in the tower range
 * 
 */
    Critter targetBasedOnStrongest(Set<Critter> crittersInRange);
/**
 * Shooting critter nearest To exist point in the set
 * 
 * @param crittersInRange a set of the critter in the tower range
 * 
 */
    Critter targetBasedOnNearestToEnd(Set<Critter> crittersInRange);
}
