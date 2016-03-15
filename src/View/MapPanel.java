package View;

import viewcontroller.MapArea;

import viewcontroller.MapFile;

import javax.swing.*;

import java.awt.*;


/**
 * creating the map area view 
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
