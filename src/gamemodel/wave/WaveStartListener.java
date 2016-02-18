package gamemodel.wave;
import gamemodel.critter.Critter;

/**
 * Interface to start the critters wave.
 *   
 * @author yongpinggao 
 * @since 2/7/16.
 * @version 1.0
 */
public interface WaveStartListener {
/**
 * To initialize the critter wave 
 * 
 * @param c critter wave 
 */
    void initCritterPos(Critter c);
}
