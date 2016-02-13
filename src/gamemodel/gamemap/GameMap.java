package gamemodel.gamemap;

import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/26/16.
 */
public class GameMap {

    private ArrayList<CellState> cells;
    private int mCols;
    private int mRows;
    private String imageName;


    public GameMap(int mapRows, int mapCols, ArrayList<CellState> cells, String imageName){
        this.cells = cells;
        this.mCols = mapCols;
        this.mRows = mapRows;
        this.imageName = imageName;

    }

    public ArrayList<CellState> getCells() {
        return cells;
    }

    public int getmCols() {
        return mCols;
    }

    public int getmRows() {
        return mRows;
    }

    public String getImageName() {
        return imageName;
    }

}





