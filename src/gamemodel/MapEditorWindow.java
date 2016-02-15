package gamemodel;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;



import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MapEditorWindow extends BaseWindow {

    private MapArea map;
    private TopArea top;


    private String[] widthStrings = {"5","10","15","20","25","30"};
    private String[] heightStrings = {"10","15"};

    private String MAP_IMG_DIR_NAME = "maparchive/";
    private int flag ; 


    //private String FILE_NAME = "saved/maps.json";
    private ArrayList<CellState> cellList = new ArrayList<CellState>();//map index, cellstate
    //private ArrayList<CellState> pathList = (ArrayList)cellList.clone();
   // private ArrayList<CellState> pathList = new ArrayList<CellState>(cellList);
   // cellList.addAll(pathList);
    
    
    // The columns and rows of a map has
    // Set by user
    private int mapCols = Utility.getMaxValueFrom(widthStrings);//hanglieshu
    private int mapRows = Utility.getMaxValueFrom(heightStrings);
    

    public int setFlag(){
    	//getMapIndex();
    	if(mapCols==0){//先写顶点///
    		flag = 1;
    	}else if((0<mapCols&&mapCols<Utility.getMaxValueFrom(heightStrings))//最上一行
    			||(0<mapCols&&mapCols<Utility.getMaxValueFrom(heightStrings))//写出下边界条件
    			&& mapCols!=0 &&mapCols!=Utility.getMaxValueFrom(heightStrings)){
    		flag=2;//2 means this grid is on the position of edge.
    	}else if(mapRows == 0){
    		flag = 1;
    	}
    	/*else if((0<cellList.indexOf(cellList)||cellList.indexOf(cellList)<Utility.getMaxValueFrom(heightStrings))
    			&&cellList.indexOf(cellList)!=0&&cellList.indexOf(cellList)!=Utility.getMaxValueFrom(heightStrings)){
    		flag=2;//2 means this grid is on the position of edge.
    	}else{
    		flag=1;
    	}*/
    	//System.out.println("mapCols is " + mapCols);
    	//System.out.println("mapRows is " + mapRows);
    	System.out.println("flag is " + flag);
    	return flag;
    }//还得的是一维的，mapCols用不上，稍作调整
 // 缺少顶点和左右边界
    
    boolean checkPathValidate(){
    	
    	ArrayList<CellState> pathList = new ArrayList<CellState>(cellList);
    	
    	System.out.println("cellList is" + cellList);
    	System.out.println("pathList is " + pathList);
    	
    	System.out.println("cellList  "+ cellList.indexOf(CellState.PATH));//遍历celllist，打印其中是path的（存后打）
    	System.out.println("右边是  "+ (cellList.indexOf(CellState.PATH)+1));
    	
    	
    	int i = cellList.indexOf(CellState.PATH);
    	if(pathList.contains(cellList.get(i+1)) ){//cellList.iterator().next().equals(CellState.PATH)
    		System.out.println("pathList中有  "+ (cellList.indexOf(CellState.PATH)+1));
    	}else{
    		System.out.println("pathList中没有  "+ (cellList.indexOf(CellState.PATH)+1));
    	}
    
    	System.out.println("mapCols is " + mapCols);
    	System.out.println("mapRows is " + mapRows);
    	setFlag();
        return true;
    }
    
    public MapEditorWindow(){
        super("Map Editor");
        initMapEditorWindow();
    }

    private void initMapEditorWindow() {

        map = new MapArea();
        top = new TopArea();

        Container c = this.getContentPane();
        c.add(top, BorderLayout.PAGE_START);
        c.add(map, BorderLayout.LINE_START);
    }


    private class TopArea extends JPanel {

        public TopArea(){

            this.setBackground(Color.DARK_GRAY);
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10));
            initComponents();

            for(int i = 0; i < mapRows * mapCols; i++)
                cellList.add(CellState.GRASS);
        }

        void initComponents(){

            JComboBox widthList = new JComboBox(widthStrings);
            widthList.setSelectedIndex(widthStrings.length - 1);
            widthList.setActionCommand("width");
            widthList.addActionListener(map.mapPanel);


            JComboBox heightList = new JComboBox(heightStrings);
            heightList.setSelectedIndex(heightStrings.length - 1);
            heightList.setActionCommand("height");
            heightList.addActionListener(map.mapPanel);

            mapCols = Integer.parseInt((String)widthList.getSelectedItem());
            mapRows = Integer.parseInt((String)heightList.getSelectedItem());
            
            

            JLabel widthLabel = new JLabel("Width:");
            JLabel heightLabel = new JLabel("Height:");

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkPathValidate()){
                        saveDataToFile();
                    } else {//TODO: Dialog!!! -> what went wrong?

                    }
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
                        map.mapPanel.clearMap();
                        MapEditorWindow.this.setVisible(false);
                        new MainMenuWindow().setVisible(true);
                    } else { } // User select "no"

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

    private class MapArea extends JPanel {

        private MapPanel mapPanel;

        private final String OPTION_ENTRANCE = "Set as an Entrance";
        private final String OPTION_EXIT = "Set as an Exit";

        public MapArea(){
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10 * 9));
            mapPanel = new MapPanel();

            this.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.add(mapPanel);
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
                        System.out.println("Index: " + index);

                        if (e.getButton() == MouseEvent.BUTTON1) {// Left Click to set map path
                            cellList.set(index, CellState.PATH);
                            repaint();
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                        	System.out.println(e.isPopupTrigger());
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
            
            int getMapIndex(){
            	return index;
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



    

    public void saveDataToFile() {
        String mapName = (String) JOptionPane.showInputDialog(MapEditorWindow.this,
                "Type in the map name:",
                "Save map to file",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "map1");
        try {
            if(mapName != null){
                File dir = new File(MAP_IMG_DIR_NAME);
                dir.mkdir();
                ImageIO.write(map.mapPanel.mapCaptureShot(), "png", new File( MAP_IMG_DIR_NAME + mapName + ".png"));
            }

        } catch (IOException error) {
            error.printStackTrace();
        }

        GameMap aMap = new GameMap(mapRows, mapCols, cellList, mapName);
        JsonFileProcess.writeToJson(aMap);

        map.mapPanel.clearMap();
        MapEditorWindow.this.setVisible(false);
        new MainMenuWindow().setVisible(true);
    }

    
    





}

