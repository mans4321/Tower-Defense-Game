package unitTestpackage;

import org.junit.Test;

import gamemodel.tower.Tower;
import gamemodel.tower.TowerFactory;
import gamemodel.tower.TowerId;

import static org.junit.Assert.*;

public class TowerFactoryTest {

	@Test
	public void getTowerTest() {
		Tower tower = TowerFactory.getInstance().getTower(TowerId.TOWERA1);
		
    	assertTrue(tower.getClass().getName().equals("gamemodel.tower.TowerA"));
	 
	}
}
