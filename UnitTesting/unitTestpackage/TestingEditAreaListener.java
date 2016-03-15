package unitTestpackage;

import static org.junit.Assert.*;

import java.awt.Event;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import gamemodel.gamemap.CellState;
import viewcontroller.EditAreaListener;

/**
 * test clear and  Capture Image functions for the map Editor
 *  
 * @author m_lzahra
 * @version 1.0
 * @since 14/3/2016
 */
public class TestingEditAreaListener {

	EditAreaListener editAreaListener;
	private ArrayList<CellState> cellList;
	
	/**
	 * setting the values to be used in the test 
	 */
	@Before
	public void setValus() {
		
		cellList = new ArrayList<CellState>();
		
		 for(int i = 0; i < 15 * 30; i++){
             cellList.add(CellState.PATH);
		 }
		 
		 editAreaListener = new EditAreaListener(15, 30, 0, cellList);	 
	}
	
	/**
	 * test clear map
	 */
	@Test
	public void testClear() {
		
		editAreaListener.clearMap();
		cellList = editAreaListener.getCellList();
		
		assertFalse(cellList.contains(CellState.PATH));
	}
	
	/**
	 * test Capture Image for the map
	 */
	@Test
	public void testCaptureImage() {
	
		BufferedImage image = editAreaListener.mapCaptureShot();
		
		assertFalse(image == null);
}
	
}