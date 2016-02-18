package gamemodel.critter;
/**
 *This class initialize the first Critter(CritterA) and set it's characteristics.
 *
 * CritterA extend the class Critter
 * @author yongpinggao
 */
public class CritterA extends Critter {

/**
 * A constructor calls the method initCritter();
 */
    public CritterA() {
        initCritter();
    }
/**
 * initialize the characteristics of the CritterA
 */
    private void initCritter() {
        imgURL = "res/critterA.png";
        moveSpeed = 5;
        initHealth = 30;
        health = initHealth;
        worth = 20;

    }





}
