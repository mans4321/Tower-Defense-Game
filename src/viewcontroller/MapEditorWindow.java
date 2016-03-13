package viewcontroller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import View.BaseWindow;
import View.MainMenuWindow;
import gamemodel.gamemap.CellState;
import gamemodel.gamemap.FileProcessing;
import gamemodel.gamemap.GameMap;
import gamemodel.gamemap.GameMapCollection;
import mapvalidation.MapValidationManager;
import utility.Utility;

/**
 * The window that holds the map editor
 * @author yongpinggao
 * @since 1/24/16
 */
public class MapEditorWindow extends BaseWindow {

    private EditArea editArea;
    private TopArea topArea;
    private EditAreaListener editAreaListener;
//    MapEditorWindowListener topAreaListener;

    private final String[] widthStrings = {"5","10","15","20","25","30"};
    private final String[] heightStrings = {"10","15"};

    private ArrayList<CellState> cellList;

    // The columns and rows of a maps has
    // Set by user
    private int mapCols;
    private int mapRows;

    private int mapNum;

    private GameMap aMap;

    /**
     * Constructor, creates the cellList for the map and sets cols and rows
     * sets map num to -1
     */
    public MapEditorWindow() {
        super("Map Editor");

        this.mapNum = -1;
        cellList = new ArrayList<>();
        mapCols = Utility.getMaxValueFrom(widthStrings);
        mapRows = Utility.getMaxValueFrom(heightStrings);

        initMapEditorWindow();
    }
    
    /**
     * Constructor opens the map editor for a saved map
     * @param mapNum
     */
    public MapEditorWindow(int mapNum) {
        super("Map Editor");

        this.mapNum = mapNum;
        cellList = new ArrayList<>();
        GameMapCollection mapCollection = FileProcessing.readMapFromJsonFile();
        aMap = mapCollection.getMaps().get(mapNum);
        cellList = aMap.getCells();

        mapCols = aMap.getmCols();
        mapRows = aMap.getmRows();
        initMapEditorWindow();


    }
    
    /**
     * Initiates the map editor window
     */
    private void initMapEditorWindow() {

        editArea = new EditArea();
        topArea = new TopArea();

        Container c = this.getContentPane();
        c.add(topArea, BorderLayout.PAGE_START);
        c.add(editArea, BorderLayout.LINE_START);
    }

    /**
     * Panel for the top area, holds the options to the map
     * @author yongpinggao
     *
     */
    private class TopArea extends JPanel {
        
        /**
         * Constructor to the top area
         */
        public TopArea() {

            this.setBackground(Color.DARK_GRAY);
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10));
            
          
            //topAreaListener = new MapEditorWindowListener(mapRows, mapCols, mapNum, cellList, editAreaListener);
            
