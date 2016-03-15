package unitTestpackage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gamemodel.critter.Critter;
import gamemodel.critter.CritterD;
import gamemodel.critter.CritterStore;
import gamemodel.tower.Tower;
import gamemodel.tower.TowerA;
import gamemodel.wave.Wave.Builder;

/**
 * testing operation on Critters
 *  
 * @author m_lzahra
 *@version 2.0
 *@since 14/3/2016
 */
public class CritterTest {
 
	/**
	 * test adding critter to critter store 
	 */
	@Test
	public void testAddingCritterToStore() {
		
		Critter critterA = new Critter();
	
		
       int sizeBeforAddingCritter = CritterStore.critters.size();
       
       CritterD critterD = new CritterD();
       CritterStore.critters.add(critterD);
      
       int sizeAfterAddingCritter = CritterStore.critters.size();
       
       assertTrue(sizeBeforAddingCritter< sizeAfterAddingCritter);
        
       CritterStore.critters.remove (critterD);

	}
	
	/**
	 * test building a wave of critters
	 */
	@Test
	public void testBuildingCritter() {
		
		 
		Builder buildCritterA = new Builder();
		
		int sizeBeforAddingCritterWave= CritterStore.critters.size();
		
		buildCritterA.critterA(2);
		
		int sizeAfterAddingCritterWave = CritterStore.critters.size();
		
		assertTrue(sizeBeforAddingCritterWave < sizeAfterAddingCritterWave);
		
	}
	

	/**
	 * test the effect on critter when it get hit by a tower 
	 */
	@Test
	public void testCritterGotHit() {
		
		TowerA tower;
		tower = new TowerA(1) ;
		
		Critter critter = new Critter();
		int health =critter.getHealth();
		critter.getHitBy(tower);
		
		assertTrue(health > critter.getHealth() );
	}
	
	
}
