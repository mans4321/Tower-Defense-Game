package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.Test;

import viewcontroller.DrawMap;

public class ConvertXY {

	@Test
	public void test() {
		
		
		int ex = 0 ;
		
		int res= DrawMap.coordinateConverter(0, 0, 0);
		
		assertTrue(ex == res);
		
		//fail("Not yet implemented");
	}

}
