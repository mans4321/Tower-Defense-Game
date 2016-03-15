package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import gamemodel.gamemap.GameMap;
import gamemodel.gamemap.GameMapCollection;
/**
 * Testing adding and delete map from GameMap class
 * 
 *@author m_lzahra
 *@since 15/2/2016
 *@version 1.0
 */
public class AddingDeletingMap {

	/**
	 * test adding map
	 */

	@Test
	public void testAddMap() {
		
		GameMapCollection mapCollection = new GameMapCollection();
		
		GameMap mpa = new GameMap(2,2,null,"MANS");
		int beforAdding = mapCollection.getMaps().size();
		
		mapCollection.addMap(mpa);
		int afterAdding = mapCollection.getMaps().size();
		
		assertTrue(beforAdding< afterAdding);
		
		mapCollection.getMaps().remove(mpa);
		
	}
   
	/**
	 * test deleting map
	 */
	@Test
	public void testDeleteMap() {
		GameMapCollection mapCollection = new GameMapCollection();
		
		GameMap mpa = new GameMap(2,2,null,"MANS");
		int beforAdding = mapCollection.getMaps().size();
		
		mapCollection.addMap(mpa);
		int index = mapCollection.getMaps().indexOf(mpa);
		
		
		
		mapCollection.deleteMap(index);
		int afterAdding = mapCollection.getMaps().size();
		
		assertTrue(beforAdding == afterAdding);
	
	}

}
