package View;
import gamemodel.critter.*;
import gamemodel.gamemap.*;
import gamemodel.tower.*;
import viewcontroller.DrawCritter;
import viewcontroller.DrawMap;
import viewcontroller.DrawTower;
import viewcontroller.MapArea;
import viewcontroller.PlaceTowerFinishedListener;
import viewcontroller.ReadMap;

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
//    private int rows;
//    private int cols;
//    private GameMap map;
//    private ArrayList<CellState> cellList;
//
//    private ArrayList<Integer> pathList;
    private ReadMap readMap;

//    private int[] extrancePos;
//    private int[] exitPos;
//    
//    
//
//    /**
//     * Getter for entrance position
//     * @return entrance position
//     */
//    public int[] getExtrancePos() {
//        return extrancePos;
//    }
//    
//    /**
//     * Getter for the exit position
//     * @return exit position
//     */
//    public int[] getExitPos() {
//        return exitPos;
//    }
     
   




    /**
     * Constructor for the map panel
     * @param mapNum number of the map
     */
    public MapPanel(int mapNum) {

      readMap= new ReadMap(mapNum);
      mapArea = readMap.getMapArea();
      
        initComponent();

    }
    
    
    
    /**
     * Initiates the Map panel 
     */
    private void initComponent() {
    	
        setBackground(Color.BLACK);
        // set MapArea to the center
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapArea, c);
    }

    
	public ReadMap getReadMap() {
		return readMap;
	}

}
