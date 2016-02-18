package gamemodel.critter;
/**
 *This class initialize the third Critter(CritterC) and set it's characteristics.
 *
 * CritterB extend the class Critter
 * @author yongpinggao
 */
public class CritterC extends Critter{
/**
* A constructor calls the method initCritter();
*/
    public CritterC() {
        initCritter();
    }
/**
* initialize the characteristics of the CritterC
*/
    private void initCritter() {
        imgURL = "res/critterC.png";
        moveSpeed = 10;
        initHealth = 20;
        health = initHealth;
        worth = 40;
    }
}
