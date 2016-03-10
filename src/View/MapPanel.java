package View;
import gamemodel.critter.*;
import gamemodel.gamemap.*;
import gamemodel.tower.*;
import viewcontroller.DrawCritter;
import viewcontroller.DrawMap;
import viewcontroller.DrawTower;
import viewcontroller.MapArea;
import viewcontroller.PlaceTowerFinishedListener;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yongpinggao
 * @since 1/30/16
 *
 */
public class MapPanel extends JPanel {

    private MapArea mapArea;
    private int rows;
    private int cols;
    private GameMap map;
    private ArrayList<CellState> cellList;
    private HashMap<Integer, Tower> towerMap;
    private ArrayList<Integer> pathList;
   

    private int[] extrancePos;
    private int[] exitPos;
    
    

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
     * Getter for teh path list
     * @return path list
     */
    public ArrayList<Integer> getPathList() {
        return pathList;
    }

    /**
     * Getter for the map area
     * @return map area
     */
    public MapArea getMapArea() {
        return mapArea;
    }


    /**
     * Constructor for the map panel
     * @param mapNum number of the map
     */
    public MapPanel(int mapNum) {

        // read data from saved files
        GameMapCollection mapCollection = FileProcessing.readMapFromJsonFile();
        map = mapCollection.getMaps().get(mapNum);
        cellList = map.getCells();
        cols = map.getmCols();
        rows = map.getmRows();

        pathList = new ArrayList<>();
        towerMap = new HashMap<>();

        //Find the path, entrance and exit cell
        for(int i = 0; i < cellList.size() ; i++) {
            if (cellList.get(i) == CellState.ENTRANCE) { // Entrance -> indexEntrance
                extrancePos = DrawMap.indexConverter(i, cols);
            } else if (cellList.get(i) == CellState.PATH) { // PATH -> pathList
                pathList.add(i);
            } else if (cellList.get(i) == CellState.EXIT) { // Exit -> indexExit
                exitPos = DrawMap.indexConverter(i, cols);
            }
        }

      
        initComponent();

    }
    
    /**
     * Initiates the Map panel 
     */
    private void initComponent() {
        mapArea = new MapArea(rows , cols , cellList, towerMap);
        setBackground(Color.BLACK);
        // set MapArea to the center
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapArea, c);
    }




}