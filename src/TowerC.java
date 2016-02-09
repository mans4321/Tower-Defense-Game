


/**
 * Created by yongpinggao on 2/2/16.
 */
public class TowerC extends Tower {
    private int level;

    public TowerC(int level){
        this.level = level;
        if(level <= super.level)
            initTower();
    }

    private void initTower(){
        switch(level){
            case 1:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerID.TOWERA1;
                break;
            case 2:
                buyPrice = 50.0;
                sellPrice = 25.0;
                tid = TowerID.TOWERA2;
                break;
            case 3:
                buyPrice = 60.0;
                sellPrice = 30.0;
                tid = TowerID.TOWERA3;
                break;
            default:
                buyPrice = 0;
                sellPrice = 0;
                tid = TowerID.TOWERNULL;
        }
    }
}
