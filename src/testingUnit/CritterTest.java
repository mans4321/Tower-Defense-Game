package testingUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.critter.Critter;
import model.critter.CritterCollection;
import model.critter.CritterD;
import model.tower.NormalTower;
import model.wave.Wave;



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
	
		
       int sizeBeforAddingCritter = CritterCollection.critters.size();
       
       CritterD critterD = new CritterD();
       CritterCollection.critters.add(critterD);
      
       int sizeAfterAddingCritter = CritterCollection.critters.size();
       
       assertTrue(sizeBeforAddingCritter< sizeAfterAddingCritter);
        
       CritterCollection.critters.remove (critterD);

	}
	
	/**
	 * test building a wave of critters
	 */
	@Test
	public void testBuildingCritter() {
		
		 
	
		
		int sizeBeforAddingCritterWave= CritterCollection.critters.size();
		
		new Wave.Builder().critterA(10).build();
		
		int sizeAfterAddingCritterWave = CritterCollection.critters.size();
		
		assertTrue(sizeBeforAddingCritterWave < sizeAfterAddingCritterWave);
		
	}
	
	
	
}
