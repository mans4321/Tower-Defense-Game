package gamemodel.wave;
import java.util.HashMap;

/**
 * Created by yongpinggao on 2/7/16.
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
