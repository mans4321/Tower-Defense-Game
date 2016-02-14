package gamemodel.wave;
import javax.swing.*;

import gamemodel.critter.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yongpinggao on 2/6/16.
 */
public class Wave implements ActionListener{

    private Timer generateCritterTimer;
    private int index;
    private WaveStartListener listener;

 



    private Wave(Builder builder){
 

        generateCritterTimer = new Timer(1000, this);
        generateCritterTimer.start();
        index = 0;
    }


    public static class Builder {
 

        public Builder critterA(int num) {
            for (int i = 0; i < num; i++) {
                CritterA critterA = new CritterA();
                CritterStore.critters.add(critterA);
            }
            return this;
        }

        public Builder critterB(int num) {
            for (int i = 0; i < num; i++) {
                CritterB critterB = new CritterB();
                CritterStore.critters.add(critterB);
            }
            return this;
        }

        public Builder critterC(int num) {
            for (int i = 0; i < num; i++) {
                CritterC critterC = new CritterC();
                CritterStore.critters.add(critterC);
            }
            return this;
        }

        public Builder critterD(int num) {
            for (int i = 0; i < num; i++) {
                CritterD critterD = new CritterD();
                CritterStore.critters.add(critterD);
            }
            return this;
        }

        public Wave build() {
            return new Wave(this);
        }

    }

    public void addWaveStartListener(WaveStartListener listener){
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(index <= CritterStore.critters.size()){
            listener.initCritterPos(CritterStore.critters.get(index));
            index ++;
            if(index >= CritterStore.critters.size()) generateCritterTimer.stop();
        }

    }
}
