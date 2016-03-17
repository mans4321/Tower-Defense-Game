package protocol;

/**
 * interface for drawing data panel
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public interface DrawingDataPanelDelegate {
    void reloadWaveDataView (int waveNum);
    void reloadBalanceDataView(double balance);
    void reloadCoinDataView(int coin);
    void reloadInfoDataView(String info);
}
