package viewcontroller;
import gamemodel.tower.TowerID;

/**
 * Created by yongpinggao on 2/2/16.
 */
public interface PlaceTowerFinishedListener {
    void accountShouldChange(TowerID id);
    void placeTowerFinished(int index);
}
