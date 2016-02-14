package gamemodel.critter;
/**
 * Created by yongpinggao on 2/6/16.
 */
public class CritterB extends Critter {

    public CritterB() {
        initCritter();
    }

    private void initCritter() {
        imgURL = "res/critterB.png";
        moveSpeed = 15;
        initHealth = 10;
        health = initHealth;
        worth = 30;
    }

}