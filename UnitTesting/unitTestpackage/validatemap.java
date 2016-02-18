package unitTestpackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import gamemodel.gamemap.CellState;
import mapvalidation.LengthValidator;
import mapvalidation.NoEntranceNoExitMoreEntranceMoreExitValidator;
import mapvalidation.SeperateEntranceAndExitValidator;

public class validatemap {

	
	@Test
	public void testNoEnEX() {
		
		ArrayList<CellState> cellListtest= new ArrayList<CellState>();
		
		for (int i = 0; i < 20; i++) {
			
			cellListtest.add(CellState.GRASS );}
		
		NoEntranceNoExitMoreEntranceMoreExitValidator  NEE = new NoEntranceNoExitMoreEntranceMoreExitValidator(cellListtest);
		
		boolean Re = NEE.validate();
		

		assertFalse(Re);
		
	
		
		}
		
	@Test
	public void testSeperateEnex() {
		
ArrayList<CellState> cellListtest= new ArrayList<CellState>();
		
		for (int i = 0; i < 20; i++) {
			
			cellListtest.add(CellState.GRASS );}
		
		cellListtest.set(0,CellState.ENTRANCE);
		cellListtest.set(19,CellState.EXIT);
		
		SeperateEntranceAndExitValidator SENEX = new SeperateEntranceAndExitValidator(10,cellListtest);
		
		boolean Re = SENEX.validate();
		
		assertTrue(Re);
	}
	
	@Test
	public void testToshortmAP() {
		
		ArrayList<CellState> cellListtest= new ArrayList<CellState>();
	
		
	for (int i = 0; i < 9; i++) {
		
		cellListtest.add(CellState.GRASS );}

	LengthValidator lengthValidator = new LengthValidator(cellListtest);
	
	boolean Re = lengthValidator.validate();
	
	assertFalse(Re);
}
	
	
}
