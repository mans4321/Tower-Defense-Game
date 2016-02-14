package gamemodel.tower;
import gamemodel.critter.*;

/**
 * Created by yongpinggao on 2/4/16.
 */
public class TowerA extends Tower implements TowerShootingBehavior{



    public TowerA(int level){


        this.level = level;
        if(level <= super.LEVEL){
            initTower();
            specification = "<html>" + this.getClass().getName() + "<br> Level: " + this.level + "<br> Good at attack normal creature</html>";
        }


    }

    private void initTower(){
        switch(level){
            case 1:
                buyPrice = 20.0;
                sellPrice = 10.0;
                tid = TowerID.TOWERA1;
                range = 80;
                rateOfFire = 100;
                power = 10;
                break;
            case 2:
                buyPrice = 30.0;
                sellPrice = 15.0;
                tid = TowerID.TOWERA2;
                range = 90;
                rateOfFire = 200;
                power = 20;
                break;
            case 3:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerID.TOWERA3;
                range = 100;
                rateOfFire = 300;
                power = 30;
                break;
            default:
                buyPrice = 0;
                sellPrice = 0;
                tid = TowerID.TOWERNULL;
                break;
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








    //TODO targetAt 3 difference condition...
}
