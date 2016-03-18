package model.tower;

import model.critter.Critter;
import model.drawing.Drawing;
import model.tower.shootingstrategy.*;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;

/**
 * A model that define the all tower parameters.
 * Tower class implements TowerShootingBehavior and  ActionListener
 * @author yongpinggao
 * @see TowerShootingBehavior 
 * @since 3/16/16.
 * @version 2.0  
 */
public class Tower implements ShootingBehavior, DrawingShootingEffect {

    public final static int MAX_LEVEL = 3;

    int level;
    TowerName towerName;
    TowerName highResolutionTowerImageName;

    // tower normal attributes
    double buyPrice;
    double sellPrice;
    String specification;
    boolean powerOn;

    int positionX;
    int positionY;

    // tower shooting attributes
    int range;
    int power;
    int rateOfFire;

    protected Set<Critter> crittersInRange;
    protected Critter critterUnderAttack;
    protected Ellipse2D towerRangeCircle;
    protected BasicStroke shootingEffect;
    protected TowerShootingStrategy shootingStrategy;
    /**
     * A constructor to assign tower parameters.
     */
    public Tower() {
        crittersInRange = new HashSet<>();
        shootingEffect = new BasicStroke();
    }
    /**
     * Get the tower bounder.
     * @return the tower bounder
     */
    public Rectangle getBound() {
        return towerRangeCircle.getBounds();
    }
    /**
     * Set the position of tower
     * @param pos to store specific tower position
     */
    public void setPosition(int[] pos) {
        positionX = pos[0];
        positionY = pos[1];
        towerRangeCircle = new Ellipse2D.Float(
            positionX + Drawing.CELL_SIZE / 2 - range / 2, 
            positionY + Drawing.CELL_SIZE  / 2 - range / 2, 
            range, 
            range
        );
    }
    /**
     * Get tower X coordinate.
     * @return tower X coordinate
     */
    public int getPositionX() {
        return positionX;
    }
    /**
     * Get tower Y coordinate.
     * @return tower Y coordinate
     */
    public int getPositionY() {
        return positionY;
    }
    /**
     * Get the range of TowerCircle
     * @return towerRangeCircle
     */
    public Ellipse2D getTowerRangeCircle() {
        return towerRangeCircle;
    }
    /**
     * Set the range of TowerCircle
     * @param towerRangeCircle represents the range of tower circle
     */
    public void setTowerRangeCircle(Ellipse2D towerRangeCircle) {
        this.towerRangeCircle = towerRangeCircle;
    }
    /**
     * Get effect of shooting
     * @return shootingEffect
     */
    public BasicStroke getShootingEffect() {
        return shootingEffect;
    }
    /**
     * Set effect of shooting
     * @param shootingEffect represents the effect when tower shoots
     */
    public void setShootingEffect(BasicStroke shootingEffect) {
        this.shootingEffect = shootingEffect;
    }
    /**
     * Get the specific strategy for tower when tower shoots
     * @return shootingStrategy
     */
    public TowerShootingStrategy getShootingStrategy() {
        return shootingStrategy;
    }
    /**
     * Set the specific strategy for various towers when they shoot
     * @param shootingStrategy represents different shooting strategy
     */
    public void setShootingStrategy(TowerShootingStrategy shootingStrategy) {
        this.shootingStrategy = shootingStrategy;
    }
    /**
     * Get the Critters in the tower range.
     * @return Critters under attacking
     */
    public Critter getCritterUnderAttack() {
        return critterUnderAttack;
    }
    /**
     * Set the Critters list in the tower range.
     * @param critterUnderAttack represents critters who under tower range
     */
    public void setCritterUnderAttack(Critter critterUnderAttack) {
        this.critterUnderAttack = critterUnderAttack;
    }
    /**
     * Get the name of tower
     * @return towerName
     */
    public TowerName getTowerName() {
        return towerName;
    }
    /**
     * Set tower name
     * @param towerName represent tower name
     */
    public void setTowerName(TowerName towerName) {
        this.towerName = towerName;
    }
    /**
     * get price to buy the tower.
     * @return price to buy the tower
     */
    public double getBuyPrice() {
        return buyPrice;
    }
    /**
     * Set the price of tower
     * @param buyPrice the price of tower
     */
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
    /**
     * Get tower sell price.
     * @return sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }
    /**
     * Set tower sell price
     * @param sellPrice represent the price when sell a tower
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    /**
     * Get tower specification.
     * @return tower specification
     */
    public String getSpecification() {
        return specification;
    }
    /**
     * Set tower specification
     * @param specification represents tower specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }
    /**
     * get tower range.
     * @return tower range
     */
    public int getRange() {
        return range;
    }
    /**
     * Set tower range
     * @param range represents tower range
     */
    public void setRange(int range) {
        this.range = range;
    }
    /**
     * Get tower fire power.
     * @return tower fire power
     */
    public int getPower() {
        return power;
    }
    /**
     * Set tower fire power
     * @param power represents fire power
     */
    public void setPower(int power) {
        this.power = power;
    }
    /**
     * Get rate of Fire
     * @return rateOf Fire
     */
    public int getRateOfFire() {
        return rateOfFire;
    }
    /**
     * Set rate of fire
     * @param rateOfFire represents rate of fire
     */
    public void setRateOfFire(int rateOfFire) {
        this.rateOfFire = rateOfFire;
    }
    /**
     * Get tower name of high resolution
     * @return highResolutionTowerImageName
     */
    public TowerName getHighResolutionTowerImageName() {
        return highResolutionTowerImageName;
    }
    /**
     * Set tower name of high resolution
     * @param highResolutionTowerImageName represents tower name of high resolution
     */
    public void setHighResolutionTowerImageName(TowerName highResolutionTowerImageName) {
        this.highResolutionTowerImageName = highResolutionTowerImageName;
    }
    /**
     * get tower level.
     * @return tower level
     */
    public int getLevel() {
        return level;
    }
    /**
     * Set tower level
     * @param level represents tower level
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Get critters who in tower range
     * @return crittersInRange
     */
    public Set<Critter> getCrittersInRange() {
        return crittersInRange;
    }
    /**
     * Overrides shoot
     * {@inheritDoc}
     */
    @Override
    public void shoot() {}
    /**
     * Overrides drawShootingEffect
     * {@inheritDoc}
     */
    @Override
    public void drawShootingEffect(Graphics g) {}
}
