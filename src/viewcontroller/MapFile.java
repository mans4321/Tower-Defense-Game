package viewcontroller;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;
import gamemodel.gamemap.FileProcessing;
import gamemodel.gamemap.GameMap;
import gamemodel.gamemap.GameMapCollection;
import gamemodel.tower.Tower;

/**
 * A class to read map for Json file 
 * @author m_lzahra
 *@since 13/3/2016
 *@version 1.0
 */
public  class MapFile { 
   
	 private int mapRows;
	 private int mapCols;
	
	 private ArrayList<CellState> cellList;
	 private ArrayList<Integer> pathList;
	 private HashMap<Integer, Tower> towerMap;
	 
	 private int[] extrancePos;
	 private int[] exitPos;
	 
	 private GameMap map;
	 private MapArea mapArea;

	 public MapFile(int mapNum){
		 
		 readSpecificMapFromFile( mapNum);
		 
	 }
	 /**
	  * read specific map from json file
	  * @param mapNum map number
	  */
	public void  readSpecificMapFromFile(int mapNum){	  
	     
   	 // read data from saved files
       GameMapCollection mapCollection = FileProcessing.readMapFromJsonFile();
       map = mapCollection.getMaps().get(mapNum);
     
       pathList = new ArrayList<>();
       cellList = map.getCells();
       mapCols = map.getmCols();
       mapRows = map.getmRows();
       towerMap = new HashMap<>();

       //Find the path, entrance and exit cell
       for(int i = 0; i < cellList.size() ; i++) {
           if (cellList.get(i) == CellState.ENTRANCE) { // Entrance -> indexEntrance
               extrancePos = DrawMap.indexConverter(i, mapCols);
           } else if (cellList.get(i) == CellState.PATH) { // PATH -> pathList
               pathList.add(i);
           } else if (cellList.get(i) == CellState.EXIT) { // Exit -> indexExit
               exitPos = DrawMap.indexConverter(i, mapCols);
           }
   	
         
   }
       mapArea = new MapArea(mapRows , mapCols , cellList, towerMap);
   }
	

	
	
	/**
     * Getter for entrance position
     * @return entrance position
     */
    public int[] getExtrancePos() {
        
		return extrancePos;
    }
    
    /**
     * Getter for the exit position
     * @return exit position
     */
    public int[] getExitPos() {
        return exitPos;
    }
	
    /**
     * Getter for the map area
     * @return map area
     */
    public MapArea getMapArea() {
        return mapArea;
    }
    
    /**
     * Getter for teh path list
     * @return path list
     */
    public ArrayList<Integer> getPathList() {
        return pathList;
    }
/**
 * 
 * @return number of columns 
 */
	public int getCols() {
		return mapCols;
	}

}
