package viewcontroller;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import View.MainMenuWindow;
import gamemodel.gamemap.CellState;
import gamemodel.gamemap.FileProcessing;
import gamemodel.gamemap.GameMap;
import gamemodel.gamemap.GameMapCollection;
import mapvalidation.MapValidationManager;

/**
 * Create the map based on the places where the user clicks
 * @author yongpinggao
 *
 */
public class EditAreaListener extends JPanel implements MouseListener, ActionListener {
	
	private final String OPTION_ENTRANCE = "Set as an Entrance";
	private final String OPTION_EXIT = "Set as an Exit";

    private int index;
    private int mapRows;
    private int mapCols;
    private int mapNum;
    private ArrayList<CellState> cellList;
    private GameMap aMap;
    
    /**
     * Constructor, uses mouse listeners to track places where user is clicking
     * Turns the click into different types of tiles for the map and display the new images
     * @param mapRows 
     */
    
    public EditAreaListener(int mapRows, int mapCols, int mapNum, ArrayList<CellState> cellList){
    	
    	this.mapRows = mapRows;
    	this.mapCols = mapCols;
    	this.cellList = cellList;
    	this.mapNum=mapNum;
    	addMouseListener(this);
    }
    
	@Override
	public void mousePressed(MouseEvent e) {
		
		 int x = e.getX();
         int y = e.getY();

         index = DrawMap.coordinateConverter(x, y, mapCols);

         if (e.getButton() == MouseEvent.BUTTON1) {
             // Left Click to set maps path
             if (cellList.get(index) == CellState.GRASS) {
                 cellList.set(index, CellState.PATH);
             } else if (cellList.get(index) == CellState.PATH) {
                 cellList.set(index, CellState.GRASS);
             } else if (cellList.get(index) == CellState.ENTRANCE || cellList.get(index) == CellState.EXIT) {
                 cellList.set(index, CellState.PATH);
             }

             repaint();
         } else if (e.getButton() == MouseEvent.BUTTON3) {
             if (cellList.get(index) == CellState.PATH) {
                 JPopupMenu popup = new JPopupMenu();
                 JMenuItem menuItem1, menuItem2;
                 menuItem1 = new JMenuItem(OPTION_ENTRANCE);
                 menuItem1.addActionListener(this);
                 popup.add(menuItem1);
                 menuItem2 = new JMenuItem(OPTION_EXIT);
                 menuItem2.addActionListener(this);
                 popup.add(menuItem2);
                 popup.show(e.getComponent(), x, y);
             }
         }
     }
	
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	
		 String command = e.getActionCommand();
		 
