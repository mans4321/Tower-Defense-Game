package gamemodel.tower;

/**
 * Created by yongpinggao on 2/2/16.
 */
public interface PlaceTowerFinishedListener {
    void accountShouldChange(TowerID id);
    void placeTowerFinished(int index);
}
