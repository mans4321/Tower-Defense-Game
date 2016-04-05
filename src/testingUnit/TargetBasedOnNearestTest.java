
package testingUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.critter.Critter;
import model.map.CellState;
import model.map.GameMap;
import model.tower.BurningTower;
import model.tower.BurningTowerShootingBehavior;
import model.tower.shootingstrategy.TargetBasedOnNearest;
import view.critter.CritterType;
import view.map.Position;

/**
 * Test target strategy, target on the weakest
 * @author LiChong
 * @since 4/4/2016
 * @version 1.2
 *
 */
public class TargetBasedOnNearestTest {
	private Set<Critter> critterInRange;
	private Critter critter1;
	private Critter critter2;
	private Critter critter3;
	private BurningTower burningTower;
	private GameMap gameMap;
    private ArrayList<Integer> pathList1;
    private ArrayList<Integer> pathList2;
    private ArrayList<Integer> pathList3;

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
		burningTower = new BurningTower(1);
		critterInRange = new HashSet();
		critter1 = new Critter(CritterType.CritterA);
		critter2 = new Critter(CritterType.CritterB);
		critter3 = new Critter(CritterType.CritterC);
		critterInRange.add(critter1);
		critterInRange.add(critter2);
		critterInRange.add(critter3);
		
		pathList1 = new ArrayList<>();
		pathList2 = new ArrayList<>();
		pathList3 = new ArrayList<>();
		
		for(int i = 0; i < 10 ; i++){
			pathList1.add(i);
		}
		for(int i = 0; i < 20 ; i++){
			pathList2.add(i);
		}
		for(int i = 0; i < 30 ; i++){
			pathList3.add(i);
		}		
		critter1.getMovingBehavior().setPathList(pathList1);
		critter2.getMovingBehavior().setPathList(pathList2);
		critter3.getMovingBehavior().setPathList(pathList3);
	}

	/**
	 * Test method for {@link model.tower.shootingstrategy.TargetBasedOnNearest#targetOnCritters(java.util.Set, view.map.Position)}.
	 */
	@Test
	public void testTargetOnCritters() {
		TargetBasedOnNearest targetBasedOnNearest = new TargetBasedOnNearest();
		Critter nearestCritter = targetBasedOnNearest.targetOnCritters(critterInRange, new Position(10,10));
		BurningTowerShootingBehavior btsb = new BurningTowerShootingBehavior(5,100,5);
		btsb.getCrittersInRange().add(critter1);
		btsb.getCrittersInRange().add(critter2);
		btsb.getCrittersInRange().add(critter3);
		btsb.shoot();
	//	burningTower.getTowerShootingBehavior().shoot();
		int size1 = critter1.getMovingBehavior().getPathList().size();
		int size2 = critter2.getMovingBehavior().getPathList().size();
		int size3 = critter3.getMovingBehavior().getPathList().size();
	//	assertTrue("who is the nearest to Exit",size3 < size1 && size3 < size2);
		assertEquals("who is the nearest to Exit",nearestCritter.getMovingBehavior().getPathList().size(),size3);
	}

}
