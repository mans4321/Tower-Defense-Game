package model.critter;

import com.google.gson.annotations.Expose;
import view.critter.CritterType;
import view.critter.CritterView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by yongpinggao on 3/13/16.
 */
public class Critter implements ActionListener{

    @Expose
    private CritterType critterType;
    private CritterView critterView;
    @Expose
    private CritterMovingBehavior movingBehavior;
    @Expose
    private int currentHealth;
    @Expose
    private int maxHealth;
    @Expose
    private double worth;
    @Expose
    private int movingSpeed;
    @Expose
    private boolean isVisible;
    @Expose
    private boolean isKilled;
    @Expose
    private boolean isDonated;

    private int damage;

    private Timer innerTimer;
    @Expose
    private Timer specicalEffectTimer = new Timer(0, null);;



    public boolean isDonated() {
        return isDonated;
    }

    public void setDonated(boolean donated) {
        isDonated = donated;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Critter(CritterType critterType) {
        this.critterType = critterType;
        this.critterView = new CritterView(critterType);

        switch (critterType) {
            case CritterA:
                initCritterA();
                break;
            case CritterB:
                initCritterB();
                break;
            case CritterC:
                initCritterC();
                break;
            case CritterD:
                initCritterD();
        }
    }

    private void initCritterA() {
        maxHealth = 100;
        currentHealth = maxHealth;
        worth = 20;
        movingSpeed = 20;
    }

    private void initCritterB() {
        maxHealth = 60;
        currentHealth = maxHealth;
        worth = 30;
        movingSpeed = 40;
    }

    private void initCritterC() {
        maxHealth = 200;
        currentHealth = maxHealth;
        worth = 40;
        movingSpeed = 10;
    }

    private void initCritterD() {
        maxHealth = 400;
        currentHealth = maxHealth;
        worth = 50;
        movingSpeed = 10;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
        if(killed) {
            movingBehavior.getMovingTimer().stop();
        }
    }

    public double getWorth() {
        return worth;
    }

    public float getHealthBarLength() {
        return (float)(currentHealth) / maxHealth;
    }

    public CritterMovingBehavior getMovingBehavior() {
        return movingBehavior;
    }

    public void setMovingBehavior(CritterMovingBehavior movingBehavior) {
        this.movingBehavior = movingBehavior;
    }

    public int getMovingSpeed() {
        return movingSpeed;
    }

    public void setMovingSpeed(int movingSpeed) {
        this.movingSpeed = movingSpeed;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
        if(isVisible()) movingBehavior.move();
    }

    public CritterView getCritterView() {
        return new CritterView(critterType);
    }

    public Timer getInnerTimer() {
        return innerTimer;
    }

    public void setInnerTimer(Timer innerTimer) {
        this.innerTimer = innerTimer;
    }

    public Timer getSpecicalEffectTimer() {
        return specicalEffectTimer;
    }

    public void setSpecicalEffectTimer(Timer specicalEffectTimer) {
        this.specicalEffectTimer = specicalEffectTimer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() != null) {
            if(e.getActionCommand().equals("ICE_TOWER")) {
                movingBehavior.getMovingTimer().start();
                specicalEffectTimer.stop();
            }
            if(e.getActionCommand().equals("BURNING_TOWER")) {
                specicalEffectTimer.stop();
                innerTimer.stop();
            }
        } else {
            currentHealth -= damage;
        }
    }
}

