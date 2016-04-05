package model.wave;

import model.critter.*;
import view.critter.CritterType;


/**
 * Created by yongpinggao on 3/13/16.
 */
public class WaveBuilder {

	private int waveNum;
	private final int  icreacingSpeedRation = 2;
	private final int  increasingHealthRation = 4;
    private CritterCollection critterCollection = new CritterCollection();

    public WaveBuilder(int waveNum) {
    	this.waveNum = waveNum;
        if (critterCollection != null) critterCollection.clearAllCritters();
    }
    public WaveBuilder critterA(int num) {

        for (int i = 0; i < num; ++i) {
            Critter critter = new Critter(CritterType.CritterA);
            if (waveNum > 1 && waveNum <= 6 ) {
            	critter.setCurrentHealth(critter.getCurrentHealth() + (waveNum *increasingHealthRation));
            	critter.setMovingSpeed(critter.getMovingSpeed()+ waveNum + icreacingSpeedRation);
            }
            critterCollection.addCritter(critter);
        }
        return this;
    }

    public WaveBuilder critterB(int num) {
        for (int i = 0; i < num; ++i) {
            Critter critter = new Critter(CritterType.CritterB);
            if (waveNum > 1 && waveNum <= 6 ) {
            	critter.setCurrentHealth(critter.getCurrentHealth() + (waveNum *increasingHealthRation));
            	critter.setMovingSpeed(critter.getMovingSpeed()+ waveNum + icreacingSpeedRation);
            }
            critterCollection.addCritter(critter);
        }
        return this;
    }

    public WaveBuilder critterC(int num) {
        for (int i = 0; i < num; ++i) {
            Critter critter = new Critter(CritterType.CritterC);
            if (waveNum > 1 && waveNum <= 6 ) {
            	critter.setCurrentHealth(critter.getCurrentHealth() + (waveNum *increasingHealthRation));
            	critter.setMovingSpeed(critter.getMovingSpeed()+ waveNum + icreacingSpeedRation);
            }
            critterCollection.addCritter(critter);
        }
        return this;
    }

    public WaveBuilder critterD(int num) {
        for (int i = 0; i < num; ++i) {
            Critter critter = new Critter(CritterType.CritterD);
            if (waveNum > 1 && waveNum <= 6 ) {
            	critter.setCurrentHealth(critter.getCurrentHealth() + (waveNum *increasingHealthRation));
            	critter.setMovingSpeed(critter.getMovingSpeed()+ waveNum + icreacingSpeedRation);
            }
            critterCollection.addCritter(critter);
        }
        return this;
    }

    public CritterCollection getCritterCollection() {
        return critterCollection;
    }
}