package gamemodel.tower;

import javax.swing.*;

import gamemodel.critter.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yongpinggao on 2/4/16.
 */
public class Tower implements TowerShootingBehavior, ActionListener{

    public static final int LEVEL = 3;

    protected int level;
    protected TowerID tid;

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

    public Tower(){

        powerOn = false;
        delay = 1000 - rateOfFire;
        crittersInRange = new HashSet<>();
        shootTimer = new Timer(delay, this);

    }

    public Set<Critter> getCrittersInRange() {
        return crittersInRange;
    }

    public void setCrittersInRange(Set<Critter> crittersInRange) {
        this.crittersInRange = crittersInRange;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Rectangle getBounds(){
        return new Rectangle(posX - range/2, posY - range/2, range, range);
    }

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


    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        if(shooting){ // shooting -> timer start!
            shootTimer.start();
        } else { // not shooting -> timer stop
            shootTimer.stop();
            setPowerOn(false);
        }
        isShooting = shooting;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    @Override
    public Critter shoot() {
        return null;
    }

    @Override
    public Critter targetBasedOnWeakest(Set<Critter> crittersInRange) {
        if(crittersInRange.size() > 0){
            Iterator<Critter> iterator = crittersInRange.iterator();
            Critter weakestCritter = iterator.next();
            while(iterator.hasNext()){
                Critter c = iterator.next();
                if(c.getHealth() < weakestCritter.getHealth()){
                    weakestCritter = c;
                }
            }
            return weakestCritter;
        } else return null;
    }

    @Override
    public Critter targetBasedOnStrongest(Set<Critter> crittersInRange) {
        return null;
    }

    @Override
    public Critter targetBasedOnNearestToEnd(Set<Critter> crittersInRange) {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setPowerOn(true);
    }

    //TODO special effect...





}
