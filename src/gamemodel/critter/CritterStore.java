package gamemodel.critter;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yongpinggao on 2/6/16.
 */
public class CritterStore {

    // Java Collection classes are fail-fast which means that if the Collection will be changed
    // while some thread is traversing over it using iterator, the iterator.next() will throw a ConcurrentModificationException.
    // That's why we use CopyOnWriteArrayList (when game over, critters should stop moving and be cleaned)
    // JDK 1.5 minimum
    public static CopyOnWriteArrayList<Critter> critters = new CopyOnWriteArrayList<>();
}
