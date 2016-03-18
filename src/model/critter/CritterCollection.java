package model.critter;

import model.map.GameMap;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Critter collection: for collect all the critters for each wave
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class CritterCollection {
    // Java Collection classes are fail-fast which means that if the Collection will be changed
    // while some thread is traversing over it using iterator, the iterator.next() will throw a ConcurrentModificationException.
    // That's why we use CopyOnWriteArrayList (when game over, critters should stop moving and be cleaned)
    // JDK 1.5 minimum
    public static CopyOnWriteArrayList<Critter> critters = new CopyOnWriteArrayList<>();

    /**
     * add a critter to critter collection
     * @param critter
     */
    public static void addCritter(Critter critter) {
        critters.add(critter);
    }

    /**
     * remove a critter of critter collection
     * @param critter
     */
    public static void removeCritter(Critter critter) {
        critters.remove(critter);
    }

    /**
     * clear all the critters in critter collection
     */
    public static void clearAllCritters() {
        currentIndex = 0;
        critters.removeAll(critters);
    }

    /**
     * initialize critter moving
     */
    public static void crittersMoving() {
        for (Critter c : critters){
            c.moveThroughPathInMap();
        }
    }

    /**
     * initialize game map for every critters
     * @param gameMap
     */
    public static void setGameMapForCritters(GameMap gameMap) {
        for (Critter c : critters){
            c.setGameMap(gameMap);
        }
    }

    /**
     * pointer to make a critter alive under the timer
     */
    public static int currentIndex = 0;


}
