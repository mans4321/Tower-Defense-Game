package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import gamemodel.gamemap.GameMap;
import gamemodel.gamemap.GameMapCollection;

public class AddingDeletingMap {

	

	@Test
	public void testAddMap() {
		
		GameMapCollection mapcoll = new GameMapCollection();
		
		GameMap mpa = new GameMap(2,2,null,"MANS");
		int beforadding = mapcoll.getMaps().size();
		mapcoll.addMap(mpa);
		int afteradding = mapcoll.getMaps().size();
		
		assertTrue(beforadding< afteradding);
		
		mapcoll.getMaps().remove(mpa);
		
	}

	@Test
	public void testDeleteMap() {
		GameMapCollection mapcoll = new GameMapCollection();
		
		GameMap mpa = new GameMap(2,2,null,"MANS");
		int beforadding = mapcoll.getMaps().size();
		
		mapcoll.addMap(mpa);
		int index = mapcoll.getMaps().indexOf(mpa);
		
		
		
		mapcoll.deleteMap(index);
		int afteradding = mapcoll.getMaps().size();
		
		assertTrue(beforadding == afteradding);
	
	}

}
