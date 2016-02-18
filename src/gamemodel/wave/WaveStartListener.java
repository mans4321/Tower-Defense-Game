package gamemodel.wave;

import gamemodel.critter.Critter;

/**
 * Interface for the Wave listener.
 * @author yongpinggao
 * @since 2/7/16
 */
public interface WaveStartListener {
    
    /**
     * Method that will implement the start position of the critters
     * @see Critter
     * @param c Critter
     */
    void initCritterPos(Critter c);
}
