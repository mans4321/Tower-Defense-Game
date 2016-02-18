package gamemodel.gamemap;

import java.util.ArrayList;

/**
 * This class initialize the parameters for the game maps.
 * 
 *it also return and set these parameters.
 *Each  map has number of rows and columns,the map image, and cellStates storied in ArrayList.
 *
 *@author yongpinggao 
 *@since 1/26/16.
 *@version 1.0
 */
public class GameMap {

    private ArrayList<CellState> cells;
    private int mCols;
    private int mRows;
    private String imageName;

/**
 * A constructor initialize the parameters for the game maps.
 * @param mapRows   number of Rows
 * @param mapCols   number of columns 
 * @param cells     ArrayList for the map cells state  
 * @param imageName  map image name                          // make sure 
 */
    public GameMap(int mapRows, int mapCols, ArrayList<CellState> cells, String imageName) {
        this.cells = cells;
        this.mCols = mapCols;
        this.mRows = mapRows;
        this.imageName = imageName;

    }
/**
 * get each cell states of the map 
 * @return each cell states of the map 
 */
    public ArrayList<CellState> getCells() {
        return cells;
    }
/**
* get the map number of columns  
* @return the map number of columns 
*/
    public int getmCols() {
        return mCols;
    }
/**
 * get the map number of rows 
 * @return the map number of rows
 */
    public int getmRows() {
        return mRows;
    }
/**
 * get the image name 
 * @return the image name
 */
    public String getImageName() {
        return imageName;
    }

}





