package gamemodel.tower;

import java.util.Set;
import gamemodel.critter.*;

/**
 *This class initialize the second Tower(TowerB) and initialize it's characteristics.
 *TowerB extends Tower implements TowerShootingBehavior
 *
 *@author yongpinggao 
 *@since 2/4/16.
 *@version 1.0
 *@see {@link gamemodel.tower.Tower Tower}
 */
public class TowerB extends Tower implements TowerShootingBehavior {

    /**
     * Creates a tower of the selected level of the type TowerB.
     * @param level tower level
     */
    public TowerB(int level) {
        this.level = level;
        if (level <= super.level) {
            initTower();
            specification = "<html>" + this.getClass().getName() + "<br> Level: " + this.level + "<br> Good at attack fast critters</html>";
        }
    }


    /**
    *  Initialize the tower specification base on tower level.   
    */
    private void initTower() {
        switch (level) {
            case 1:
                buyPrice = 30.0;
                sellPrice = 15.0;
                tid = TowerId.TOWERB1;
                range = 80;
                rateOfFire = 200;
                power = 20;
                break;
            case 2:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerId.TOWERB2;
                range = 90;
                rateOfFire = 300;
                power = 30;
                break;
            case 3:
                buyPrice = 50.0;
                sellPrice = 25.0;
                tid = TowerId.TOWERB3;
                range = 100;
                rateOfFire = 400;
                power = 40;
                break;
            default:
                buyPrice = 0;
                sellPrice = 0;
                tid = TowerId.TOWERNULL;
                range = 0;
                rateOfFire = 0;
        }
    }
    
    /** 
     * Overrides method shoot.
     * {@inheritDoc}
     */
    @Override
    public Critter shoot() {
        if (this.isPowerOn()) { //if tower is working instead of in the middle of shooting )
            //target can be changed based on different option
            Critter c = this.targetBasedOnWeakest(this.getCrittersInRange());
            c.getHitBy(this);
            this.setPowerOn(false);
            return c;
        } else {
            return null;
        }
    }

    /**
     *{@inheritDoc} 
     */
    @Override
    public Critter targetBasedOnWeakest(Set<Critter> crittersInRange) {
        return super.targetBasedOnWeakest(crittersInRange);
    }
    
    /**
    *{@inheritDoc} 
    */
    @Override
    public Critter targetBasedOnStrongest(Set<Critter> crittersInRange) {
        return super.targetBasedOnStrongest(crittersInRange);
    }
    
    /**
    *{@inheritDoc} 
    */
    @Override
    public Critter targetBasedOnNearestToEnd(Set<Critter> crittersInRange) {
        return super.targetBasedOnNearestToEnd(crittersInRange);
    }
}
