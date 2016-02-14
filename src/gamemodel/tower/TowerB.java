package gamemodel.tower;
import java.util.Set;

import gamemodel.critter.*;

/**
 * Created by yongpinggao on 2/4/16.
 */
public class TowerB extends Tower implements TowerShootingBehavior{


    public TowerB(int level){
        this.level = level;
        if(level <= super.level){
            initTower();
            specification = "<html>" + this.getClass().getName() + "<br> Level: " + this.level + "<br> Good at attack fast critters</html>";
        }
    }



    private void initTower(){
        switch(level){
            case 1:
                buyPrice = 30.0;
                sellPrice = 15.0;
                tid = TowerID.TOWERB1;
                range = 80;
                rateOfFire = 200;
                power = 20;
                break;
            case 2:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerID.TOWERB2;
                range = 90;
                rateOfFire = 300;
                power = 30;
                break;
            case 3:
                buyPrice = 50.0;
                sellPrice = 25.0;
                tid = TowerID.TOWERB3;
                range = 100;
                rateOfFire = 400;
                power = 40;
                break;
            default:
                buyPrice = 0;
                sellPrice = 0;
                tid = TowerID.TOWERNULL;
                range = 0;
                rateOfFire = 0;
        }
    }

    @Override
    public Critter shoot() {
        if(this.isPowerOn()){ //if tower is working instead of in the middle of shooting )
            //target can be changed based on different option
            Critter c = this.targetBasedOnWeakest(this.getCrittersInRange());
            c.getHitBy(this);
            this.setPowerOn(false);
            return c;
        } else return null;
    }





    @Override
    public Critter targetBasedOnWeakest(Set<Critter> crittersInRange) {
        return super.targetBasedOnWeakest(crittersInRange);
    }

    @Override
    public Critter targetBasedOnStrongest(Set<Critter> crittersInRange) {
        return super.targetBasedOnStrongest(crittersInRange);
    }

    @Override
    public Critter targetBasedOnNearestToEnd(Set<Critter> crittersInRange) {
        return super.targetBasedOnNearestToEnd(crittersInRange);
    }
}