package mapvalidation;

import gamemodel.gamemap.CellState;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class manage all map validation 
 *  
 * @author LiChong
 * @version 1.0 
 * @since 
 */
public class MapValidationManager {
	
	private ArrayList<CellState> cellList;
	private int Cols;
	private int Rows;
	private String errorMessage;
	private ArrayList<Integer> pathList;
	
	private HashMap<Integer,Integer> flagMap;
	private HashMap<Integer,Integer> countMap;
	
	public MapValidationManager(ArrayList<CellState> cellList, int mapCols, int mapRows){
		this.cellList = cellList;
		this.Cols = mapCols;
		this.Rows = mapRows;
		this.pathList = new ArrayList<Integer>();
		flagMap = new HashMap<Integer,Integer>();
		countMap = new HashMap<Integer,Integer>();

		setFlag();
		setPathList();
		setCountMap();
	}
/**
 * 	
 */
	private void setFlag(){
		for(int i=0;i<cellList.size();i++){
			if(0 < i && i < Cols){
				flagMap.put(i, 11);////upper bounds edge
			}else if((Cols * (Rows - 1)< i) 
					&& (i < (Cols * Rows - 1)) ){//lower bounds edge
				flagMap.put(i, 12);
			}else if(i== Cols * leftOrRightEdge()){//left edge
				flagMap.put(i, 13);
			}else if(i == Cols * leftOrRightEdge()-1){//Right edge
				flagMap.put(i, 14);
			}else if(i== 0){//upperleft point
				flagMap.put(i, 21);
			}else if(i == Cols){//upperright point
				flagMap.put(i, 22);
			}else if(i == Cols * (Rows - 1)){//lowerleft point
				flagMap.put(i, 23);
			}else if(i == (Cols * Rows - 1)){//lowerright point
				flagMap.put(i, 24);
			}else{
				flagMap.put(i, 0);//default value, presenting who has four neighbours
			}
		}
	}
/**
 * 
 * @return
 */
	private int leftOrRightEdge(){
		int i = 1;
		while(i < Rows){
			i++;
		}
		return i;
	}
/**
 * Store the critters path in a pathlist 
 */
	private void setPathList(){
		for(int i = 0;i<cellList.size();i++){//know the index of CellState.PATH
			if(cellList.get(i)== CellState.PATH || cellList.get(i)== CellState.ENTRANCE 
					|| cellList.get(i)== CellState.EXIT ){
				pathList.add(i);
			}
		}
	}
/**
 * 	
 */
	public void setCountMap(){//

		int iL = -1;//neighbour
		int iR = -1;
		int iU = -1;
		int iD = -1;
		int count = 0;
			
		 for(int i=0;i<pathList.size();i++){
			int posIndex = pathList.get(i);
			switch(flagMap.get(posIndex)){
			case 11:
				iL = posIndex -1;
				iR = posIndex +1;
				iD = posIndex + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 12:
				iL = posIndex -1;
				iR = posIndex +1;
				iU = posIndex - Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iU)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 13:
				iU = posIndex -Cols;
				iR = posIndex +1;
				iD = posIndex + Cols;
				
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 14:
				iL = posIndex -1;
				iU = posIndex -Cols;
				iD = posIndex + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 21:
				iR = posIndex +1;
				iD = posIndex + Cols;
				
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 22:
				iL = posIndex -1;
				iD = posIndex + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 23:
				iU = posIndex -Cols;
				iR = posIndex +1;
				
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iR)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			case 24:
				iL = posIndex -1;
				iU = posIndex - Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iU)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			default:
				iL = posIndex -1;
				iR = posIndex +1;
				iU = posIndex - Cols;
				iD = posIndex + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(posIndex, count);
				count = 0;
				break;
			
			}
		}
	}
/**
 * 	
 * @return
 */
	public HashMap<Integer, Integer> getCountMap() {
		return countMap;
	}
/*
	public int getCountEntranceOrExit(){
		for(int i=0;i<cellList.size();i++){
			if(cellList.get(i) == CellState.ENTRANCE) numberOfEntrance++;
			if(cellList.get(i) == CellState.EXIT) numberOfExit++;
		}
		if(numberOfEntrance == 0 || numberOfEntrance > 1 || numberOfExit == 0 || numberOfExit > 1){
			numberOfEntranceOrExit++;
		}
		return numberOfEntranceOrExit;
	}*/
	
/**
 * 	get error message  
 * @return error message
 */
	public String getErrorMessage(){
		return errorMessage;
	}
	
/**
 * set error message 	
 * @param errorMessage
 */
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
/**
 * 
 * This method set a  error message for each validation.
 * 
 *if map is not valid  the errormessage is set to type of validation error and return false.    
 * In the MapEditorWindow.java call 
 * 
 * <code>
 * MapValidationManager manager = new MapValidationManager(cellList, mCols, mRows);
 * if(new MapValidationManager().checkValidate()) saveMap();
 * else println(manager.getErrorMessage());
 * </code>
 * 
 * @return true if it's validate
 */ 
	public boolean checkValidate(){
		
		if (!new NoEntranceNoExitMoreEntranceMoreExitValidator(cellList).validate()){
			errorMessage = "Entrance or Exit of Path is illegal!";
			return false;
		}else if(! new EntranceExitInMiddlePathValidator(cellList, countMap).validate()){
			errorMessage = "The Entrance or Exit is not in the end cell";
			return false;
		}else if(! new LengthValidator(cellList).validate()){
			errorMessage = "The length of path is illegal!";
			return false;
		}else if(! new CirclePathValidator(countMap).validate()){
			errorMessage = "Path cannot be a circle!";
			return false;	
		}else if(! new ExtraPathValidator(countMap, cellList).validate()){
			errorMessage = "There is extra path in your map!";
			return false;
		}else if(! new ContinousPathValidator(countMap).validate()){
			errorMessage = "Your path is not continous!";
			return false;	
		}else if(! new SeperateEntranceAndExitValidator(Cols, cellList).validate()){
			errorMessage = "Entrance can not be the neighbour of Exit!";
			return false;
		}else {
			errorMessage = "";
			return true;
		}
	}
	
		
}




