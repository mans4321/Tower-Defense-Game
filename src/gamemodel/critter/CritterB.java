package gamemodel.critter;
/**
 *This class initialize the second Critter(CritterB) and set it's characteristics.
 *
 * CritterB extend the class Critter
 * @author yongpinggao
 */
public class CritterB extends Critter {
/**
* A constructor calls the method initCritter();
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