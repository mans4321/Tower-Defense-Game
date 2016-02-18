package gamemodel.wave;
import java.util.HashMap;

/**
 * Store Critter wave in hashmap .
 * 
 *The HashMap has tow type. the first Integer to hold wave number and
 *the second array type Integer contain the wave. 
 * 
 * @author yongpinggao 
 * @since 2/7/16.
 * @version 1.0
 * 
 */
public class WaveStore {


    public static HashMap<Integer, int[]> waves = new HashMap<>();

    static {
        // CritterA, CritterB, CritterC, CritterD
        waves.put(1, new int[]{5,1,0,0});
        waves.put(2, new int[]{6,2,2,2});
        waves.put(3, new int[]{7,3,3,3});
        waves.put(4, new int[]{8,4,4,4});
    }


}
