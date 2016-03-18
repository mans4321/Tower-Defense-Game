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
        /**
         * Constructor of builder
         */
        public Builder() {}
        /**
         * Build critterA with specific number
         * @param num the number of critterA
         * @return
         */
        public Wave.Builder critterA(int num) {
            for(int i = 0; i < num; ++i) {
                CritterA critterA = new CritterA();
                CritterCollection.addCritter(critterA);
            }
            return this;
        }
        /**
         * Build critterB with specific number
         * @param num the number of critterB
         * @return
         */
        public Wave.Builder critterB(int num) {
            for(int i = 0; i < num; ++i) {
                CritterB critterB = new CritterB();
                CritterCollection.addCritter(critterB);
            }
            return this;
        }
        /**
         * Build critterC with specific number
         * @param num the number of critterC
         * @return
         */
        public Wave.Builder critterC(int num) {
            for(int i = 0; i < num; ++i) {
                CritterC critterC = new CritterC();
                CritterCollection.addCritter(critterC);
            }
            return this;
        }
        /**
         * Build critters with specific number
         * @param num the number of critters
         * @return
         */
        public Wave.Builder critterD(int num) {
            for(int i = 0; i < num; ++i) {
                CritterD critterD = new CritterD();
                CritterCollection.addCritter(critterD);
            }
            return this;
        }
        /**
         * build wave
         * @return 
         */
        public Wave build() {
            return new Wave(this);
        }
    }
}
