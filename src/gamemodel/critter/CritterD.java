package gamemodel.critter;
/**
 *This class initialize the fourth Critter(CritterD) and set it's characteristics.
 *
 * CritterD extend the class Critter
 * 
 * @author yongpinggao
 * @version 1.1
 * @since 28/1/16
 * @see {@link gamemodel.critter.Critter Critter}
 */
public class CritterD extends Critter {

/**
*  constructor calls the method initCritter() to initialize the critter parameters .
*/	
    public CritterD() {
        initCritter();
    }
/**
* initialize the characteristics of the CritterC
*/
    private void initCritter() {
        imgURL = "res/critterD.png";
        moveSpeed = 5;
        initHealth = 40;
        health = initHealth;
        worth = 50;
    }
}
