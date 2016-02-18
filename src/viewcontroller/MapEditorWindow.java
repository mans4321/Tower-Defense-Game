package viewcontroller;
import javax.swing.*;

import gamemodel.gamemap.*;
import mapvalidation.MapValidationManager;
import utility.Utility;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class MapEditorWindow extends BaseWindow {

    private EditArea editArea;
    private TopArea topArea;


    private final String[] widthStrings = {"5","10","15","20","25","30"};
    private final String[] heightStrings = {"10","15"};

    private ArrayList<CellState> cellList;

    // The columns and rows of a maps has
    // Set by user
    private int mapCols;
    private int mapRows;

    private int mapNum;



    private GameMap aMap;

    public MapEditorWindow(){
        super("Map Editor");

        this.mapNum = -1;
        cellList = new ArrayList<>();
        mapCols = Utility.getMaxValueFrom(widthStrings);
        mapRows = Utility.getMaxValueFrom(heightStrings);

        initMapEditorWindow();
    }

    public MapEditorWindow(int mapNum){
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

    private void initMapEditorWindow() {

        editArea = new EditArea();
        topArea = new TopArea();

        Container c = this.getContentPane();
        c.add(topArea, BorderLayout.PAGE_START);
        c.add(editArea, BorderLayout.LINE_START);
    }

    private class TopArea extends JPanel {

        public TopArea(){

            this.setBackground(Color.DARK_GRAY);
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10));
            initComponents();
        }

        void initComponents(){
            JComboBox widthList;
            JComboBox heightList;

            widthList = new JComboBox(widthStrings);
            widthList.setSelectedIndex(Utility.getIndexFrom(widthStrings, mapCols));
            widthList.setActionCommand("width");
            widthList.addActionListener(editArea.mapPanel);


            heightList = new JComboBox(heightStrings);
            heightList.setSelectedIndex(Utility.getIndexFrom(heightStrings, mapRows));
            heightList.setActionCommand("height");
            heightList.addActionListener(editArea.mapPanel);



            JLabel widthLabel = new JLabel("Width:");
            JLabel heightLabel = new JLabel("Height:");

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                	MapValidationManager manager = new MapValidationManager(cellList, mapCols, mapRows);
                	if(manager.checkValidate()){
                		 saveDataToFile();
                	} else {
                		//TODO AlertWindow!
                		JOptionPane.showMessageDialog(MapEditorWindow.this, manager.getErrorMessage(),"Illegal Map",JOptionPane.ERROR_MESSAGE);
                	}
            	 
            	 
//                    if(checkPathValidate()){
//                        saveDataToFile();
//                    } else {//TODO: Dialog!!! -> what went wrong?
//
//                    }
                }
            });

            JButton discardButton = new JButton("Discard");
            discardButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    int n = JOptionPane.showConfirmDialog(
                            MapEditorWindow.this,
                            "Are you Sure, all unsaved changes will be discarded!!",
                            "Warning",
                            JOptionPane.YES_NO_OPTION);

                    if(n == 0){ // User select "yes"
                        editArea.mapPanel.clearMap();
                        MapEditorWindow.this.setVisible(false);
                        new MainMenuWindow().setVisible(true);
                    } else {} // User select "no"

                }
            });

            // Flow Layout: Horizontal
            this.add(widthLabel);
            this.add(widthList);

            this.add(heightLabel);
            this.add(heightList);

            this.add(saveButton);
            this.add(discardButton);
        }
    }

    private class EditArea extends JPanel {

        private MapPanel mapPanel;

        private final String OPTION_ENTRANCE = "Set as an Entrance";
        private final String OPTION_EXIT = "Set as an Exit";

        public EditArea(){
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10 * 9));
            mapPanel = new MapPanel();

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            add(mapPanel, c);

            for(int i = 0; i < mapRows * mapCols; i++)
                cellList.add(CellState.GRASS);
        }

        private class MapPanel extends JPanel implements ActionListener {


            private int index;

            public MapPanel() {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);

                        int x = e.getX();
                        int y = e.getY();

                        index = DrawMap.coordinateConverter(x, y, mapCols);

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            // Left Click to set maps path
                            if(cellList.get(index) == CellState.GRASS){
                                cellList.set(index, CellState.PATH);
                            } else if(cellList.get(index) == CellState.PATH){
                                cellList.set(index, CellState.GRASS);
                            } else if(cellList.get(index) == CellState.ENTRANCE || cellList.get(index) == CellState.EXIT) {
                                cellList.set(index, CellState.PATH);
                            }

                            repaint();
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (cellList.get(index) == CellState.PATH) {
                                JPopupMenu popup = new JPopupMenu();
                                JMenuItem menuItem1, menuItem2;
                                menuItem1 = new JMenuItem(OPTION_ENTRANCE);
                                menuItem1.addActionListener(MapPanel.this);
                                popup.add(menuItem1);
                                menuItem2 = new JMenuItem(OPTION_EXIT);
                                menuItem2.addActionListener(MapPanel.this);
                                popup.add(menuItem2);
                                popup.show(e.getComponent(), x, y);
                            }
                        }
                    }
                });
            }
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                DrawMap.drawMap(g, mapCols, mapRows, cellList, this);
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() instanceof JMenuItem){
                    // If the signal is from MenuItem of PopupMenu
                    JMenuItem source = (JMenuItem)(e.getSource());
                    if(source.getText().equals(OPTION_ENTRANCE)){
                        cellList.set(index, CellState.ENTRANCE);
                    } else if (source.getText().equals(OPTION_EXIT)){
                        cellList.set(index, CellState.EXIT);
                    }
                    repaint();

                } else if (e.getSource() instanceof JComboBox){

                    // If the signal is from JComboBox
                    JComboBox cb = (JComboBox)(e.getSource());
                    String string = (String)cb.getSelectedItem();
                    if(e.getActionCommand().equals("width")){
                        mapCols = Integer.parseInt(string);
                    } else if (e.getActionCommand().equals("height")){
                        mapRows = Integer.parseInt(string);
                    }
                    clearMap();
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(DrawMap.CELL_SIZE * mapCols, DrawMap.CELL_SIZE * mapRows);
            }

            public void clearMap(){
                // it will let layout manager run again!
                mapPanel.revalidate();
                cellList.clear();
                for(int i = 0; i < mapCols * mapRows; i++)
                    cellList.add(CellState.GRASS);
                repaint();
            }

            private BufferedImage mapCaptureShot() {
                BufferedImage image = new BufferedImage(DrawMap.CELL_SIZE * mapCols, DrawMap.CELL_SIZE * mapRows, BufferedImage.TYPE_INT_RGB);
                Graphics g = image.createGraphics();
                print(g);
                g.dispose();
                return image;
            }

        }



    }

    boolean checkPathValidate(){
        return true;
    }

    public void saveDataToFile() {

        boolean isReadyToCreate = true;
        String mapName = (String) JOptionPane.showInputDialog(MapEditorWindow.this,
                "Type in the maps name:",
                "Save map to file",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "map1");
        if (mapName != null){ // if user choose cancel, mapName -> null

            if(!mapName.equals("")){ // if the name is empty then it's invalidate
                GameMapCollection collection = FileProcessing.readMapFromJsonFile(); // read from json
                if(collection!= null) { // if the file already exits, check the filename and volume
                    int size = collection.getMaps().size();
                    for (int i = 0; i < size; i++) {
                        if (collection.getMaps().get(i).getImageName().equals(mapName)) {
                            String mapRename;// if they have the same name, please rename
                            do {
                                mapRename = (String) JOptionPane.showInputDialog(MapEditorWindow.this,
                                        "Already taken, please rename:",
                                        "Save map to file",
                                        JOptionPane.PLAIN_MESSAGE,
                                        null,
                                        null,
                                        "map1");
                            } while(mapName.equals(mapRename));
                            if(mapRename != null) mapName = mapRename;
                            else isReadyToCreate = false;
                        }
                    }

                    if(mapNum > 0) { // if this map is edited, then remove the old one
                        FileProcessing.deleteMapFromJsonFile(mapNum);
                        FileProcessing.sync();
                    } else if (size == MapChooseWindow.nCols * MapChooseWindow.nRows){ // when it's full, delete the last map
                        FileProcessing.deleteMapFromJsonFile(size - 1);
                        FileProcessing.sync();
                    }
                }

                if(isReadyToCreate){
                    aMap = new GameMap(mapRows, mapCols, cellList, mapName);
                    BufferedImage mapImage = editArea.mapPanel.mapCaptureShot();



                    FileProcessing.addMapToJsonFile(aMap);
                    FileProcessing.writeToMapArchive(mapName, mapImage);

                    editArea.mapPanel.clearMap();

                    MapEditorWindow.this.setVisible(false);
                    new MainMenuWindow().setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(MapEditorWindow.this,
                        "File name invalidate");
            }
        }



    }






}

