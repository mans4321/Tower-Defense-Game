package model.critter;

/**
 * Critter C class
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class CritterC extends  Critter {

    public CritterC() {
        initCritter();
    }

    /**
     * critter initialization
     */
    private void initCritter() {
        critterName = CritterName.CritterC;
        initialMoveSpeed = 10;
        maxHealth = 100;
        worth = 20;
        currentHealth = maxHealth;
        currentMoveSpeed = initialMoveSpeed;
    }
}
