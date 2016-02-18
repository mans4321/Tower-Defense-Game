package gamemodel.critter;
/**
 * Created by yongpinggao on 2/6/16.
 */
public class CritterD extends Critter {

    public CritterD() {
        initCritter();
    }

    private void initCritter() {
        imgURL = "res/critterD.png";
        moveSpeed = 5;
        initHealth = 40;
        health = initHealth;
        worth = 50;
    }
}
