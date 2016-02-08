package concordia.comp6441.View;
import concordia.comp6441.Model.*;

/**
 * Created by yongpinggao on 2/2/16.
 */
public interface PlaceTowerFinishedListener {
    void accountShouldChange(TowerID id);
    void placeTowerFinished(int index);
}
