package concordia.comp6441.Model;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 2/4/16.
 */
public class TowerA extends Tower{

    private int posX;
    private int posY;


    public TowerA(int level){

        this.level = level;
        if(level <= super.LEVEL){
            this.level = level;
            initTower();
            specification = "<html>" + this.getClass().getName() + "<br> Good at attack normal creature</html>";
            this.delay = 1000 - rateOfFire;
        }


    }

    private void initTower(){
        // init missiles
        missiles = new ArrayList<>();
        switch(level){
            case 1:
                buyPrice = 20.0;
                sellPrice = 10.0;
                tid = TowerID.TOWERA1;
                rateOfFire = 100;
                break;
            case 2:
                buyPrice = 30.0;
                sellPrice = 15.0;
                tid = TowerID.TOWERA2;
                rateOfFire = 200;
                break;
            case 3:
                buyPrice = 40.0;
                sellPrice = 20.0;
                tid = TowerID.TOWERA3;
                rateOfFire = 300;
                break;
            default:
                buyPrice = 0;
                sellPrice = 0;
                tid = TowerID.TOWERNULL;
                break;
        }
    }


    @Override
    public void shoot(int x, int y) {
        posX = x;
        posY = y;
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MissileA m = new MissileA(level, posX, posY);
        missiles.add(m);
    }
}
