package concordia.comp6441.Model;
import java.awt.event.ActionEvent;

/**
 * Created by yongpinggao on 2/4/16.
 */
public class TowerB extends Tower{


    public TowerB(int level){
        this.level = level;
        if(level <= super.level){
            initTower();
            specification = "<html>" + this.getClass().getName() + "<br> Good at attack fast critters</html>";
        }
    }

    private void initTower(){
        switch(level){
            case 1:
                buyPrice = 30.0;
                sellPrice = 15.0;
                tid = TowerID.TOWERB1;
                break;
            case 2:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerID.TOWERB2;
                break;
            case 3:
                buyPrice = 50.0;
                sellPrice = 25.0;
                tid = TowerID.TOWERB3;
                break;
            default:
                buyPrice = 0;
                sellPrice = 0;
                tid = TowerID.TOWERNULL;
        }
    }


    @Override
    public void shoot(int x, int y) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
