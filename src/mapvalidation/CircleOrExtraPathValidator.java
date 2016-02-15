package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.CellState;

/**
 * This class is to validate whether there is circle or extra path in map.
 * Having circle path in map is illegal.
 * Having extra path in map is illegal.
 * 
 * @author LiChong
 *
 */
public class CircleOrExtraPathValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private HashMap<Integer,Integer> ceMap;
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< cellList.size(); i++){
			if(ceMap.containsValue(3)|| ceMap.containsValue(4)){
				return false;
			}
		}
		
		return true;
	}

	public CircleOrExtraPathValidator(HashMap<Integer,Integer> countMap){
		this.ceMap = countMap;
	}

}
