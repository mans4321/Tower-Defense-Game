package gamemodel.critter;
/**
 * Created by yongpinggao on 2/6/16.
 */
public class CritterC extends Critter{

    public CritterC() {
        initCritter();
    }

    private void initCritter() {
        imgURL = "res/critterC.png";
        moveSpeed = 10;
        initHealth = 20;
        health = initHealth;
        worth = 40;
    }
}
