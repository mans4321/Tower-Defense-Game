
package testingUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.critter.Critter;
import model.critter.CritterMovingBehavior;
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
 * @since 5/4/2016
 * @version 1.3
 *
 */
public class TargetBasedOnNearestTest {
	private Set<Critter> critterInRange;
	private Critter critter1;
	private Critter critter2;
	private Critter critter3;
	private GameMap gameMap;
    private ArrayList<CellState> cells;
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
		critterInRange = new HashSet<>();
		critter1 = new Critter(CritterType.CritterA);
		critter2 = new Critter(CritterType.CritterB);
		critter3 = new Critter(CritterType.CritterC);
		critterInRange.add(critter1);
		critterInRange.add(critter2);
		critterInRange.add(critter3);
		cells = new ArrayList<>();
		for(int i = 0; i < 20 ; i++){
			cells.add(CellState.Path);
		}
		cells.add(0, CellState.Entrance);
		cells.add(19, CellState.Exit);
		
		gameMap = new GameMap(10, 15, cells, "myGame");
		CritterMovingBehavior critterMovingBehavior = new CritterMovingBehavior(gameMap, 10);
		
		pathList1 = new ArrayList<>();
		pathList2 = new ArrayList<>();
		pathList3 = new ArrayList<>();
		
		for(int i = 5; i < cells.size(); i++) {
			pathList1.add(i);
		}
		for(int i = 4; i < cells.size(); i++) {
			pathList2.add(i);
		}
		for(int i = 3; i < cells.size(); i++) {
			pathList3.add(i);
		}
		
		critter1.setMovingBehavior(critterMovingBehavior);
		critter2.setMovingBehavior(critterMovingBehavior);
		critter3.setMovingBehavior(critterMovingBehavior);
		
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
		
		Critter nearestCritter = targetBasedOnNearest.targetOnCritters(critterInRange, null);
		assertSame("who is the nearest to Exit",nearestCritter,critter1);
		assertNotSame("who is the nearest to Exit",nearestCritter,critter2);
		assertNotSame("who is the nearest to Exit",nearestCritter,critter3);
	}

}
