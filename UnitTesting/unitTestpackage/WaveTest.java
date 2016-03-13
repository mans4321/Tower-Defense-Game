package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.Test;



import gamemodel.critter.Critter;
import gamemodel.critter.CritterA;
import gamemodel.critter.CritterB;
import gamemodel.critter.CritterD;
import gamemodel.critter.CritterStore;
import gamemodel.wave.Wave;
import gamemodel.wave.Wave.Builder;

public class WaveTest {

	@Test
	public void testaddingcrittertoythestore() {
		
		Critter crittera = new Critter();
	
		
       int sizebeforadding= CritterStore.critters.size();
       
       CritterD critterD = new CritterD();
       CritterStore.critters.add(critterD);
      
       int sizafteradding = CritterStore.critters.size();
       
       assertTrue(sizebeforadding< sizafteradding);
        
       CritterStore.critters.remove (critterD);
        
		//fail("Not yet implemented");
	}
	
	@Test
	public void testbuildingcrittero() {
		
		 
		Builder buildcrittera = new Builder();
		int sizebeforadding= CritterStore.critters.size();
		
		buildcrittera.critterA(2);
		int sizafteradding = CritterStore.critters.size();
		
		assertTrue(sizebeforadding< sizafteradding);
		 //CritterStore.critters.remove (critterA);
		
	}
	
	
}
