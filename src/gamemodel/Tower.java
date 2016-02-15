package gamemodel;


/**
 * Created by yongpinggao on 1/30/16.
 */
public class Tower {


    public static final int level = 3;

    protected TowerID tid;

    // good at what, bad at what..
    protected String specification;

    protected double buyPrice;

    protected double sellPrice;

    //3,5...
    protected int range;

    // hit points damage to critter
    protected int power;

    // rate of produce missiles(timer)
    protected int rateOfFire;

    //TODO special effect...




    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public void setRateOfFire(int rateOfFire) {
        this.rateOfFire = rateOfFire;
    }
}