		 if (e.getSource() instanceof JMenuItem) {
          // If the signal is from MenuItem of PopupMenu
          JMenuItem source = (JMenuItem)(e.getSource());
          if (source.getText().equals(OPTION_ENTRANCE)) {
              cellList.set(index, CellState.ENTRANCE);
          } else if (source.getText().equals(OPTION_EXIT)) {
              cellList.set(index, CellState.EXIT);
          }
          repaint();

      } else if (e.getSource() instanceof JComboBox) {

          // If the signal is from JComboBox
          JComboBox cb = (JComboBox)(e.getSource());
          String string = (String)cb.getSelectedItem();
          if (command.equals("width")) {
              mapCols = Integer.parseInt(string);
          } else if (command.equals("height")) {
              mapRows = Integer.parseInt(string);
          }
          clearMap();
      }
		 // buttons 
			if(command.equals("Discard")){
		        int n = JOptionPane.showConfirmDialog(
		               this,
		                "Are you Sure, all unsaved changes will be discarded!!",
		                "Warning",
		                JOptionPane.YES_NO_OPTION);

		        if (n == 0) { // User select "yes"
		        	clearMap();
		        	SwingUtilities.getWindowAncestor(getParent()).setVisible(false);
		        	//super.setVisible(false);
		            //this.setVisible(false);
		            new MainMenuWindow().setVisible(true);
		        } else {} // User select "no"

		 
	 } else if(command.equals("Save")){
	    	
	    	MapValidationManager manager = new MapValidationManager(cellList, mapCols, mapRows);
	    	
	    	while(true){
	    	if (manager.checkValidate()) {
	    		
	    	     saveDataToFile();
	    	     break;
	    	}else {	
	    	
		    	JOptionPane.showMessageDialog(this, manager.getErrorMessage(),"Illegal Map",JOptionPane.ERROR_MESSAGE);
		    	 break;
	    	 }
	    	}
////
	        }
	    
	 }
			
	 
	    /**
	     * Enables validation of the map
	     * @return
	     */
	    boolean checkPathValidate() {
	        return true;
	    }
	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public Dimension getPreferredSize() {
	        return new Dimension(DrawMap.CELL_SIZE * mapCols, DrawMap.CELL_SIZE * mapRows);
	    }
	 /**
	  * {@inheritDoc}
	  */
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        DrawMap.drawMap(g, mapCols, mapRows, cellList, this);
	    }
	    /**
	     * Clean the map so the user can start a new map
	     */
	    public void clearMap() {
	        // it will let layout manager run again!
	        revalidate();
	        cellList.clear();
	        for(int i = 0; i < mapCols * mapRows; i++)
	            cellList.add(CellState.GRASS);
	        repaint();
	    }
	    
	    /**
	     * Saves an image of the map
	     * @return
	     */
	    public BufferedImage mapCaptureShot() {
	        BufferedImage image = new BufferedImage(DrawMap.CELL_SIZE * mapCols, 
	        		DrawMap.CELL_SIZE * mapRows, BufferedImage.TYPE_INT_RGB);
	        
	        Graphics g = image.createGraphics();
	        print(g);
	        g.dispose();
	        return image;
	    }
	    	    
	    /**
	     * Gets the list of cells and saves the map to Json file
	     */
	    public void saveDataToFile() {

	        boolean isReadyToCreate = true;
	        String mapName = (String) JOptionPane.showInputDialog(this,
	                "Type in the maps name:",
	                "Save map to file",
	                JOptionPane.PLAIN_MESSAGE,
	                null,
	                null,
	                "map1");
	        if (mapName != null) { // if user choose cancel, mapName -> null

	            if (!mapName.equals("")) { // if the name is empty then it's invalidate
	                GameMapCollection collection = FileProcessing.readMapFromJsonFile(); // read from json
	                if (collection!= null) { // if the file already exits, check the filename and volume
	                    int size = collection.getMaps().size();
	                    for (int i = 0; i < size; i++) {
	                        if (collection.getMaps().get(i).getImageName().equals(mapName)) {
	                            String mapRename;// if they have the same name, please rename
	                            do {
	                                mapRename = (String) JOptionPane.showInputDialog(this,
	                                        "Already taken, please rename:",
	                                        "Save map to file",
	                                        JOptionPane.PLAIN_MESSAGE,
	                                        null,
	                                        null,
	                                        "map1");
	                            } while (mapName.equals(mapRename));
	                            if (mapRename != null) mapName = mapRename;
	                            else isReadyToCreate = false;
	                        }
	                    }

	                    if (mapNum > 0) { // if this map is edited, then remove the old one
	                        FileProcessing.deleteMapFromJsonFile(mapNum);
	                        FileProcessing.sync();
	                    } else if (size == MapChooseWindow.nCols * MapChooseWindow.nRows) { // when it's full, delete the last map
	                        FileProcessing.deleteMapFromJsonFile(size - 1);
	                        FileProcessing.sync();
	                    }
	                }

	                if (isReadyToCreate) {
	                    aMap = new GameMap(mapRows, mapCols, cellList, mapName);
	                    BufferedImage mapImage = mapCaptureShot();



	                    FileProcessing.addMapToJsonFile(aMap);
	                    FileProcessing.writeToMapArchive(mapName, mapImage);

	                    clearMap();
                          
	                    SwingUtilities.getWindowAncestor(getParent()).setVisible(false);
	                   //super.setVisible(false);
	                  // this.setVisible(false);
	                    new MainMenuWindow().setVisible(true);
	                }

	            } else {
	                JOptionPane.showMessageDialog(this,
	                        "File name invalidate");
	            }
	        }


	    }
	    
	    
	    
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e){	
	}
	public void mouseReleased(MouseEvent e) {
		
	}

	public ArrayList<CellState> getCellList() {
		return cellList;
	}

}
