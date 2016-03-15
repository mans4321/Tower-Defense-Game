package unitTestpackage;

import org.junit.Test;

import gamemodel.tower.Tower;
import gamemodel.tower.TowerFactory;
import gamemodel.tower.TowerId;

import static org.junit.Assert.*;

/**
 * test the TowerFactory class 
 * 
 * @author m_lzahra
 *@version 1.0
 *@since 15/2/2016
 */
public class TowerFactoryTest {

	/**
	 * test get instance function return the wanted tower instance 
	 */
	@Test
	public void getTowerTest() {
		Tower tower = TowerFactory.getInstance().getTower(TowerId.TOWERA1);
		
    	assertTrue(tower.getClass().getName().equals("gamemodel.tower.TowerA"));
	 
	}
}
