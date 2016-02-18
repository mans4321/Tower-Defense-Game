package gamemodel.critter;
/**
 * Created by yongpinggao on 2/2/16.
 */
public class CritterA extends Critter {


    public CritterA(){
        initCritter();
    }

    private void initCritter(){
        imgURL = "res/critterA.png";
        moveSpeed = 5;
        initHealth = 30;
        health = initHealth;
        worth = 20;

    }





}
