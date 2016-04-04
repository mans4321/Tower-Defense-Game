
package testingUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.critter.Critter;
import model.tower.BurningTower;
import model.tower.BurningTowerShootingBehavior;
import model.tower.SplashTower;
import model.tower.SplashTowerShootingBehavior;
import view.critter.CritterType;

/**
 * Test burning tower shooting behavior
 * @author LiChong
 * @since 3/4/2016
 * @version 1.1
 *
 */
public class SplashTowerShootingBehaviorTest {
	private SplashTower splashTower;
	private SplashTowerShootingBehavior splashTowerShootingBehavior;
	private Critter critter;
	private Critter critter1;
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
		critter = new Critter(CritterType.CritterA);
		critter1 = new Critter(CritterType.CritterA);
		splashTower = new SplashTower(1);
		splashTowerShootingBehavior = new SplashTowerShootingBehavior(10, 100);
		splashTowerShootingBehavior.getCrittersInRange().add(critter);
	}

	/**
	 * Test method for {@link model.tower.SplashTowerShootingBehavior#shoot()}.
	 */
	@Test
	public void testShoot() {
		int priorHealth = critter.getCurrentHealth();
		int priorHealth1 = critter1.getCurrentHealth();
		splashTowerShootingBehavior.shoot();
		int currentHealth = critter.getCurrentHealth();
		int currentHealth1 = critter1.getCurrentHealth();
		assertTrue("check health",(priorHealth-currentHealth) > 0);
		assertEquals("check health",0,(priorHealth1-currentHealth1));
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
