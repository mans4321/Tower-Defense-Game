import javax.swing.*;

/**
 * Created by yongpinggao on 2/3/16.
 */
public class MissileA extends Missile {

    private int level;


    public MissileA(int level, int posX, int posY){
        this.level = level;
        this.posX = posX;
        this.posY = posY;



        if(level <= super.level){
            initMissle();
        }

    }



    private void initMissle() {
        switch(level){
            case 1:
                this.imageURL = "res/towerA_1_missile.png";
                speed = 5;
                break;
            case 2:
                this.imageURL = "res/towerA_1_missile.png";
                speed = 15;
                break;
            case 3:
                this.imageURL = "res/towerA_1_missile.png";
                speed = 25;
                break;
            default:

        }
    }

}
