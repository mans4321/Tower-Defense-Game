package unitTestpackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import gamemodel.gamemap.CellState;
import viewcontroller.MapFile;

public class EntranceExit {

	private MapFile mapFile;

	@Before
	public void setValus(){
		
	
		  mapFile = new MapFile(1);
	}
		 
	@Test
	public void getExtrancePos() {
		
		
		System.out.println(mapFile.getExtrancePos());
		assertTrue(mapFile.getExtrancePos().length != 0);

	}
	
	@Test
	public void getExitPos() {
	
		System.out.println(mapFile.getExitPos());
		assertTrue(mapFile.getExitPos().length != 0);
}
}
