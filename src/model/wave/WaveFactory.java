package model.wave;
/**
 * WaveFactory class to create waves
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0  
 */
public class WaveFactory {

    private static WaveFactory ourInstance = new WaveFactory();

    public static final int MAX_WAVE_NUM = 6;
    /**
     * Use shared instance
     * @return ourInstance
     */
    public static WaveFactory sharedInstance() {
        return ourInstance;
    }
    /**
     * Constructor of WaveFactory
     */
    private WaveFactory() {}
    /**
     * Get wave by using wave number
     * @param waveNum the number of wave
     * @return groups of critters
     */
    public Wave getWave(int waveNum) {
        switch (waveNum) {
            case 1:
                return new Wave.Builder().critterA(2).build();
            case 2:
                return new Wave.Builder().critterA(4).critterB(5).critterC(6).build();
            case 3:
                return new Wave.Builder().critterA(3).critterB(10).critterC(8).critterD(8).build();
            case 4:
                return new Wave.Builder().critterA(11).critterB(10).critterC(8).critterD(8).build();
            case 5:
                return new Wave.Builder().critterA(13).critterB(10).critterC(8).critterD(8).build();
            case 6:
                return new Wave.Builder().critterA(15).critterB(20).critterC(12).critterD(13).build();
            default:
                return null;
        }
    }
}
