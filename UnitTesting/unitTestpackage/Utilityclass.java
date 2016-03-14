package unitTestpackage;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;

import utility.Utility;

public class Utilityclass {

	
	private String[] arr;
	
	
	@Before
	public void beforeTest(){
		arr = new String[]{"11","21","41","31","1"};
	}
	
	@Test
	public void maxValueTest(){
		assertEquals(41,Utility.getMaxValueFrom(arr));
	}
	
	
	@Test
	public void getScaledDimension(){
		
		Dimension imgSize = new Dimension(500, 100);
		Dimension boundary = new Dimension(200, 200);
		
		Dimension newDimension = Utility.getScaledDimension(imgSize, boundary);
		assertTrue((int)newDimension.getWidth() == 200);
		assertTrue((int)newDimension.getHeight() == 40);
		
		
	}
	
	
	
}
