package testingUnit;

import static org.junit.Assert.assertTrue;

import model.wave.WaveBuilder;
import org.junit.Test;

import model.critter.Critter;
import model.critter.CritterCollection;
import view.critter.CritterType;


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

	Critter critterD ;
	CritterCollection critterCollection = new CritterCollection();
	/**
	 * test adding critter to critter store
	 */
	@Test
	public void testAddingCritterToStore() {

        sizeBeforAddingCritter = critterCollection.getCritters().size();

       	critterD = new Critter(CritterType.CritterD);
		critterCollection.getCritters().add(critterD);

       sizeAfterAddingCritter = critterCollection.getCritters().size();

       assertTrue(sizeBeforAddingCritter< sizeAfterAddingCritter);

       critterCollection.getCritters().remove (critterD);

	}

	/**
	 * test building a wave of critters
	 */
	@Test
	public void testBuildingCritter() {




		sizeBeforAddingCritterWave= critterCollection.getCritters().size();

		new WaveBuilder().critterA(10);
	    sizeAfterAddingCritterWave = critterCollection.getCritters().size();

		assertTrue(sizeBeforAddingCritterWave < sizeAfterAddingCritterWave);

	}



}
