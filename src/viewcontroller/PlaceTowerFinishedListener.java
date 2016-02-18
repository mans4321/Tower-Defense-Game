package viewcontroller;
import gamemodel.tower.TowerId;

/**
 * Created by yongpinggao on 2/2/16.
 */
public interface PlaceTowerFinishedListener {
    void accountShouldChange(TowerId id);
    void placeTowerFinished(int index);
}
