package testingunit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.gamelog.Log;
import model.savegame.GameCollection;
import model.savegame.GameInfo;
import model.savegame.SavedGamesMaps;
import model.tower.Tower;

/**
 * testing saving,loading, and extract information from games saved to the file.
 * 
 * This test build on the assumption there is at last one saved game in the file 
 * @author m_lzahra
 * @since 4/4/2016
 * @version 1.0
 */
public class SavingLoadingGameTest {

    static GameCollection gameCollection ;
    static int gmaeCollectionSizeBeforeAddingGameTest;
    static GameInfo game;

    /**
     * setting values 
     */
    @BeforeClass
    public static void setValues() {
        gameCollection = new GameCollection(); 
        gmaeCollectionSizeBeforeAddingGameTest = gameCollection.getGames().size();
        gameCollection.loadGame(); 
        HashMap<Integer, Tower> towerCollection = new HashMap<Integer, Tower>() ;
        ArrayList<Log> logList = new ArrayList<Log>();
        game = new GameInfo(towerCollection , logList ,1000,100,4,"GameTest", "MapName");
        gameCollection.addGame(game);
        gameCollection.saveGame();
    }
    /**
     * deleting test info from file
     */
    @AfterClass
    public static void deletTestGameFromFile() {
            int index = gameCollection.findGameInCollection("GameTest");
            gameCollection.removeGame(index);
            gameCollection.saveGame();  
    }

    /**
     * Test saving game.
     */
    @Test
    public void testSavingAndLoadingGame() {
        assertTrue(gmaeCollectionSizeBeforeAddingGameTest < gameCollection.getGames().size() );
    }
    
    /**
     * Test loading game and getting information.
     */
    @Test
    public void testLoadGameAndGetInfo() {
    	
    	int gameIndex = gameCollection.findGameInCollection("GameTest");
        GameInfo extractGameInfo = gameCollection.getGames().get(gameIndex);
        assertTrue(extractGameInfo.getGameName().equalsIgnoreCase("GameTest"));
        assertTrue(extractGameInfo.getMapName().equalsIgnoreCase("MapName"));
        }
    }