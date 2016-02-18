package gamemodel.tower;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gamemodel.critter.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;

/**
 * A model that define the all tower parameters.
 * Tower class implements TowerShootingBehavior and  ActionListener
 * @author 
 * @see TowerShootingBehavior 
 * @since 2/4/16.
 * @version 1.0  
 */
public class Tower implements TowerShootingBehavior, ActionListener {

    public static final int LEVEL = 3;

    protected int level;
    protected TowerId tid;

    // center coordinate of the tower
    protected int posX;
    protected int posY;

    protected boolean isShooting;

    protected Set<Critter> crittersInRange;

    // good at what, bad at what..
    protected String specification;

    protected double buyPrice;

    protected double sellPrice;

    //3,5... radix
    protected int range;

    // hit points damage to critter ++
    protected int power;

    // rate of produce missiles(timer) ++
    protected int rateOfFire;
    protected int delay;

    protected Timer shootTimer;

    protected boolean powerOn;
    
    /**
     * A constuctor to assign tower parameters.
     */
    public Tower() {

        powerOn = false;
        delay = 1000 - rateOfFire;
        crittersInRange = new HashSet<>();
        shootTimer = new Timer(delay, this);

    }
    
    /**
     * Get the Critters in the tower range.
     * @return Critters in the tower range
     */
    public Set<Critter> getCrittersInRange() {
        return crittersInRange;
    }
    
    /**
     * Set the Critters list in the tower range.
     * @param crittersInRange a set the continue the 
     */
    public void setCrittersInRange(Set<Critter> crittersInRange) {
        this.crittersInRange = crittersInRange;
    }
    
    /**
     * get tower X coordinate.
     * @return tower X coordinate
     */
    public int getPosX() {
        return posX;
    }
    
    /**
     * set tower X coordinate.
     * @param posX tower X coordinate
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }
    
    /**
    * get tower Y coordinate.
    * @return tower Y coordinate
    */
    public int getPosY() {
        return posY;
    }
    
    /**
     * set tower Y coordinate.
     * @param posY tower Y coordinat
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    /**
     * get the tower bounder.
     * @return the tower bounder
     */
    public Rectangle getBounds() {
        return new Rectangle(posX - range / 2, posY - range / 2, range, range);     //what
    }
    
    /**
     * get tower specification.
     * @return tower specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * get price to buy the tower.
     * @return price to buy the tower
     */
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * get tower sell price.
     * @return price to buy the tower
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * get tower range.
     * @return tower range
     */
    public int getRange() {
        return range;
    }

    /**
     * get tower fire power.
     * @return tower fire power
     */
    public int getPower() {
        return power;
    }

    /**
     * get tower rate of fire.
     * @return tower rate of fire 
     */
    public int getRateOfFire() {
        return rateOfFire;
    }

    /**
     * get tower level.
     * @return tower level
     */
    public int getLevel() {
        return level;
    }

    /**
     * get tower id.
     * @return tower id
     */
    public TowerId getTid() {
        return tid;
    }

    /**
     * get tower Shooting Status.
     * @return tower Shooting Status
     */
    public boolean isShooting() {
        return isShooting;
    }

    /**
     * set tower Shooting Status.
     * @param shooting tower Shooting Status
     */
    public void setShooting(boolean shooting) {
        if (shooting) { // shooting -> timer start!
            shootTimer.start();
        } else { // not shooting -> timer stop
            shootTimer.stop();
            setPowerOn(false);
        }
        isShooting = shooting;
    }

    /**
     * stores the power on property.
     * @return powerOn property
     */
    public boolean isPowerOn() {
        return powerOn;
    }
    
    /**
     * setter method for power on.
     * @param powerOn property to define is tower power is on
     */
    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }
    
    /**
     * Overrides shoot method.
     * {@inheritDoc}
     */
    @Override
    public Critter shoot() {
        return null;
    }
    
    /**
     * Overrides targetBasedOnWeakest method.
     * {@inheritDoc} 
     */
    @Override
    public Critter targetBasedOnWeakest(Set<Critter> crittersInRange) {
        if (crittersInRange.size() > 0) {
            Iterator<Critter> iterator = crittersInRange.iterator();
            Critter weakestCritter = iterator.next();
            while (iterator.hasNext()) {
                Critter c = iterator.next();
                if (c.getHealth() < weakestCritter.getHealth()) {
                    weakestCritter = c;
                }
            }
            return weakestCritter;
        } else {
            return null;
        }
    }
    
    /**
     * Overrides method targetBasedOnStrongest
     * {@inheritDoc}
     */
    @Override
    public Critter targetBasedOnStrongest(Set<Critter> crittersInRange) {
        return null;
    }
    
    /**
     * Overrides targetBasedOnNearestToEnd
     * {@inheritDoc}
     */
    @Override
    public Critter targetBasedOnNearestToEnd(Set<Critter> crittersInRange) {
        return null;
    }
    
    /**
     * Overrides actionPerformed
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        setPowerOn(true);
    }

    //TODO special effect...





}
