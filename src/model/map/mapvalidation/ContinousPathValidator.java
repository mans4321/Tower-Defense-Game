package model.map.mapvalidation;

import model.map.mapvalidation.MapValidator;
import java.util.ArrayList;
import java.util.HashMap;
import model.map.CellState;


/**
 * This class is to validate whether the path in map is consecutive.
 * Having gap in path is illegal.
 * 
 * @author LiChong
 *
 */
public class ContinousPathValidator implements MapValidator {
	
	private ArrayList<CellState> cellList;
    private HashMap<Integer,Integer> cMap;
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
 			if(cellList.get(i) == CellState.Path 
 					&& cMap.get(i) == 0){//some path grid alone
 				return false;
 			}else if(cellList.get(i) == CellState.Path
 					&& cMap.get(i) == 1){//path break in somewhere
 				if(cellList.get(i-1) == CellState.Entrance
 						||cellList.get(i-1) == CellState.Exit
 						||cellList.get(i+1) == CellState.Entrance
 						||cellList.get(i+1) == CellState.Exit
 						||cellList.get(i-Cols) == CellState.Entrance
 						||cellList.get(i-Cols) == CellState.Exit
 						||cellList.get(i+Cols) == CellState.Entrance
 						||cellList.get(i+Cols) == CellState.Exit){
 					return true;
 				}else{
 					return false;
 					}
 			}
 		}
 		
 		return true;
 	}
    
    /**
     * Setter to the validator property.
     * @param countMap HashMap validator
     */
 	public ContinousPathValidator(HashMap<Integer,Integer> countMap,ArrayList<CellState> cellList, int mapCols){
 		 		this.cMap = countMap;
 		 		this.cellList = cellList;
 		 		this.Cols = mapCols;
 		  
 		 	}
 		 	
 		 }
