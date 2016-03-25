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
 

	int sizeAfterAddingCritter;
	int sizeBeforAddingCritter;
	int sizeBeforAddingCritterWave;
	int sizeAfterAddingCritterWave;
	
	CritterD critterD ;
	 
	/**
	 * test adding critter to critter store 
	 */
	@Test
	public void testAddingCritterToStore() {
		
        sizeBeforAddingCritter = CritterCollection.critters.size();
        
       critterD = new CritterD();
       CritterCollection.critters.add(critterD);
       
       sizeAfterAddingCritter = CritterCollection.critters.size();
       
       assertTrue(sizeBeforAddingCritter< sizeAfterAddingCritter);
        
       CritterCollection.critters.remove (critterD);

	}
	
	/**
	 * test building a wave of critters
	 */
	@Test
	public void testBuildingCritter() {
		
		 
	
		
		sizeBeforAddingCritterWave= CritterCollection.critters.size();
		
		new Wave.Builder(1).critterA(10).build();
		
	    sizeAfterAddingCritterWave = CritterCollection.critters.size();
		
		assertTrue(sizeBeforAddingCritterWave < sizeAfterAddingCritterWave);
		
	}
	
	
	
}
