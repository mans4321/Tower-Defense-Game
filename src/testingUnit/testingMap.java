
package testingUnit ;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.map.CellState;
import model.map.GameMap;
import model.map.GameMapCollection;


/**
 * Testing adding and delete map from GameMap class
 * 
 *@author m_lzahra
 *@since 15/2/2016
 *@version 1.0
 */
public class testingMap {

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
	
	/**
	 * test map path 
	 */
	@Test
	public void testPathTest(){
		
		 ArrayList <CellState> cellList = new ArrayList<CellState>();
		
		 for (int i = 0 ; i < 15*30 ; i++){ 
			 cellList.add(CellState.Grass);
		 }
		 
		 for (int i = 0 ; i < 20 ; i++){ 
			 cellList.add(CellState.Path);
		 }
		 cellList.set(0, CellState.Entrance);
		 cellList.set(19,CellState.Exit );
		 
		GameMap map = new GameMap();
		map.setCells(cellList);
	
		assertTrue(map.findPathList().size() == 20);
	}
	

}
