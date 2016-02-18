package gamemodel.critter;
/**
 *This class initialize the second Critter(CritterB) and set it's characteristics.
 *
 * CritterB extend the class Critter
 * 
 * @author yongpinggao
 * @version 1.0
 * @since 28/1/16
 * @see {@link gamemodel.critter.Critter Critter}
 */
public class CritterB extends Critter {
/**
* A constructor ;
*/
    public CritterB() {
        initCritter();
    }
/**
* initialize the characteristics of the CritterA
*/
    private void initCritter() {
        imgURL = "res/critterB.png";
        moveSpeed = 15;
        initHealth = 10;
        health = initHealth;
        worth = 30;
    }

}