package testingunit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.map.CellState;
import model.map.GameMap;


/**
 * test getting the exist and entrance form map file.
 * 
 * @author m_lzahra
 * @version 1.0
 * @since 14/3/2016
 */
public class EntranceExit {

    private GameMap  mapFile;
    private ArrayList<CellState> cellList;

    /**
     * seeting the pointer for mapFile.
     */
    @Before
    public void setValus() {
        
          mapFile = new GameMap();
          
          cellList = mapFile.getCells();
          
          cellList.set(0, CellState.Entrance);
          cellList.set(10, CellState.Exit);
          mapFile.setCells(cellList);
    }
    
    /**
     * test get the entrance.
     */
    @Test
    public void getExtrancePos() {

        assertTrue(mapFile.findEntranceIndex() == 0);
    }
    
    /**
     * test get the exist.
     */
    @Test
    public void getExitPos() {

        assertTrue(mapFile.findExitIndex() == 10);
    }
}
