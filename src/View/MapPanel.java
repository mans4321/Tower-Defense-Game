package View;
import gamemodel.critter.*;
import gamemodel.gamemap.*;
import gamemodel.tower.*;
import viewcontroller.DrawCritter;
import viewcontroller.DrawMap;
import viewcontroller.DrawTower;
import viewcontroller.MapArea;
import viewcontroller.PlaceTowerFinishedListener;
import viewcontroller.MapFile;

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

    private MapFile readMap;
    private MapArea mapArea;
   
    /**
     * Constructor for the map panel
     * @param mapNum number of the map
     */
    public MapPanel(int mapNum) {

      readMap= new MapFile(mapNum);
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

    /**
     * getter for mapFile
     * @return mapFile 
     */
	public MapFile getReadMap() {
		return readMap;
	}

}
