package gamemodel.critter;
/**
 *This class initialize the third Critter(CritterC) and set it's characteristics.
 *
 * CritterC extend the class Critter
 * 
 * @author yongpinggao
 * @since 28/2/16
 * @version 1.0
 * @see {@link gamemodel.critter.Critter Critter}
 */
public class CritterC extends Critter{
/**
* A constructor ;
*/
    public CritterC() {
        initCritter();
    }
/**
*  constructor calls the method initCritter() to initialize the critter parameters .
*/
    private void initCritter() {
        imgURL = "res/critterC.png";
        moveSpeed = 10;
        initHealth = 20;
        health = initHealth;
        worth = 40;
    }
}
