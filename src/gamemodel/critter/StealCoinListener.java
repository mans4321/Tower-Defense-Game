package gamemodel.critter;
/**
 * 
 * Interface responsible for Compensate the player for the killed critter.
 *  
 *@author yongpinggao 
 *@since 2/7/16.
 *@version 1.0
 */
public interface StealCoinListener {
/**
 *  Compensate the player for the killed critter
 */
    void coinGotStolen();
/**
 * 
 * no critter left to Compensate the player for the killed critter. 
 */
    void noCritterLeft();
}
