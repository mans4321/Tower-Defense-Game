package testingUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import model.wave.WaveBuilder;
import org.junit.Test;

import model.critter.Critter;
import model.critter.CritterCollection;
import view.critter.CritterType;


/**
 * testing operation on Critters.
 *  
 * @author m_lzahra
 * @version 2.0
 * @since 14/3/2016
 */
public class CritterTest {

	int sizeAfterAddingCritter;
	int sizeBeforAddingCritter;
	int waveNumber;
	Critter critter ;
	CritterCollection critterCollection ;
	WaveBuilder waveBuilder;

	/**
     * set values 
     */
    @Before
    public void setValues() {
    	critterCollection = new CritterCollection();
    	critter = new Critter(CritterType.CritterD);
    	waveNumber = 1;
    	waveBuilder	= new WaveBuilder(1);
    }
	/**
	 * test adding critter to critter store
	 */
	@Test
	public void testAddingCritterToStore() {
        sizeBeforAddingCritter = critterCollection.getCritters().size();
		critterCollection.getCritters().add(critter);
		sizeAfterAddingCritter = critterCollection.getCritters().size();
        assertTrue(sizeBeforAddingCritter< sizeAfterAddingCritter);

	}

	/**
	 * test building a wave of critters
	 */
	@Test
	public void testBuildingCritter() {
		 sizeBeforAddingCritter= waveBuilder.getCritterCollection().getCritters().size();
         waveBuilder = new WaveBuilder(1).critterA(10);
         sizeAfterAddingCritter = waveBuilder.getCritterCollection().getCritters().size();
		 assertTrue(sizeBeforAddingCritter < sizeAfterAddingCritter);

	}
	
	/**
	 * test critter speed increase by wave number
	 */
	@Test
	public void testCritterIncreasingSpeedWithEveryWave() {
		Critter critterInHigherWaveNumber ;
		int critterSpeedInlowerWaveNumber;
		int critterSpeedInHigherWaveNumber;
		
		waveBuilder = new WaveBuilder(1).critterD(1);
		critter = waveBuilder.getCritterCollection().getCritters().get(0);
		critterSpeedInlowerWaveNumber = critter.getMovingSpeed();
		waveBuilder = new WaveBuilder(2).critterD(1);
		critterInHigherWaveNumber = waveBuilder.getCritterCollection().getCritters().get(0);
		critterSpeedInHigherWaveNumber = critterInHigherWaveNumber.getMovingSpeed();
		assertTrue(critterSpeedInlowerWaveNumber < critterSpeedInHigherWaveNumber);
	}
}