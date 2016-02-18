package gamemodel.wave;

import gamemodel.critter.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class responsible for building wave of each critter type. 
 * 
 * The critter wave are launched by timer.
 *  
 * @author yongpinggao 
 * @since 2/6/16
 * @version 1.0
 * @see ActionListener
 */
public class Wave implements ActionListener{

    private Timer generateCritterTimer;
    private int index;
    private WaveStartListener listener;
    
    /**
     * Constructor will set the timer and start it.
     * @param builder Builder object from the Gson package
     * @see GsonBuilder
     */
    private Wave(Builder builder) {
 

        generateCritterTimer = new Timer(1000, this);
        generateCritterTimer.start();
        index = 0;
    }

/**
 *build a critter wave of each type and store it in CritterStore.
 *
 *@author Mansour  
 */
    public static class Builder {
 
        /**
         * Spawns 'num' number of critters of type A.
         * @param num number of critters
         * @return Builder class
         */
        public Builder critterA(int num) {
            for (int i = 0; i < num; i++) {
                CritterA critterA = new CritterA();
                CritterStore.critters.add(critterA);
            }
            return this;
        }
        
        /**
         * Spawns 'num' number of critters of type B.
         * @param num number of critters
         * @return Builder class
         */
        public Builder critterB(int num) {
            for (int i = 0; i < num; i++) {
                CritterB critterB = new CritterB();
                CritterStore.critters.add(critterB);
            }
            return this;
        }
        
        /**
         * Spawns 'num' number of critters of type C.
         * @param num number of critters
         * @return Builder class
         */
        public Builder critterC(int num) {
            for (int i = 0; i < num; i++) {
                CritterC critterC = new CritterC();
                CritterStore.critters.add(critterC);
            }
            return this;
        }
        
        /**
         * Spawns 'num' number of critters of type D.
         * @param num number of critters
         * @return Builder class
         */
        public Builder critterD(int num) {
            for (int i = 0; i < num; i++) {
                CritterD critterD = new CritterD();
                CritterStore.critters.add(critterD);
            }
            return this;
        }
        
        /**
         * builder method to return the new Wave.
         * @return Wave object
         */
        public Wave build() {
            return new Wave(this);
        }

    }
    
    /**
     * Adds a listener to when the wave start.
     * @param listener WaveStartListener 
     */
    public void addWaveStartListener(WaveStartListener listener) {
        this.listener = listener;
    }
    
    /**
     * Initialize the wave base on timer.
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (index <= CritterStore.critters.size()) {
            listener.initCritterPos(CritterStore.critters.get(index));
            index ++;
            if (index >= CritterStore.critters.size()) generateCritterTimer.stop();
        }

    }
}
