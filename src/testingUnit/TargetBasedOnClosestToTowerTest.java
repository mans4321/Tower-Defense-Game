
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
import view.map.Position;

/**
 * Test target strategy, target on the weakest
 * @author LiChong
 * @since 4/4/2016
 * @version 1.2
 *
 */
public class TargetBasedOnClosestToTowerTest {
	private Set<Critter> crittersInRange;
	private Critter critter1;
	private Critter critter2;
	private Critter critter3;

    private ArrayList<CellState> cellList;
	private GameMap gameMap;
	
	private Position towerPosition;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gameMap = new GameMap();
		cellList = gameMap.getCells();
		crittersInRange = new HashSet();
		critter1 = new Critter(CritterType.CritterA);
		critter2 = new Critter(CritterType.CritterB);
		critter3 = new Critter(CritterType.CritterC);
		crittersInRange.add(critter1);
		crittersInRange.add(critter2);
		crittersInRange.add(critter3);
		
		towerPosition = new Position(10, 10);
		
	//	cellList.set(1, CellState.Exit);
	//	gameMap.setCells(cellList);
	}

	/**
	 * Test method for {@link model.tower.shootingstrategy.TargetBasedOnClosestToTower#targetOnCritters(java.util.Set, view.map.Position)}.
	 */
	@Test
	public void testTargetOnCritters() {
		TargetBasedOnClosestToTower targetBasedOnClosestToTower = new TargetBasedOnClosestToTower();
		targetBasedOnClosestToTower.targetOnCritters(crittersInRange, towerPosition);
		assertTrue("find the critter who is closest to tower",);
	}

}
