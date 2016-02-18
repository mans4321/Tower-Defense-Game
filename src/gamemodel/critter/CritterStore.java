package gamemodel.critter;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Story  critters in CopyOnWriteArrayList(see link) to start waves.
 *  
 *@author yongpinggao 
 *@since 2/6/16.
 *@version 1.0
 *@see {@link <a href="http://google.com">CopyOnWriteArrayList</a> }
 */
public class CritterStore {

    // Java Collection classes are fail-fast which means that if the Collection will be changed
    // while some thread is traversing over it using iterator, the iterator.next() will throw a ConcurrentModificationException.
    // That's why we use CopyOnWriteArrayList (when game over, critters should stop moving and be cleaned)
    // JDK 1.5 minimum
    public static CopyOnWriteArrayList<Critter> critters = new CopyOnWriteArrayList<>();
}
