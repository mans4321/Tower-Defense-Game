package gamemodel.tower;

import gamemodel.critter.*;
 

/**
 *This class create the third Tower(TowerA) and initialize it's characteristics. 
 *TowerC extends Tower
 *
 *@author yongpinggao
 *@see {@link gamemodel.tower.Tower Tower} 
 *@since 2/4/16.
 *@version 1.0
 */
public class TowerC extends Tower {

    /**
     * Creates a tower of the selected level of the type TowerC.
     * @param level tower level
     */
    public TowerC(int level) {
        this.level = level;
        if (level <= super.level) {
            initTower();
            specification = "<html>" + this.getClass().getName() + "<br> Level: " + this.level + "<br>  Good at attack strong critters</html>";
        }
    }

    /**
    *  Initialize the tower specification base on tower level.
    */   
    private void initTower() {
        switch (level) {
            case 1:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerId.TOWERC1;
                range = 120;
                rateOfFire = 100;
                power = 40;
                break;
            case 2:
                buyPrice = 50.0;
                sellPrice = 25.0;
                tid = TowerId.TOWERC2;
                range = 130;
                rateOfFire = 200;
                power = 50;
                break;
            case 3:
                buyPrice = 60.0;
                sellPrice = 30.0;
                tid = TowerId.TOWERC3;
                range = 140;
                rateOfFire = 300;
                power = 60;
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
     *{@inheritDoc}
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
}
