package model.critter;

/**
 * Critter B class
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class CritterB extends Critter {

    public CritterB() {
        initCritter();
    }
    
    /**
     * critter initialization
     */
    private void initCritter() {
        critterName = CritterName.CritterB;
        initialMoveSpeed = 15;
        maxHealth = 60;
        worth = 30;
        currentHealth = maxHealth;
        currentMoveSpeed = initialMoveSpeed;
    }
}
