package unitTestpackage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gamemodel.gamemap.CellState;
import mapvalidation.CirclePathValidator;
import mapvalidation.ContinousPathValidator;
import mapvalidation.EntranceExitInMiddlePathValidator;
import mapvalidation.ExtraPathValidator;
import mapvalidation.LengthValidator;
import mapvalidation.MapValidationManager;
import mapvalidation.NoEntranceNoExitMoreEntranceMoreExitValidator;
import mapvalidation.SeperateEntranceAndExitValidator;

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
	@Before
	public void setValues(){
		
		cellLisTest = new ArrayList<CellState>();
        countMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < 30*15; i++) {
			cellLisTest.add(CellState.GRASS );
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
		
		cellLisTest.set(0, CellState.ENTRANCE );
		cellLisTest.set(100, CellState.EXIT );
		
		enteranceExitPoint= new NoEntranceNoExitMoreEntranceMoreExitValidator(cellLisTest);
		
		checkMap = enteranceExitPoint.validate();
		assertTrue(checkMap);
	}
	
	/**
	 * test when more then one  Enterer and Exist point 
	 */
	@Test
	public void testMoreThenOneEnterEXit() {
		
		cellLisTest.set(0, CellState.ENTRANCE );
		cellLisTest.set(100, CellState.EXIT );
		cellLisTest.set(5, CellState.ENTRANCE );
		cellLisTest.set(6, CellState.EXIT );
		
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
			cellLisTest.set(i,CellState.PATH );
		}
		
		cellLisTest.set(0,CellState.ENTRANCE);
		cellLisTest.set(19,CellState.EXIT);
		
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
		
		cellLisTest.set(i, CellState.PATH );
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
			
			cellLisTest.set(i, CellState.PATH );
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

		for (int i = 0; i < 20; i++) {
			cellLisTest.set(i,CellState.PATH );
		}
	
		cellLisTest.set(0,CellState.ENTRANCE );
		cellLisTest.set(15,CellState.EXIT );

	   mapValidator = new MapValidationManager(cellLisTest,30,15);
	   countMap = mapValidator.getCountMap();
	   middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
	   
	   assertFalse(middel.validate());
	}
	
	/**
	 * test entrance  In middle path
	 */
	@Test
	public void testEmteranceInMiddlePathValidator() {
		
		for (int i = 0; i < 20; i++) {
			cellLisTest.set(i,CellState.PATH );
		}
	
		cellLisTest.set(4,CellState.ENTRANCE );
		cellLisTest.set(19,CellState.EXIT );
		
		   mapValidator = new MapValidationManager(cellLisTest,30,15);
		   countMap = mapValidator.getCountMap();
		   middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
		   
		   assertFalse(middel.validate());
	}
	

	/**
	 * test no entrance or Exit  In middle path
	 */
	@Test
	public void testEnteranceNotInMiddlePathValidator() {
		
		for (int i = 0; i < 20; i++) {
			cellLisTest.set(i,CellState.PATH );
		}
		cellLisTest.set(0,CellState.ENTRANCE);
		cellLisTest.set(19,CellState.EXIT );
		mapValidator = new MapValidationManager(cellLisTest,30,15);
		countMap = mapValidator.getCountMap();
		middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
		assertTrue(middel.validate());
	}
	
//	/**
//	 * test  Extra Path
//	 */
//	@Test
//	public void ExtraPathValidator(){
//		
//		for (int i = 0; i < 21 ; i++) {
//			cellLisTest.set(i , CellState.PATH );
//	}
//		cellLisTest.set(0,CellState.ENTRANCE );
//		cellLisTest.set(19,CellState.EXIT );
//		
//		MapValidationManager mapValidator = new MapValidationManager(cellLisTest,20,15);
//		countMap = mapValidator.getCountMap();
//		boolean validate =new ExtraPathValidator(countMap,cellLisTest).validate();
//		assertFalse(validate);
//	}
//	
	/**
	 * test no Extra Path
	 */
	@Test
	public void noExtraPathValidator() {
	
		for (int i = 0; i < 20 ; i++) {
			cellLisTest.set(i , CellState.PATH );
	}
		cellLisTest.set(0,CellState.ENTRANCE );
		cellLisTest.set(19,CellState.EXIT );
		
		MapValidationManager mapValidator = new MapValidationManager(cellLisTest,20,15);
		countMap = mapValidator.getCountMap();
		boolean validate =new ExtraPathValidator(countMap,cellLisTest).validate();
		assertTrue(validate);
}	
}