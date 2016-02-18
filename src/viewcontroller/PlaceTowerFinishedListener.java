package viewcontroller;
import gamemodel.tower.TowerId;

/**
 * Interface for the tower placing listener
 * @author yongpinggao
 * @since 2/2/16
 */
public interface PlaceTowerFinishedListener {
    void accountShouldChange(TowerId id);
    void placeTowerFinished(int index);
}
