package unitTestpackage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

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

public class validatemap {

	private ArrayList<CellState> cellLisTest;
	private HashMap<Integer, Integer> countMap;
	
	@Test
	public void testNoEnEX() {
		
		
		cellLisTest = new ArrayList<CellState>();
		
		for (int i = 0; i < 20; i++) {
			
			cellLisTest.add(CellState.GRASS );
			}
		
		NoEntranceNoExitMoreEntranceMoreExitValidator  NEE = new NoEntranceNoExitMoreEntranceMoreExitValidator(cellLisTest);
		
		boolean Re = NEE.validate();
		

		assertFalse(Re);
		
	
		
		}
		
	@Test
	public void testSeperateEnex() {
		
		cellLisTest= new ArrayList<CellState>();
		
		for (int i = 0; i < 20; i++) {
			
			cellLisTest.add(CellState.GRASS );}
		
		cellLisTest.set(0,CellState.ENTRANCE);
		cellLisTest.set(19,CellState.EXIT);
		
		SeperateEntranceAndExitValidator SENEX = new SeperateEntranceAndExitValidator(10,cellLisTest);
		
		boolean testSeperateEnex = SENEX.validate();
		
		assertTrue(testSeperateEnex);
	}
	
	@Test
	public void testToshortmaP() {
		
		cellLisTest= new ArrayList<CellState>();
	
		
	for (int i = 0; i < 9; i++) {
		
		cellLisTest.add(CellState.GRASS );
		}

	LengthValidator lengthValidator = new LengthValidator(cellLisTest);
	
	boolean testToshortmaP = lengthValidator.validate();
	
	assertFalse(testToshortmaP);
}
	
	@Test
	public void testCirclePathValidator() {
	
		countMap = new HashMap<Integer, Integer>();
		
		for(int i= 0 ; i < 7 ; i++){
		countMap.put(i, i);
		}
		CirclePathValidator circlePathValidator = new CirclePathValidator(countMap);
		
		 boolean testcirclePathValidator = circlePathValidator.validate();
		 assertTrue(testcirclePathValidator);
		 
//			for(int i= 3 ; i < 7 ; i++){
//				countMap.put(i, i);
//				}
//			
//		 circlePathValidator = new CirclePathValidator(countMap);
//		 assertTrue(testcirclePathValidator);
}
	@Test
	public void testContinousPathValidator() {
	
		countMap = new HashMap<Integer, Integer>();
		
		for(int i= 0 ; i < 7 ; i++){
		countMap.put(i, i);
		}
		
		ContinousPathValidator testPath = new ContinousPathValidator(countMap);
		
		boolean testContinousPath =testPath.validate();
		
		assertFalse(testContinousPath);
		
//		countMap.remove(0);
//		testPath = new ContinousPathValidator(countMap);
//		assertTrue(testContinousPath);
	}
	@Test
	public void testEntranceExitInMiddlePathValidator(){
		
		countMap = new HashMap<Integer, Integer>();
		EntranceExitInMiddlePathValidator middel;
		cellLisTest= new ArrayList<CellState>();
		
		for (int i = 0; i < 9; i++) {
			cellLisTest.add(CellState.GRASS );
			}
	
		cellLisTest.set(0,CellState.ENTRANCE );
		cellLisTest.set(8,CellState.EXIT );
		
		MapValidationManager mapValidator = new MapValidationManager(cellLisTest,6,6);
		countMap = mapValidator.getCountMap();
		middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
		assertTrue(middel.validate());
		
//	   cellLisTest.set(4,CellState.ENTRANCE );
//	   mapValidator = new MapValidationManager(cellLisTest,6,6);
//	   countMap = mapValidator.getCountMap();
//	   middel = new EntranceExitInMiddlePathValidator(cellLisTest, countMap);
//	   assertTrue(middel.validate());
	}
	
	@Test
	public void ExtraPathValidator(){
		
	cellLisTest= new ArrayList<CellState>();
	countMap = new HashMap<Integer, Integer>();
	
		for (int i = 0; i < 20*15 ; i++) {
		
			cellLisTest.add(CellState.GRASS );
			if(i >= 0 || i <= 20){
				cellLisTest.set(i, CellState.PATH);
			}
	}
		cellLisTest.set(0,CellState.ENTRANCE );
		cellLisTest.set(19,CellState.EXIT );
		
		MapValidationManager mapValidator = new MapValidationManager(cellLisTest,20,15);
		countMap = mapValidator.getCountMap();
		boolean validate =new ExtraPathValidator(countMap,cellLisTest).validate();
		assertFalse(validate);
}
}