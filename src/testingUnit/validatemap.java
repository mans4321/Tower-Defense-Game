package testingUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import model.map.CellState;
import model.map.GameMap;
import model.map.mapvalidation.CirclePathValidator;
import model.map.mapvalidation.ContinousPathValidator;
import model.map.mapvalidation.EntranceExitInMiddlePathValidator;
import model.map.mapvalidation.ExtraPathValidator;
import model.map.mapvalidation.LengthValidator;
import model.map.mapvalidation.MapValidationManager;
import model.map.mapvalidation.NoEntranceNoExitMoreEntranceMoreExitValidator;
import model.map.mapvalidation.SeperateEntranceAndExitValidator;


/**
 * test map  validator 
 * @author m_lzahra
 *@version 1.0
 *@since 14/3/2016
 */
public class validatemap {

	private ArrayList<CellState> cellLisTest;
	private HashMap<Integer, Integer> countMap;
	private NoEntranceNoExitMoreEntranceMoreExitValidator  enteranceExitPoint;
	private boolean checkMap;
	private SeperateEntranceAndExitValidator seperate;
	private LengthValidator lengthValidator;
	private EntranceExitInMiddlePathValidator middel;
	private MapValidationManager mapValidator;
	private GameMap gameMap;
	@Before
	public void setValues(){
		
		cellLisTest = new ArrayList<CellState>();
        countMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < 30*15; i++) {
			cellLisTest.add(CellState.Grass );
			}
	}
	
	/**
	 * test no Enterer or Exist point 
	 */
	@Test
	public void testNoEnEX() {
		
		enteranceExitPoint = new NoEntranceNoExitMoreEntranceMoreExitValidator(cellLisTest);
		
		checkMap = enteranceExitPoint.validate();
		assertFalse(checkMap);
		
		}
	
	/**
	 * test when only one  Enterer and Exist point  
	 */
	@Test
	public void testOneEnterEXit() {
		
		cellLisTest.set(0, CellState.Entrance );
		cellLisTest.set(100, CellState.Exit );
		
		enteranceExitPoint= new NoEntranceNoExitMoreEntranceMoreExitValidator(cellLisTest);
		
		checkMap = enteranceExitPoint.validate();
		assertTrue(checkMap);
	}
	
	/**
	 * test when more then one  Enterer and Exist point 
	 */
	@Test
	public void testMoreThenOneEnterEXit() {
		
		cellLisTest.set(0, CellState.Entrance );
		cellLisTest.set(100, CellState.Exit );
		cellLisTest.set(5, CellState.Entrance );
		cellLisTest.set(6, CellState.Exit );
		
		enteranceExitPoint= new NoEntranceNoExitMoreEntranceMoreExitValidator(cellLisTest);
		checkMap = enteranceExitPoint.validate();
		
		assertFalse(checkMap);
	}

	
