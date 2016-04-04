
package testingUnit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.map.CellState;
import model.map.GameMap;
import model.map.GameMapCollection;


/**
 * Testing adding and delete map from GameMap class.
 * 
 * @author m_lzahra
 * @since 15/2/2016
 * @version 1.0
 */
public class TestingMap {

    GameMapCollection gameMapCollection;
    GameMap gameMap;
    int beforAddingMap;
    int afterAddingMap;
    int index;
    ArrayList<CellState> cellListTest;
    /**
     * test adding map
     */

    @Test
    public void testAddingMap() {
    	gameMapCollection = new GameMapCollection();
        gameMap = new GameMap(2,2,null,"MANS");
        beforAddingMap = gameMapCollection.getMaps().size();
        gameMapCollection.addMap(gameMap);
        afterAddingMap = gameMapCollection.getMaps().size();
        assertTrue(beforAddingMap < afterAddingMap);
    }
   
    /**
     * test deleting map.
     */
    @Test
    public void testDeleteMap() {
    	gameMapCollection = new GameMapCollection();
        gameMap = new GameMap(2,2,null,"MANS");
        beforAddingMap = gameMapCollection.getMaps().size();
        gameMapCollection.addMap(gameMap);
        index = gameMapCollection.getMaps().indexOf(gameMap);
        gameMapCollection.deleteMap(index);
        afterAddingMap = gameMapCollection.getMaps().size();
        assertTrue(beforAddingMap == afterAddingMap);
    }
    
    /**
     * test map path.
     */
    @Test
    public void testFindingPathInMap() {
         cellListTest = new ArrayList<CellState>();
         for (int i = 0 ; i < 15 * 30 ; i++) { 
             cellListTest.add(CellState.Grass);
         }
         for (int i = 0 ; i < 20 ; i++) { 
             cellListTest.add(CellState.Path);
         }
         cellListTest.set(0, CellState.Entrance);
         cellListTest.set(19,CellState.Exit );
        gameMap = new GameMap();
        gameMap.setCells(cellListTest);
        assertTrue(gameMap.findPathList().size() == 20);
    }
}
