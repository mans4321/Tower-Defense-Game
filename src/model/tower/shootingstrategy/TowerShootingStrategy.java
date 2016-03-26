package model.tower.shootingstrategy;

import model.critter.Critter;

import java.util.Set;

/**
 * An interface that define shooting strategy of tower
 * @author yongpinggao 
 * @since 3/16/16.
 * @version 2.0  
 */
public interface TowerShootingStrategy {

	/*
	 * a method for Tower shooting strategy
	 */
     Critter targetOnCritters(Set<Critter> crittersInRange);
}