//	/**
//	 * TEST Separate entrance and exit point 
//	 */
//	@Test
//	public void testSeperateEnex() {
//		
//		for (int i = 0; i <20 ; i++){
//			cellLisTest.set(i,CellState.PATH );
//		}
//		
//		cellLisTest.set(5,CellState.GRASS );
//		cellLisTest.set(0,CellState.ENTRANCE);
//		cellLisTest.set(19,CellState.EXIT);
//		
//		seperate = new SeperateEntranceAndExitValidator(10,cellLisTest);
//		
//		checkMap = seperate.validate();
//		
//		assertFalse(checkMap);
//	}
	
	/**
	 * TEST not Separate entrance and exit point 
	 */
	@Test
	public void testNotSeperateEnex() {
		
		for (int i = 0; i <20 ; i++){
			cellLisTest.set(i,CellState.Path );
		}
		
		cellLisTest.set(0,CellState.Entrance);
		cellLisTest.set(19,CellState.Exit);
		
		seperate = new SeperateEntranceAndExitValidator(10,cellLisTest);
		
		checkMap = seperate.validate();
		
		assertTrue(checkMap);
	}
	
	/**
	 * test if the path is short
	 */
	@Test
	public void testToshortmaP() {
		
		for (int i = 0; i < 9; i++) {
		
		cellLisTest.set(i, CellState.Path );
		}

		lengthValidator = new LengthValidator(cellLisTest);
	
		checkMap = lengthValidator.validate();
		assertFalse(checkMap);
}
	
	/**
	 * test if the path is not short
	 */
	@Test
	public void testNotToshortmaP() {
		
		for (int i = 0; i < 25; i++) {
			
			cellLisTest.set(i, CellState.Path );
			}

			lengthValidator = new LengthValidator(cellLisTest);
		
			checkMap = lengthValidator.validate();
			assertTrue(checkMap);
	}
	
	/**
	 * test Circle Path 
	 */
	@Test
	public void testCirclePathValidator() {
	
		
		
		for(int i= 0 ; i < 7 ; i++){
		countMap.put(i, i);
		}
		CirclePathValidator circlePathValidator = new CirclePathValidator(countMap);     ////  ask 
		
		checkMap = circlePathValidator.validate();
		 assertTrue(checkMap);
		 
}
	/**
	 * test Continous Path
	 */
	@Test
	public void testContinousPathValidator() {
	
		
		for(int i= 0 ; i < 7 ; i++){
		countMap.put(i, i);
		}
		
		ContinousPathValidator testPath = new ContinousPathValidator(countMap);
		
		boolean testContinousPath =testPath.validate();                             /// ask
		
		assertFalse(testContinousPath);
		
	}
	
	/**
	 * test entrance  In middle path
	 */
	@Test
	public void testExitInMiddlePathValidator() {

		gameMap =new GameMap();
		
		for (int i = 0; i < 20; i++) {
			cellLisTest.set(i,CellState.Path );
		}
	
		cellLisTest.set(0,CellState.Entrance );
		cellLisTest.set(15,CellState.Exit );

		gameMap.setCells(cellLisTest);
	   mapValidator = new MapValidationManager(gameMap);
	   
	   countMap = mapValidator.getCountMap();
	   middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
	   
	   assertFalse(middel.validate());
	}
	
	/**
	 * test entrance  In middle path
	 */
	@Test
	public void testEmteranceInMiddlePathValidator() {
		
		gameMap = new GameMap();
		for (int i = 0; i < 20; i++) {
			cellLisTest.set(i,CellState.Path );
		}
	
		cellLisTest.set(4,CellState.Entrance );
		cellLisTest.set(19,CellState.Exit );
		
		gameMap.setCells(cellLisTest);
		   mapValidator = new MapValidationManager(gameMap);
		   countMap = mapValidator.getCountMap();
		   middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
		   
		   assertFalse(middel.validate());
	}
	

	/**
	 * test no entrance or Exit  In middle path
	 */
	@Test
	public void testEnteranceNotInMiddlePathValidator() {
		
		gameMap = new GameMap();
		
		for (int i = 0; i < 20; i++) {
			cellLisTest.set(i,CellState.Path );
		}
		cellLisTest.set(0,CellState.Entrance);
		cellLisTest.set(19,CellState.Exit );
		
		gameMap.setCells(cellLisTest);
		   mapValidator = new MapValidationManager(gameMap);
		countMap = mapValidator.getCountMap();
		middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
		assertTrue(middel.validate());
	}
	
	/**
	 * test  Extra Path
	 */
	@Test
	public void ExtraPathValidator(){
		
		gameMap = new GameMap();
		for (int i = 0; i < 21 ; i++) {
			cellLisTest.set(i , CellState.Path );
	}
		cellLisTest.set(0,CellState.Entrance );
		cellLisTest.set(19,CellState.Exit );
		cellLisTest.set(200, CellState.Path);
		
		gameMap.setCells(cellLisTest);
		MapValidationManager mapValidator = new MapValidationManager(gameMap);
		countMap = mapValidator.getCountMap();
		boolean validate =new ExtraPathValidator(countMap,cellLisTest).validate();
		assertTrue(validate);
	}
	
	
	
	
	/**
	 * test no Extra Path
	 */
	@Test
	public void noExtraPathValidator() {
	
		gameMap = new GameMap();
		for (int i = 0; i < 20 ; i++) {
			cellLisTest.set(i , CellState.Path );
	}
		cellLisTest.set(0,CellState.Entrance );
		cellLisTest.set(19,CellState.Exit );
		
		
		   gameMap.setCells(cellLisTest);
		   mapValidator = new MapValidationManager(gameMap);
		countMap = mapValidator.getCountMap();
		boolean validate =new ExtraPathValidator(countMap,cellLisTest).validate();
		assertTrue(validate);
}	
}