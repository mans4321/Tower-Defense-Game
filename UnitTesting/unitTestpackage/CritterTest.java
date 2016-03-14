package unitTestpackage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gamemodel.critter.Critter;
import gamemodel.critter.CritterD;
import gamemodel.critter.CritterStore;
import gamemodel.tower.Tower;
import gamemodel.tower.TowerA;
import gamemodel.wave.Wave.Builder;

public class CritterTest {

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
	public void testCritterGotHit(){
		TowerA tower;
		tower = new TowerA(1) ;
		Critter critter = new Critter();
		int health =critter.getHealth();
		critter.getHitBy(tower);
		
		assertTrue(health > critter.getHealth() );
	}
	
	
}
