package unitTestpackage;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import gamemodel.critter.Critter;
import gamemodel.critter.CritterA;
import gamemodel.tower.TowerA;
/**
 * test tower shooting strategies 
 * 
 * @author m_lzahra
 *@version 1.0
 *@since 14/3/2016
 */
public class TowerTest {
	
	CritterA crriter1;
	CritterA crriter2;
	Set<Critter> crittersInRange;
	TowerA tower ;
	
	/**
	 * setting the critters to test tower strategies
	 */
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
	
	/**
	 * testing target based on weakest shooting strategy
	 */
	@Test
	public void testTargetBasedOnWeakest() {
		
		
		assertTrue(crriter2 == tower.targetBasedOnWeakest(crittersInRange));
	}
	
	/**
	 *  testing target based on strongest shooting strategy
	 */
	@Test
	public void testTargetBasedOnStrongest() {
		
		assertTrue(crriter1 == tower.targetBasedOnStrongest(crittersInRange));
	}
	
	/**
	 * testing target Based on nearest  shooting strategy
	 */
	@Test
	public void testTargetBasedOnNearestest() {
           
		assertTrue(crriter2 == tower.targetBasedOnNearestToEnd(crittersInRange, 0));
}
}