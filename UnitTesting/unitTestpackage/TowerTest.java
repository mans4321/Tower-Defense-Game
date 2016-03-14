package unitTestpackage;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import gamemodel.critter.Critter;
import gamemodel.critter.CritterA;
import gamemodel.tower.TowerA;

public class TowerTest {
	
	CritterA crriter1;
	CritterA crriter2;
	Set<Critter> crittersInRange;
	TowerA tower ;
	
	@Before
	public void setValues(){
		
		crriter1 = new CritterA();
		crriter2 = new CritterA();
		crriter1.setHealth(100);
		crriter2.setHealth(60);
		
		crriter1.setPosX(0);
		crriter1.setPosY(0);
		crriter2.setPosX(0);
		crriter2.setPosY(100);
		
		crittersInRange = new HashSet<>();
		
		crittersInRange.add(crriter1);
		crittersInRange.add(crriter2);
		
		tower = new TowerA(1);
	}

	@Test
	public void testtargetBasedOnWeakest() {
		
		
		assertTrue(crriter2 == tower.targetBasedOnWeakest(crittersInRange));
	}
	
	@Test
	public void targetBasedOnStrongest() {
		
		assertTrue(crriter1 == tower.targetBasedOnStrongest(crittersInRange));
	}
	
	@Test
	public void targetBasedOnStronffgest()
	{
           
		assertTrue(crriter2 == tower.targetBasedOnNearestToEnd(crittersInRange, 0));
}
}