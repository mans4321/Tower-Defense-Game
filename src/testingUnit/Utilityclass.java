package testingUnit;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;

import utility.Helper;

/**
 * test Utility class 
 * 
 * @author m_lzahra
 *@version 1.0
 *@since 14/2/2016
 */
public class Utilityclass {

	
	private String[] arr;
	
	/**
	 * setting values 
	 */
	@Before
	public void setValues() {
		
		arr = new String[]{"11","21","41","31","1"};
	}
	
	/**
	 * test get the maximum values function
	 */
	@Test
	public void maxValueTest() {
		
		assertEquals(41,Helper.getMaxValueFrom(arr));
	}
	
	/**
	 * test get scaled dimension
	 */
	@Test
	public void getScaledDimension() {
		
		Dimension imgSize = new Dimension(500, 100);
		Dimension boundary = new Dimension(200, 200);
		
		Dimension newDimension = Helper.getScaledDimension(imgSize, boundary);
		assertTrue((int)newDimension.getWidth() == 200);
		assertTrue((int)newDimension.getHeight() == 40);
		
		
	}
}
