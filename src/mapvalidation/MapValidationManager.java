package mapvalidation;

import gamemodel.CellState;

import java.util.ArrayList;
import java.util.HashMap;



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

	private int leftOrRightEdge(){
		int i = 1;
		while(i < Rows){
			i++;
		}
		return i;
	}

	private void setPathList(){
		for(int i = 0;i<cellList.size();i++){//know the index of CellState.PATH
			if(cellList.get(i)== CellState.PATH || cellList.get(i)== CellState.ENTRANCE 
					|| cellList.get(i)== CellState.EXIT ){
				pathList.add(i);
			}
		}
	}
	
	public void setCountMap(){//

		int iL = -1;//neighbour
		int iR = -1;
		int iU = -1;
		int iD = -1;
		int count = 0;
			
		 for(int i=0;i<pathList.size();i++){
			switch(flagMap.get(i)){
			case 11:
				iL = i -1;
				iR = i +1;
				iD = i + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 12:
				iL = i -1;
				iR = i +1;
				iU = i - Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iU)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 13:
				iU = i -Cols;
				iR = i +1;
				iD = i + Cols;
				
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 14:
				iL = i -1;
				iU = i -Cols;
				iD = i + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 21:
				iR = i +1;
				iD = i + Cols;
				
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 22:
				iL = i -1;
				iD = i + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 23:
				iU = i -Cols;
				iR = i +1;
				
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iR)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			case 24:
				iL = i -1;
				iU = i - Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iU)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			default:
				iL = i -1;
				iR = i +1;
				iU = i - Cols;
				iD = i + Cols;
				
				if(pathList.contains(iL)){count++;}
				if(pathList.contains(iR)){count++;}
				if(pathList.contains(iU)){count++;}
				if(pathList.contains(iD)){count++;}
				countMap.put(i, count);
				count = 0;
				break;
			
			}
		}
	}
	
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
	
	
	public String getErrorMessage(){
		return errorMessage;
	}
	
	
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	/**
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
	
	// 这个manager类里所有的变量都已经得到了，其中包括cellstate，pathstate,countmap,flagmap，rols,cols.
	// NoEntranceNoExitMoreEntranceMoreExitValidator
	// LengthValidator
	// CircleOrExtraPathValidator
	// ContinousPathValidator
	// 上面这几个类，需要什么变量，就可以在他们的构造函数里加入这些变量。
	// 比如： CircleOrExtraPathValidator() 需要 countmap
	// 首先在底下的代码改成 “new CircleOrExtraPathValidator(countmap)”
	// 然后在 CircleOrExtraPathValidator.java 里， 
	// 实现 CircleOrExtraPathValidator(HashMap<Iteger, Integer> countMap){根据countmap, 实现validate()}
	
	public boolean checkValidate(){
		
		/*
		new NoEntranceNoExitMoreEntranceMoreExitValidator(0);
		new LengthValidator();
		new CircleOrExtraPathValidator(countMap);
		new ContinousPathValidator(countMap);
		new SeperateEntranceAndExitValidator(Cols);
		
		if (!new NoEntranceNoExitMoreEntranceMoreExitValidator(0).validate()){
			errorMessage = "EntranceExit Problem!";
			return false;//???
		}else if(! new LengthValidator().validate()){
			errorMessage = "length problem!";
			return false;
		}else if(! new CircleOrExtraPathValidator(countMap).validate()){
			errorMessage = "Circle problem!";
			return false;
		}else if(! new ContinousPathValidator(countMap).validate()){
			errorMessage = "Path is not continous!";
			return false;	
		}else if(! new SeperateEntranceAndExitValidator(Cols).validate()){
			errorMessage = "Entrance can not be the neighbour of Exit!";
			return false;
		}else {
			errorMessage = "";
			return true;
		}
		*/
		return true;
	}
	
		
}




