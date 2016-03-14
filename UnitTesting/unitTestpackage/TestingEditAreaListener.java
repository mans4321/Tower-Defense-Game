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

public class TestingEditAreaListener {

	EditAreaListener editAreaListener;
	private ArrayList<CellState> cellList;
	
	@Before
	public void setValus(){
		
		cellList = new ArrayList<CellState>();
		 for(int i = 0; i < 15 * 30; i++){
             cellList.add(CellState.PATH);
		 }
		 
		 editAreaListener = new EditAreaListener(15, 30, 0, cellList);	 
	}
	
	@Test
	public void testClear() {
		
		editAreaListener.clearMap();
		
		cellList = editAreaListener.getCellList();
		
		assertFalse(cellList.contains(CellState.PATH));
		
	}
	
	@Test
	public void testCaptureImage() {
	
		BufferedImage image = editAreaListener.mapCaptureShot();
		
		assertFalse(image == null);
}
	
}