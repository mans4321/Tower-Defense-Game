import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 2/4/16.
 */
public abstract class Tower implements ActionListener {

    public final static int LEVEL = 3;

    protected int level;
    TowerID tid;


    Timer timer;

    // good at what, bad at what..
    String specification;

    double buyPrice;

    double sellPrice;

    //3,5...
    int range;

    // hit points damage to critter ++
    int power;

    // rate of produce missiles(timer) ++
    int rateOfFire;
    int delay;

    public String getSpecification() {
        return specification;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getRange() {
        return range;
    }

    public int getPower() {
        return power;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public int getLevel() {
        return level;
    }

    public TowerID getTid() {
        return tid;
    }

    //TODO special effect...


    abstract void shoot(int x, int y);
}
