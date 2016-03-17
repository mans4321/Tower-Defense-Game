package model.map;

import java.util.ArrayList;

/**
 * GameMap class for the Game
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */

public class GameMap {
    // cell image size in pixels


    private ArrayList<CellState> cells;
    private int mCols;
    private int mRows;
    private String imageName;

    /**
     * Constructor for game map
     * @param mapRows map rows
     * @param mapCols map cols 
     * @param cells map cells
     * @param imageName image name for image
     */
    public GameMap(int mapRows, int mapCols, ArrayList<CellState> cells, String imageName) {
        this.cells = cells;
        this.mCols = mapCols;
        this.mRows = mapRows;
        this.imageName = imageName;

    }

    /**
     * Default Constructor
     */
    public GameMap() {
        int mCols = 30;
        int mRows = 15;
        ArrayList<CellState> cells = new ArrayList<>();
        for(int i = 0; i < mCols * mRows; i++){
            cells.add(CellState.Grass);
        }
        String imageName = "";

        this.cells = cells;
        this.mCols = mCols;
        this.mRows = mRows;
        this.imageName = imageName;
    }

    /**
     * all cell state of map
     * getter method
     * @return
     */
    public ArrayList<CellState> getCells() {
        return cells;
    }

    /**
     * all cell state of map
     * setter method
     * @return
     */
    public void setCells(ArrayList<CellState> cells) {
        this.cells = cells;
    }

    /**
     * cols of the map
     * getter method
     * @return
     */
    public int getmCols() {
        return mCols;
    }

    /**
     * cols of the map
     * setter method
     * @return
     */
    public void setmCols(int mCols) {
        this.mCols = mCols;
    }

    /**
     * rows of map
     * getter method
     * @return
     */
    public int getmRows() {
        return mRows;
    }

    /**
     * rows of map
     * setter method
     * @return
     */
    public void setmRows(int mRows) {
        this.mRows = mRows;
    }

    /**
     * image name of game map
     * getter method
     * @return
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * image name of game map
     * setter method
     * @return
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * change cell state from grass to toPlaceTower state
     */
    public void setToPlaceTowerState() {
        for(int i = 0; i < cells.size(); i++){
            if(cells.get(i) == CellState.Grass){
                cells.set(i, CellState.ToPlaceTower);
            } else if(cells.get(i) == CellState.Chosen){
                cells.set(i, CellState.Tower);
            }
        }
    }

    /**
     * change toPlaceTower state back to grass state
     */ 
    public void setToGrassState(){
        for(int i = 0; i < cells.size(); i++){
            if(cells.get(i) == CellState.ToPlaceTower){
                cells.set(i, CellState.Grass);
            }
        }
    }

    /**
     * toggle chosen state of cell
     * @param index the index of cells
     */
    public void toggleChosenState(int index){

        for(int i = 0; i < cells.size(); i++){
            if(cells.get(i) == CellState.Chosen){
                cells.set(i, CellState.Tower);
            }
        }
        cells.set(index, CellState.Chosen);
    }

    /**
     * set state back to grass
     */
    public void clearState(){
        // if the user press the wrong cells, aka path, etc.
        // set state back to grass
        for(int i = 0; i < cells.size(); i++){
            if (cells.get(i) == CellState.Chosen){
                cells.set(i, CellState.Tower);
            } else if (cells.get(i) == CellState.ToPlaceTower){
                cells.set(i, CellState.Grass);
            }

        }
    }

    /**
     * find exit index of game map
     * @return
     */
    public int findExitIndex(){
        for(int i = 0; i < cells.size() ; i++){
            if(cells.get(i) == CellState.Exit){ // Entrance -> indexEntrance
                return i;
            }
        }
        return -1;
    }

    /**
     * find entrance index of game map
     * @return
     */
    public int findEntranceIndex(){
        for(int i = 0; i < cells.size() ; i++){
            if(cells.get(i) == CellState.Entrance){ // Entrance -> indexEntrance
                return i;
            }
        }
        return -1;
    }

    /**
     * find path list of the game map
     * @return
     */
    public ArrayList<Integer> findPathList(){
        ArrayList<Integer> pathList = new ArrayList<>();
        for(int i = 0; i < cells.size() ; i++){
            if(cells.get(i) == CellState.Path){ // PATH -> pathList
                pathList.add(i);
            }
        }
        return pathList;

    }




}





