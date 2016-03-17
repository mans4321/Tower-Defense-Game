package model.critter;

/**
 * Critter D class
 * @author yongpinggao
  * @since 3/16/16.
 * @version 2.0 
 */
public class CritterD extends Critter {

    public CritterD(){
        initCritter();
    }

    /**
     * critter initialization
     */
    private void initCritter(){
        critterName = CritterName.CritterD;
        initialMoveSpeed = 5;
        maxHealth = 400;
        worth = 50;
        currentHealth = maxHealth;
        currentMoveSpeed = initialMoveSpeed;
    }
}
