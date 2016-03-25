package model.wave;

import model.critter.*;
/**
 * Wave class to control every wave of critters
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0  
 */
public class Wave {
    private int index;
    
    private Wave(Wave.Builder builder) {
        index = 0;
    }
    /**
     * build various critters in wave
     * @author LiChong
     *
     */
    public static class Builder {
    	private int waveNum;
    	private static int increasingSpeed;
    	private static int increasingHealth;
        /**
         * Constructor of builder
         */
        public Builder(int waveNum) {
        	this.waveNum = waveNum;
        	increasingSpeed = waveNum + 2;
        	increasingHealth = waveNum + 5;
        }
        /**
         * Build critterA with specific number
         * @param num the number of critterA
         * @return critter wave 
         */
        public Wave.Builder critterA(int num) {
            for(int i = 0; i < num; ++i) {
                CritterA critterA = new CritterA();
               if(waveNum > 1 && waveNum <= 6 ){
            	   critterA.setCurrentMoveSpeed(critterA.getCurrentMoveSpeed()+ increasingSpeed);
            	   critterA.setCurrentHealth(critterA.getCurrentHealth()+ increasingHealth);
               }
                CritterCollection.addCritter(critterA);
            }
            return this;
        }
        /**
         * Build critterB with specific number
         * @param num the number of critterB
         * @return critter wave 
         */
        public Wave.Builder critterB(int num) {
            for (int i = 0; i < num; ++i) {
                CritterB critterB = new CritterB();
                if(waveNum > 1 && waveNum <= 6 ){
             	   critterB.setCurrentMoveSpeed(critterB.getCurrentMoveSpeed()+ increasingSpeed);
             	   critterB.setCurrentHealth(critterB.getCurrentHealth()+ increasingHealth);
                }
                CritterCollection.addCritter(critterB);
            }
            return this;
        }
        /**
         * Build critterC with specific number
         * @param num the number of critterC
         * @return critter wave 
         */
        public Wave.Builder critterC(int num) {
            for (int i = 0; i < num; ++i) {
                CritterC critterC = new CritterC();
                if(waveNum > 1 && waveNum <= 6 ){
             	   critterC.setCurrentMoveSpeed(critterC.getCurrentMoveSpeed()+ increasingSpeed);
             	   critterC.setCurrentHealth(critterC.getCurrentHealth()+ increasingHealth);
                }
                CritterCollection.addCritter(critterC);
            }
            return this;
        }
        
        /**
         * Build critter with specific number
         * @param num the number of critter
         * @return critter wave 
         */
        public Wave.Builder critterD(int num) {
            for (int i = 0; i < num; ++i) {
                CritterD critterD = new CritterD();
                if(waveNum > 1 && waveNum <= 6 ){
             	   critterD.setCurrentMoveSpeed(critterD.getCurrentMoveSpeed()+ increasingSpeed);
             	   critterD.setCurrentHealth(critterD.getCurrentHealth()+ increasingHealth);
                }
                CritterCollection.addCritter(critterD);
            }
            return this;
        }
        /**
         * build wave
         * @return wave 
         */
        public Wave build() {
            return new Wave(this);
        }
    }
}
