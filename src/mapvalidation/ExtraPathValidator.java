package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;

/**
 * This class is to validate whether there is circle or extra path in map.
 * Having circle path in map is illegal.
 * Having extra path in map is illegal.
 * 
 * @version 1.2
 * 
 * @author LiChong
 * 
 */
public class ExtraPathValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private HashMap<Integer,Integer> ceMap;
	
	/**
	 * This method validate() overrides the method validate() of parent class MapValidator. 
	 * And it checks whether the path is extra path.
	 * 
	 * @return boolean A boolean values that represent whether the path is extra path.
	 * 
	 */	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< cellList.size(); i++){
			if(ceMap.containsValue(3)|| ceMap.containsValue(4)){
				return false;  // extra path
			}
		 
		}
		
		return true;
	}

	public ExtraPathValidator(HashMap<Integer,Integer> countMap, ArrayList<CellState> cellList){
		this.cellList = cellList;
		this.ceMap = countMap;
	}

}
