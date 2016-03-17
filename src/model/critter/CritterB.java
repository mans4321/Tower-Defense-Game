package model.critter;

/**
 * Critter B class
 * @author yongpinggao
 */
public class CritterB extends Critter {

    public CritterB(){
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