            initComponents();
        }
        
        /**
         * Initiates the components and applies the settings selected by the user
         * also draws the control buttons
         */
        void initComponents() {
            JComboBox widthList;
            JComboBox heightList;

            widthList = new JComboBox(widthStrings);
            widthList.setSelectedIndex(Utility.getIndexFrom(widthStrings, mapCols));
            widthList.setActionCommand("width");
            widthList.addActionListener(editAreaListener);


            heightList = new JComboBox(heightStrings);
            heightList.setSelectedIndex(Utility.getIndexFrom(heightStrings, mapRows));
            heightList.setActionCommand("height");
            heightList.addActionListener(editAreaListener);

         

            JLabel widthLabel = new JLabel("Width:");
            JLabel heightLabel = new JLabel("Height:");

          

            
            JButton saveButton = new JButton("Save");
            saveButton.setActionCommand("Save");
            saveButton.addActionListener(editAreaListener);
//            saveButton.addActionListener(new ActionListener(){
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                	
//                	MapValidationManager manager = new MapValidationManager(cellList, mapCols, mapRows);
//                	if (manager.checkValidate()) {
//                		
//                	     saveDataToFile();
//                	} else {
//                		//TODO AlertWindow!
//                		JOptionPane.showMessageDialog(MapEditorWindow.this, manager.getErrorMessage(),"Illegal Map",JOptionPane.ERROR_MESSAGE);
//                	}
//            	 
//            	 
//                    if (checkPathValidate()) {
//                        saveDataToFile();
//                    } else {//TODO: Dialog!!! -> what went wrong?
//
//                    }
//                }
//            });

            
            JButton discardButton = new JButton("Discard");
            discardButton.setActionCommand("Discard");
            discardButton.addActionListener(editAreaListener);
            
//            discardButton.addActionListener(new ActionListener(){
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                    int n = JOptionPane.showConfirmDialog(
//                            MapEditorWindow.this,
//                            "Are you Sure, all unsaved changes will be discarded!!",
//                            "Warning",
//                            JOptionPane.YES_NO_OPTION);
//
//                    if (n == 0) { // User select "yes"
//                    	editAreaListener.clearMap();
//                        MapEditorWindow.this.setVisible(false);
//                        new MainMenuWindow().setVisible(true);
//                    } else {} // User select "no"
//
//                }
//            });

            // Flow Layout: Horizontal
            this.add(widthLabel);
            this.add(widthList);

            this.add(heightLabel);
            this.add(heightList);

            this.add(saveButton);
            this.add(discardButton);
        }
    }
    
    /**
     * Edit area for the map to be created
     * @author yongpinggao
     *
     */
    private class EditArea extends JPanel {

        

//        private final String OPTION_ENTRANCE = "Set as an Entrance";
//        private final String OPTION_EXIT = "Set as an Exit";
        
        /**
         * Creates the area where the user will be able to click to create a path
         */
        public EditArea() {
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10 * 9));
            

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            

            for(int i = 0; i < mapRows * mapCols; i++)
                cellList.add(CellState.GRASS);
            
            editAreaListener = new EditAreaListener(mapRows, mapCols,mapNum, cellList);
            add(editAreaListener, c);
        }
        

    }
    
//    /**
//     * Enables validation of the map
//     * @return
//     */
//    boolean checkPathValidate() {
//        return true;
//    }
//    
//    /**
//     * Gets the list of cells and saves the map to Json file
//     */
//    public void saveDataToFile() {
//
//        boolean isReadyToCreate = true;
//        String mapName = (String) JOptionPane.showInputDialog(MapEditorWindow.this,
//                "Type in the maps name:",
//                "Save map to file",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                "map1");
//        if (mapName != null) { // if user choose cancel, mapName -> null
//
//            if (!mapName.equals("")) { // if the name is empty then it's invalidate
//                GameMapCollection collection = FileProcessing.readMapFromJsonFile(); // read from json
//                if (collection!= null) { // if the file already exits, check the filename and volume
//                    int size = collection.getMaps().size();
//                    for (int i = 0; i < size; i++) {
//                        if (collection.getMaps().get(i).getImageName().equals(mapName)) {
//                            String mapRename;// if they have the same name, please rename
//                            do {
//                                mapRename = (String) JOptionPane.showInputDialog(MapEditorWindow.this,
//                                        "Already taken, please rename:",
//                                        "Save map to file",
//                                        JOptionPane.PLAIN_MESSAGE,
//                                        null,
//                                        null,
//                                        "map1");
//                            } while (mapName.equals(mapRename));
//                            if (mapRename != null) mapName = mapRename;
//                            else isReadyToCreate = false;
//                        }
//                    }
//
//                    if (mapNum > 0) { // if this map is edited, then remove the old one
//                        FileProcessing.deleteMapFromJsonFile(mapNum);
//                        FileProcessing.sync();
//                    } else if (size == MapChooseWindow.nCols * MapChooseWindow.nRows) { // when it's full, delete the last map
//                        FileProcessing.deleteMapFromJsonFile(size - 1);
//                        FileProcessing.sync();
//                    }
//                }
//
//                if (isReadyToCreate) {
//                    aMap = new GameMap(mapRows, mapCols, cellList, mapName);
//                    BufferedImage mapImage = editAreaListener.mapCaptureShot();
//
//
//
//                    FileProcessing.addMapToJsonFile(aMap);
//                    FileProcessing.writeToMapArchive(mapName, mapImage);
//
//                    editAreaListener.clearMap();
//
//                    MapEditorWindow.this.setVisible(false);
//                    new MainMenuWindow().setVisible(true);
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(MapEditorWindow.this,
//                        "File name invalidate");
//            }
//        }
//
//
//
//    }






}