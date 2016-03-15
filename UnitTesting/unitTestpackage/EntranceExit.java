package unitTestpackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import gamemodel.gamemap.CellState;
import viewcontroller.MapFile;
/**
 * test getting the exist and entrance form map file
 * 
 *@author m_lzahra
 *@version 1.0
 *@since 14/3/2016
 */
public class EntranceExit {

	private MapFile mapFile;

	/**
	 * seeting the pointer for mapFile
	 */
	@Before
	public void setValus() {
		
		  mapFile = new MapFile(1);
	}
	
	/**
	 * test get the entrance 
	 */
	@Test
	public void getExtrancePos() {
		
		System.out.println(mapFile.getExtrancePos());
		assertTrue(mapFile.getExtrancePos().length != 0);

	}
	
	/**
	 *test get the exist 
	 */
	@Test
	public void getExitPos() {
	
		System.out.println(mapFile.getExitPos());
		assertTrue(mapFile.getExitPos().length != 0);
}
}
