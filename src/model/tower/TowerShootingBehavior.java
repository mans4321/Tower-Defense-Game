package model.tower;

import java.util.Set;

import javax.swing.Timer;

import model.critter.Critter;
import model.tower.shootingstrategy.TargetBasedOnWeakest;
import model.tower.shootingstrategy.TowerShootingStrategy;
import protocol.TowerDidShotDelegate;
import view.map.Position;

/**
 * Created by yongpinggao on 3/19/16.
 */
public class TowerShootingBehavior {
    // tower shooting behavior
    protected int power;
    protected int rateOfFire;
    protected TowerShootingStrategy shootingStrategy = new TargetBasedOnWeakest();
    protected boolean isShooting;
    protected boolean timeToShoot;

    protected Timer towerTimer;

    protected Set<Critter> crittersInRange;

    protected TowerDidShotDelegate towerDidShotDelegate;
    private Position towerPosition;

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
        if(shooting) {
            towerTimer.start();
        } else {
            towerTimer.stop();
        }
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

    public TowerShootingStrategy getShootingStrategy() {
		return shootingStrategy;
	}

	public void setShootingStrategy(TowerShootingStrategy shootingStrategy) {
		this.shootingStrategy = shootingStrategy;
	}

	public void shoot() {}

    public void setTowerPosition(Position towerPosition) {
        this.towerPosition = towerPosition;
    }
    
    public Position getTowerPosition() {
        return this.towerPosition;
    }
}