
package testingUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.tower.SplashTowerShootingBehavior;

/**
 * Test burning tower shooting behavior
 * @author LiChong
 * @since 3/4/2016
 * @version 1.1
 *
 */
public class SplashTowerShootingBehaviorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link model.tower.SplashTowerShootingBehavior#shoot()}.
	 */
	@Test
	public void testShoot() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.tower.SplashTowerShootingBehavior#SplashTowerShootingBehavior(int, int)}.
	 */
	@Test
	public void testSplashTowerShootingBehavior() {
		SplashTowerShootingBehavior stsb = new SplashTowerShootingBehavior(10, 100);
		assertEquals("power equal",10,stsb.getPower());
		assertEquals("rateOfFire equal",100,stsb.getRateOfFire());
	}

}
