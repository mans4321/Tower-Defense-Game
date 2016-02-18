package gamemodel.wave;
import javax.swing.*;

import gamemodel.critter.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class responsible for building wave of each critter type. 
 * 
 * The critter wave are launched by timer.
 *  
 *@author yongpinggao 
 *@since 2/6/16
 *@version 1.0
 */
public class Wave implements ActionListener{

    private Timer generateCritterTimer;
    private int index;
    private WaveStartListener listener;

 


/**
 * Constructor 
 * 
 * @param builder the critter wave  extracted from  CritterStore
 */
    private Wave(Builder builder){
 

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
 * build a wave of critterA
 * 
 * @param num number of critter 
 * @return critter wave 
 */
        public Builder critterA(int num) {
            for (int i = 0; i < num; i++) {
                CritterA critterA = new CritterA();
                CritterStore.critters.add(critterA);
            }
            return this;
        }
/**
 * build a wave of critterB
 * 
 * @param num number of critter 
 * @return critterB wave 
  */ 
        public Builder critterB(int num) {
            for (int i = 0; i < num; i++) {
                CritterB critterB = new CritterB();
                CritterStore.critters.add(critterB);
            }
            return this;
        }
/**
 * build a wave of critterC
 * 
 * @param num number of critter 
 * @return critterC wave 
 */
        public Builder critterC(int num) {
            for (int i = 0; i < num; i++) {
                CritterC critterC = new CritterC();
                CritterStore.critters.add(critterC);
            }
            return this;
        }
/**
 * build a wave of critterC
 * 
 * @param num number of critter 
 * @return critterC wave 
 */
        public Builder critterD(int num) {
            for (int i = 0; i < num; i++) {
                CritterD critterD = new CritterD();
                CritterStore.critters.add(critterD);
            }
            return this;
        }
/**
 * Constructor.
 * 
 * @return  critter wave 
 */
        public Wave build() {
            return new Wave(this);
        }

    }
/**
 * wave listener to start a wave     
 * @param listener   listener to add the wave 
 */
    public void addWaveStartListener(WaveStartListener listener){
        this.listener = listener;
    }
/**
 * Initialize the wave base on timer    
 */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(index <= CritterStore.critters.size()){
            listener.initCritterPos(CritterStore.critters.get(index));
            index ++;
            if(index >= CritterStore.critters.size()) generateCritterTimer.stop();
        }

    }
}
