package model.tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * A model that define the all NormalTower parameters.
 * NormalTowerclass extends Tower, implements ShootingBehavior and DrawingShootingEffect
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0  
 */
public class NormalTower extends Tower implements ShootingBehavior, DrawingShootingEffect {

    protected Timer shootTimer;
    int slowDownMoveSpeed;
    int slowDownTime;
    /**
     * Constructor of NormalTower
     * @param level using different level to change properties of NormalTower
     */
    public NormalTower(int level){
        if(level <= MAX_LEVEL) {
            crittersInRange = new HashSet<>();
            highResolutionTowerImageName = TowerName.TowerAH;
            this.level = level;
            shootingEffect = ShootingEffect.getStoke(ShootingEffect.NormalEffect);
            initTower();
            shootTimer = new Timer(1000 - rateOfFire, new ActionListener() {
            	 /**
                 * Overrides actionPerformed
                 * {@inheritDoc}
                 */
            	@Override
                public void actionPerformed(ActionEvent e) {
                    powerOn = true;
                    shoot();
                }
            });
            shootTimer.start();
        }
    }
    /**
     * Using various level to set properties of towers
     */
    private void initTower(){
        specification = "<html>" + "Normal Tower" + "<br> Level: " + level + "<br> Good at attack normal creature</html>";
        switch(level){
            case 1:
                buyPrice = 20.0;
                sellPrice = 10.0;
                towerName = TowerName.TowerA1;
                range = 80;
                rateOfFire = 100;
                slowDownMoveSpeed = 2;
                slowDownTime = 2000;
                power = 30;
                break;
            case 2:
                buyPrice = 30.0;
                sellPrice = 15.0;
                towerName = TowerName.TowerA2;
                range = 90;
                rateOfFire = 200;
                slowDownMoveSpeed = 3;
                slowDownTime = 3000;
                power = 40;
                break;
            case 3:
                buyPrice = 40.0;
                sellPrice = 20.0;
                towerName = TowerName.TowerA3;
                range = 100;
                rateOfFire = 300;
                slowDownMoveSpeed = 4;
                slowDownTime = 4000;
                power = 50;
                break;
            default:
                towerName = TowerName.TowerNull;
                break;
        }
    }
    /**
     * Overrides getLevel
     * {@inheritDoc}
     */
    @Override
    public int getLevel() {
        return level;
    }
    /**
     * Overrides setLevel
     * {@inheritDoc}
     */
    @Override
    public void setLevel(int level) {
        this.level = level;
        initTower();
        setPosition(new int[]{positionX, positionY});
    }
    /**
     * Overrides shoot
     * {@inheritDoc}
     */
    @Override
    public void shoot() {
        super.shoot();
        critterUnderAttack = shootingStrategy.targetOnCritters(crittersInRange);
        if(critterUnderAttack != null && powerOn&& critterUnderAttack.getCurrentMoveSpeed() == critterUnderAttack.getInitialMoveSpeed()) { //if critter is get attacked(a line is drawn)
        	critterUnderAttack.setCurrentMoveSpeed(critterUnderAttack.getCurrentMoveSpeed() - slowDownMoveSpeed);
        	
        	Timer slowDownTimer = new Timer(slowDownTime, critterUnderAttack);
        	slowDownTimer.setInitialDelay(slowDownTime);
        	slowDownTimer.setRepeats(false);
            critterUnderAttack.setMovingTimer(slowDownTimer);
            critterUnderAttack.getMovingTimer().start();
            
            
        	int health = critterUnderAttack.getCurrentHealth();
            health -= power;
            critterUnderAttack.setCurrentHealth(health);
            if(health <= 0) {
                crittersInRange.remove(critterUnderAttack);
            }
        } else critterUnderAttack = null;
    }
    /**
     * Overrides drawShootingEffec
     * {@inheritDoc}
     */
    @Override
    public void drawShootingEffect(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(this.getShootingEffect());
        if(critterUnderAttack != null && powerOn && !critterUnderAttack.isKilled()){
            g2d.drawLine(positionX + CELL_SIZE / 2, positionY + CELL_SIZE / 2,
                    critterUnderAttack.getCurrentPosX() + CELL_SIZE / 2, critterUnderAttack.getCurrentPosY() + CELL_SIZE / 2);
            powerOn = false;
        }
        g2d.dispose();
    }
}
