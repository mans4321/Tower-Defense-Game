
package testingUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.critter.Critter;
import model.map.CellState;
import model.map.GameMap;
import model.tower.shootingstrategy.TargetBasedOnClosestToTower;
import view.critter.CritterType;

/**
 * Test target strategy, target on the weakest
 * @author LiChong
 * @since 4/4/2016
 * @version 1.2
 *
 */
public class TargetBasedOnClosestToTowerTest {
	private Set<Critter> critterInRange;
	private Critter critter1;
	private Critter critter2;
	private Critter critter3;

    private ArrayList<CellState> cellList;
	private GameMap gameMap;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gameMap = new GameMap();
		cellList = gameMap.getCells();
		critterInRange = new HashSet();
		critter1 = new Critter(CritterType.CritterA);
		critter2 = new Critter(CritterType.CritterB);
		critter3 = new Critter(CritterType.CritterC);
		critterInRange.add(critter1);
		critterInRange.add(critter2);
		critterInRange.add(critter3);
		
		cellList.set(1, CellState.Exit);
		gameMap.setCells(cellList);
	}

	/**
	 * Test method for {@link model.tower.shootingstrategy.TargetBasedOnClosestToTower#targetOnCritters(java.util.Set, view.map.Position)}.
	 */
	@Test
	public void testTargetOnCritters() {
		fail("Not yet implemented");
	}

}
