
package testingUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import model.critter.Critter;
import model.tower.BurningTower;
import model.tower.BurningTowerShootingBehavior;
import model.tower.IceTower;
import model.tower.IceTowerShootingBehavior;
import view.critter.CritterType;

/**
 * Test ice tower shooting behavior
 * @author LiChong
 * @since 3/4/2016
 * @version 1.1
 *
 */
public class IceTowerShootingBehaviorTest {
	private Critter critter;
	private IceTower iceTower;
	private IceTowerShootingBehavior iceTowerShootingBehavior;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		critter = new Critter(CritterType.CritterA);
		iceTower = new IceTower(1);
		iceTowerShootingBehavior = new IceTowerShootingBehavior(1000, 10);
		iceTowerShootingBehavior.getCrittersInRange().add(critter);
		
	}

	/**
	 * Test method for {@link model.tower.IceTowerShootingBehavior#shoot()}.
	 */
	@Test
	public void testShoot() {
		iceTowerShootingBehavior.shoot();
		assertTrue("iceShooting works",critter.getSpecicalEffectTimer().isRunning());
	}

	/**
	 * Test method for {@link model.tower.IceTowerShootingBehavior#IceTowerShootingBehavior(int, int)}.
	 */
	@Test
	public void testIceTowerShootingBehavior() {
		assertEquals("forzen equal",1000,iceTowerShootingBehavior.getFrozenTime());
		assertEquals("rateOfFire equal",10,iceTowerShootingBehavior.getRateOfFire());
	}

}
