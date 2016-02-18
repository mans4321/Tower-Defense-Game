package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.Test;

import viewcontroller.DrawMap;

public class ConvertXYcoordinateConverter {

	@Test
	public void test() {
		
		
		int ex = 0 ;
		
		int res= DrawMap.coordinateConverter(0, 0, 10);
		
		assertTrue(ex == res);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetxy() {
		
		
		int[] arr = DrawMap.indexConverter(0, 10);
		assertEquals(arr[0], 0);
		assertEquals(arr[1], 0);
	}
	
	

}
