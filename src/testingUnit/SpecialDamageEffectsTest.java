package testingUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.critter.Critter;
import view.critter.CritterType;
import model.tower.BurningTowerShootingBehavior;
import model.tower.IceTowerShootingBehavior;
import model.tower.SplashTowerShootingBehavior;
/**
 * Testing special damage effects.
 * 
 * @author ChongLi
 * @since 3/4/2016
 * @version 1.0
 */
public class SpecialDamageEffectsTest {
	

	private static Critter c = new Critter(CritterType.CritterA);
	private static Critter c1 = new Critter(CritterType.CritterA);
	
	/**
	 * Test burning effect
	 */
	@Test
	public void testBurning() {
		BurningTowerShootingBehavior btsb = new BurningTowerShootingBehavior(5, 100, 5);
		int priorHealth = c.getCurrentHealth();
		btsb.getCrittersInRange().add(c);
		int currentHealth= c.getCurrentHealth();
		assertEquals("different Health",priorHealth, currentHealth);
	}
	/**
	 * Test ice effect
	 */
	@Test
	public void testIce(){
		IceTowerShootingBehavior itsb = new IceTowerShootingBehavior(1000, 10);
		int priorSpeed = c.getMovingSpeed();
		itsb.getCrittersInRange().add(c);
		int currentSpeed = c.getMovingSpeed();
		assertEquals("still moving",priorSpeed,currentSpeed);
	}
	@Test
	public void testSplash(){
		SplashTowerShootingBehavior stsb = new SplashTowerShootingBehavior(100, 10);
		int priorHealth = c.getCurrentHealth();
		stsb.getCrittersInRange().add(c);
		int currentHealth= c.getCurrentHealth();
		int priorHealth1 = c1.getCurrentHealth();
		int currentHealth1= c1.getCurrentHealth();
		assertEquals("different Health",priorHealth, currentHealth);
		assertEquals("different Health",priorHealth1, currentHealth1);
	}
}
