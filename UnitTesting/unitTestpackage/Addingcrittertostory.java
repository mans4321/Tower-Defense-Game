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

public class Addingcrittertostory {

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
	
	@Test
	public void testbuildingcritterwave() {
		Builder buildcrittera = new Builder();
		
		buildcrittera.critterA(2);
		
		Wave wave1test = new Wave(buildcrittera.critterB(2));
		
	}
	}
	/**
	 public Builder critterB(int num) {
         for (int i = 0; i < num; i++) {
             CritterB critterB = new CritterB();
             CritterStore.critters.add(critterB);
         }
         return this;
     }
*/

	private void asssertTrue() {
		// TODO Auto-generated method stub
		
	}
}
