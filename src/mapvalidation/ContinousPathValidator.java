package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;

/**
 * This class is to validate whether the path in map is consecutive.
 * Having gap in path is illegal.
 * 
 * @version 1.3
 * 
 * @author LiChong
 *
 */
public class ContinousPathValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private HashMap<Integer,Integer> cMap;
	//private ArrayList<CellState> pathList;
	private int Cols;
 
	/**
	 * This method validate() overrides the method validate() of parent class MapValidator. 
	 * And it checks whether the path is continous.
	 * 
	 * @return boolean A boolean values that represent whether the path is continous.
	 * 
	 */	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		
		for(int i = 0;i < cellList.size(); i++){
			if(cellList.get(i) == CellState.PATH 
					&& cMap.get(i) == 0){//some path grid alone
				return false;
			}else if(cellList.get(i) == CellState.PATH 
					&& cMap.get(i) == 1){//path break in somewhere
				if(cellList.get(i-1) == CellState.ENTRANCE
						||cellList.get(i-1) == CellState.EXIT
						||cellList.get(i+1) == CellState.ENTRANCE
						||cellList.get(i+1) == CellState.EXIT
						||cellList.get(i-Cols) == CellState.ENTRANCE
						||cellList.get(i-Cols) == CellState.EXIT
						||cellList.get(i+Cols) == CellState.ENTRANCE
						||cellList.get(i+Cols) == CellState.EXIT){
					return true;
				}else{
					return false;
					}
			}
		}
		
		return true;
	}
	
	
	public ContinousPathValidator(HashMap<Integer,Integer> countMap,ArrayList<CellState> cellList, int mapCols){
		this.cMap = countMap;
		this.cellList = cellList;
		this.Cols = mapCols;
 
	}
	
}
