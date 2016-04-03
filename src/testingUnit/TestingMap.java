
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

    GameMapCollection mapCollection;
    GameMap gameMap;
    int beforAdding;
    int afterAdding;
    int index;
    ArrayList<CellState> cellList;
    /**
     * test adding map
     */

    @Test
    public void testAddMap() {
        
        mapCollection = new GameMapCollection();
        
        gameMap = new GameMap(2,2,null,"MANS");
        beforAdding = mapCollection.getMaps().size();
        
        mapCollection.addMap(gameMap);
        afterAdding = mapCollection.getMaps().size();
        
        assertTrue(beforAdding < afterAdding);
        
        mapCollection.getMaps().remove(gameMap);
        
    }
   
    /**
     * test deleting map.
     */
    @Test
    public void testDeleteMap() {
       mapCollection = new GameMapCollection();
        
        gameMap = new GameMap(2,2,null,"MANS");
        beforAdding = mapCollection.getMaps().size();
        
        mapCollection.addMap(gameMap);
        
        index = mapCollection.getMaps().indexOf(gameMap);
        
        mapCollection.deleteMap(index);
        afterAdding = mapCollection.getMaps().size();
        
        assertTrue(beforAdding == afterAdding);
    }
    
    /**
     * test map path.
     */
    @Test
    public void testPathTest() {
        
         cellList = new ArrayList<CellState>();
        
         for (int i = 0 ; i < 15 * 30 ; i++) { 
             cellList.add(CellState.Grass);
         }
         
         for (int i = 0 ; i < 20 ; i++) { 
             cellList.add(CellState.Path);
         }
         cellList.set(0, CellState.Entrance);
         cellList.set(19,CellState.Exit );
         
        gameMap = new GameMap();
        gameMap.setCells(cellList);
    
        assertTrue(gameMap.findPathList().size() == 20);
    }
}
