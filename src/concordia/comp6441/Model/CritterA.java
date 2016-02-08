package concordia.comp6441.Model;
/**
 * Created by yongpinggao on 2/2/16.
 */
public class CritterA extends Critter {

    // set the critterA's initial position.
    public CritterA(int posX, int posY){
        imgURL = "res/critterA_1.png";
        this.posX = posX;
        this.posY = posY;

        this.isVisible = true;

        moveSpeed = 5;
    }

}
