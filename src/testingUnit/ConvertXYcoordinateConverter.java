package testingUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.drawing.Drawing;


/**
 * test coordinate converter from x and y coordinate to index and vice versa
 * 
 * @author m_lzahra
 *@version 1.0
 *@since 14/2/2016
 */
public class ConvertXYcoordinateConverter {
 
	/**
	 * test coordinate converter from x and y coordinate to index
	 */
	@Test
	public void testIndex() {
	
		int expected = 0 ;	
		int result= Drawing.coordinateToIndexConverter(0, 0, 10);
		
		assertTrue(expected == result);
	}
	/**
	 * 
	 * test coordinate converter from index to x and y coordinate 
	 */
	@Test
	public void testXYCoordinate() {
		
		int[] arr = Drawing.indexToCoordinateConverter(0, 10);
		
		assertEquals(arr[0], 0);
		assertEquals(arr[1], 0);
	}
	
	

}