package model.tower;

import java.util.Set;

import javax.swing.Timer;

import com.google.gson.annotations.Expose;
import model.critter.Critter;
import model.tower.shootingstrategy.*;
import protocol.TowerDidShotDelegate;

/**
 * Created by yongpinggao on 3/19/16.
 */
public class TowerShootingBehavior {
    // tower shooting behavior
    protected int power;
    protected int rateOfFire;
    @Expose
    protected boolean isShooting;
    @Expose
    protected boolean timeToShoot;
    @Expose
    protected ShootingStrategyType shootingStrategyType = ShootingStrategyType.TargetBasedOnWeakest;
    protected Timer towerTimer;
    protected TowerShootingStrategy shootingStrategy = new TargetBasedOnWeakest();;

    protected Set<Critter> crittersInRange;
    protected TowerDidShotDelegate towerDidShotDelegate;

    public TowerShootingBehavior() {
        initTowerShootingStrategy();
    }

    private void initTowerShootingStrategy() {

        switch (shootingStrategyType) {
            case TargetBasedOnNearest:
                shootingStrategy = new TargetBasedOnNearest();
                break;
            case TargetBasedOnStrongest:
                shootingStrategy = new TargetBasedOnStrongest();
                break;
            case TargetBasedOnWeakest:
                shootingStrategy = new TargetBasedOnWeakest();
                break;
            case TargetBasedOnClosestToTower:
                shootingStrategy = new TargetBasedOnClosestToTower();
                break;
        }
    }

    public int getPower() {
        return power;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public Set<Critter> getCrittersInRange() {
        return crittersInRange;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public boolean isTimeToShoot() {
        return timeToShoot;
    }

    public void setTimeToShoot(boolean timeToShoot) {
        this.timeToShoot = timeToShoot;
    }

    public void setTowerDidShotDelegate(TowerDidShotDelegate towerDidShotDelegate) {
        this.towerDidShotDelegate = towerDidShotDelegate;
    }

    public ShootingStrategyType getShootingStrategyType() {
        return shootingStrategyType;
    }

    public void setShootingStrategyType(ShootingStrategyType shootingStrategyType) {
        this.shootingStrategyType = shootingStrategyType;
        initTowerShootingStrategy();
    }

    public void shoot() {}



}
