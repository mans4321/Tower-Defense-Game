
package testingUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.critter.Critter;
import model.critter.CritterMovingBehavior;
import model.map.GameMap;
import model.tower.IceTowerShootingBehavior;
import model.tower.Tower;
import model.tower.TowerFactory;
import view.critter.CritterType;
import view.map.Position;
import view.tower.TowerType;

/**
 * Test ice tower shooting behavior
 * @author LiChong
 * @since 3/4/2016
 * @version 1.1
 *
 */
public class IceTowerShootingBehaviorTest {
	private Critter critter;
	private Tower iceTower;
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
		
	}

	/**
	 * Test method for {@link model.tower.IceTowerShootingBehavior#shoot()}.
	 */
	@Test
	public void testShoot() {
		Critter critter =new Critter(CritterType.CritterA);
		critter.setMovingBehavior(new CritterMovingBehavior(new GameMap(), 7));
		critter.getMovingBehavior().setCurrentPosition(new Position(0,0));
		critter.getMovingBehavior().move();
		iceTower = TowerFactory.sharedInstance().getTower(TowerType.IceTower1);
		iceTower.setPosition(new Position(0,0));
		iceTower.getTowerShootingBehavior().getCrittersInRange().add(critter);
		iceTower.getTowerShootingBehavior().setShooting(true);
		iceTower.getTowerShootingBehavior().shoot();
		assertTrue( critter.getSpecicalEffectTimer().isRunning());
	}

	/**
	 * Test method for {@link model.tower.IceTowerShootingBehavior#IceTowerShootingBehavior(int, int)}.
	 */
	@Test
	public void testIceTowerShootingBehavior() {
		IceTowerShootingBehavior iceTowerShootingBehavior = new IceTowerShootingBehavior(1000,10);
		assertEquals("forzen equal",1000,iceTowerShootingBehavior.getFrozenTime());
		assertEquals("rateOfFire equal",10,iceTowerShootingBehavior.getRateOfFire());
	}

}
