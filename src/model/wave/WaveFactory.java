package model.wave;

public class WaveFactory {

    private static WaveFactory ourInstance = new WaveFactory();

    public static final int MAX_WAVE_NUM = 6;

    public static WaveFactory sharedInstance() {
        return ourInstance;
    }

    private WaveFactory() {}

    public WaveBuilder getWave(int waveNum) {
        switch (waveNum) {
            case 1:
                return new WaveBuilder(waveNum).critterA(1).critterB(1).critterC(1);
            case 2:
                return new WaveBuilder(waveNum).critterA(3).critterB(2).critterC(1);
            case 3:
                return new WaveBuilder(waveNum).critterA(5).critterB(4).critterC(3).critterD(2);
            case 4:
                return new WaveBuilder(waveNum).critterA(6).critterB(7).critterC(9).critterD(10);
            case 5:
                return new WaveBuilder(waveNum).critterA(13).critterB(10).critterC(8).critterD(8);
            case 6:
                return new WaveBuilder(waveNum).critterA(15).critterB(20).critterC(12).critterD(13);
            default:
                return null;
        }
    }
}
