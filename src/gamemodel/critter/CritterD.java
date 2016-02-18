package gamemodel.critter;
/**
 *This class initialize the fourth Critter(CritterD) and set it's characteristics.
 *
 * CritterC extend the class Critter
 * @author yongpinggao
 */
public class CritterD extends Critter {

/**
* A constructor calls the method initCritter();
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
