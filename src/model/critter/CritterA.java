package model.critter;

/**
 * Critter A class
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class CritterA extends Critter {

    public CritterA(){
        initCritter();
    }

    /**
     * critter initialization
     */
    private void initCritter() {
        critterName = CritterName.CritterA;
        initialMoveSpeed = 5;
        maxHealth = 100;
        worth = 20;
        currentHealth = maxHealth;
        currentMoveSpeed = initialMoveSpeed;
    }
}
