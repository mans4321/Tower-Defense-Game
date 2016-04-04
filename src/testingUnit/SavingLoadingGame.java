package testingUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.savegame.GameCollection;

public class SavingLoadingGame {

	GameCollection GameCollection ;
	int gmaeCollectionSize;
	
	/**
	 * setting values 
	 */
	  @Before
	    public void setValues() {
		  GameCollection = new GameCollection();
		  
	  }
	
	@Test
	public void testLoadGame() throws Exception {
		gmaeCollectionSize = GameCollection.getGames().size();
		GameCollection.loadGame();
		assertTrue(gmaeCollectionSize < GameCollection.getGames().size() );
	}
	
	
}
