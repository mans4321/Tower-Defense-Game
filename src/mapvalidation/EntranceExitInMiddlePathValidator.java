package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;

/**
 * This class is to validate whether Entrance or Exit is in the middle of the path.
 *
 * @author LiChong
 *
 */
public class EntranceExitInMiddlePathValidator implements MapValidator {

    private ArrayList<CellState> cellList;
    private HashMap<Integer, Integer> countMap;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        // TODO Auto-generated method stub
        
        for (int i = 0; i < cellList.size(); i++) {
            if (cellList.get(i) == CellState.ENTRANCE) {
                if (countMap.get(i) == 2) {
                    return false;
                } else {
                    continue;
                }
            } else if (cellList.get(i) == CellState.EXIT) {
                if (countMap.get(i) == 2) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

     /**
      * Sets the Map and cell list for validation.
      * @param cellList ArrayList of map
      * @param countMap HashMap 
      */
    public EntranceExitInMiddlePathValidator(ArrayList<CellState> cellList, HashMap<Integer, Integer> countMap) {
        this.cellList = cellList;
        this.countMap = countMap;
    }
}
