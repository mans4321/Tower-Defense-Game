/**
 * 
 */
package testingUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.critter.Critter;
import model.tower.BurningTower;
import model.tower.TowerShootingBehavior;
import view.critter.CritterType;

/**
 * Test tower shooting behavior
 * @author LiChong
 * @since 3/4/2016
 * @version 1.1
 *
 */
public class TowerShootingBehaviorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Critter c = new Critter(CritterType.CritterA);
		Critter c1 = new Critter(CritterType.CritterA);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		BurningTower bt = new BurningTower(1);
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#getPower()}.
	 */
	@Test
	public void testGetPower() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#getRateOfFire()}.
	 */
	@Test
	public void testGetRateOfFire() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#getCrittersInRange()}.
	 */
	@Test
	public void testGetCrittersInRange() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#isShooting()}.
	 */
	@Test
	public void testIsShooting() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#setShooting(boolean)}.
	 */
	@Test
	public void testSetShooting() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#isTimeToShoot()}.
	 */
	@Test
	public void testIsTimeToShoot() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#setTimeToShoot(boolean)}.
	 */
	@Test
	public void testSetTimeToShoot() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#setTowerDidShotDelegate(protocol.TowerDidShotDelegate)}.
	 */
	@Test
	public void testSetTowerDidShotDelegate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#getShootingStrategy()}.
	 */
	@Test
	public void testGetShootingStrategy() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.TowerShootingBehavior#setShootingStrategy(model.tower.shootingstrategy.TowerShootingStrategy)}.
	 */
	@Test
	public void testSetShootingStrategy() {
		fail("Not yet implemented");
	}
	
}
