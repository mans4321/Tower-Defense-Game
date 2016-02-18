package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utility.Utility;

public class MaxValueTest {
	private String[] arr;
//	 public static int getMaxValueFrom(String[] strArr) {
	@Before
	public void beforeTest(){
		arr = new String[]{"11","21","41","31","1"};
	}
	
	@Test
	public void maxValueTest(){
		assertEquals(41,Utility.getMaxValueFrom(arr));
	}
}
