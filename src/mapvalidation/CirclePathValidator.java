package mapvalidation;

import java.util.HashMap;

/**
 * This class is to validate whether the path is in a circle
 * 
 * @version 1.2
 * 
 * @author LiChong
 * 
 */

public class CirclePathValidator implements MapValidator{

	private HashMap<Integer, Integer> countMap;
	
	/**
	 * This method validate() overrides the method validate() of parent class MapValidator. 
	 * And it checks whether the path contains a circle.
	 * 
	 * {@inheritDoc}
	 * @return boolean A boolean values that represent whether the path contains a circle.
	 * 
	 */	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		for(Integer i : countMap.values()){
			if(i == 2) continue;
			else return true;
		}
		
		return false;
	}
/**
 *Class constructor validate whether the path is in a circle.
 * 	
 * @param countMap
 */
	public CirclePathValidator(HashMap<Integer, Integer> countMap){
		this.countMap = countMap;
	}

}
