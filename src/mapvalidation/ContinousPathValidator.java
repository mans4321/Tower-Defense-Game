package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.CellState;

/**
 * This class is to validate whether the path in map is consecutive.
 * Having gap in path is illegal.
 * 
 * @author LiChong
 *
 */
public class ContinousPathValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private HashMap<Integer,Integer> cMap;
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < cellList.size(); i++){
			if(cMap.containsValue(0)){
				return false;
			}
		}
		return true;
		
	}
	
	public ContinousPathValidator(HashMap<Integer,Integer> countMap){
		this.cMap = countMap;
	}
	
}
