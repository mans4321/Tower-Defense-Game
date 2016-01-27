import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class MapEditorWindow extends JFrame {

    private MapArea map;
    private TopArea top;
    private SpecificationArea specification;


    protected final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH;
    protected final int WINDOW_HEIGHT = GameWindow.WINDOW_HEIGHT;


    protected String[] widthStrings = {"5","10","15","20","25","30"};
    protected String[] heightStrings = {"10","15","20"};

//    private String FILE_NAME = "saved/maps.json";

    private ArrayList<CellState> cellList = new ArrayList<>();

    // The columns and rows of a map has
    // Set by user
    private int mapCols;
    private int mapRows;

    private final int CELL_SIZE = 30;


    private String EDITOR_TITLE = "Map Editor";
    public MapEditorWindow(){
        initMapEditorWindow();
    }

    public int getMaxValueFrom(String[] strArr) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String s : strArr){
            arr.add(Integer.parseInt(s));
        }
        int max = arr.get(0);
        for(int i = 1; i < arr.size(); i++){
            if (arr.get(i) > max)
                max = arr.get(i);
        }

        return max;
    }

    private void initMapEditorWindow() {

        map = new MapArea();
        top = new TopArea();
        specification = new SpecificationArea();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(EDITOR_TITLE);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

        Container c = this.getContentPane();
        c.add(top, BorderLayout.PAGE_START);
        c.add(map, BorderLayout.LINE_START);
        c.add(specification, BorderLayout.LINE_END);

    }

    public int getMapCols() {
        return mapCols;
    }

    public int getMapRows() {
        return mapRows;
    }

    private class TopArea extends JPanel {

        public TopArea(){

            this.setBackground(Color.DARK_GRAY);
            this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 10));

            JComboBox widthList = new JComboBox(widthStrings);
            widthList.setSelectedIndex(widthStrings.length / 2);
            widthList.setActionCommand("width");
            widthList.addActionListener(map);


            JComboBox heightList = new JComboBox(heightStrings);
            heightList.setSelectedIndex(heightStrings.length / 2);
            heightList.setActionCommand("height");
            heightList.addActionListener(map);

            mapCols = Integer.parseInt((String)widthList.getSelectedItem());
            mapRows = Integer.parseInt((String)heightList.getSelectedItem());


            for(int i = 0; i < getMapRows() * getMapCols(); i ++)
            cellList.add(CellState.GRASS);

            JLabel widthLabel = new JLabel("Width:");
            JLabel heightLabel = new JLabel("Height:");

            // Flow Layout: Horizontal
            this.add(widthLabel);
            this.add(widthList);

            this.add(heightLabel);
            this.add(heightList);
        }

    }

    private class MapArea extends JPanel implements ActionListener {


        private int MAPAREA_WIDTH = getMaxValueFrom(widthStrings) * CELL_SIZE;
        private int MAPAREA_HEIGHT = WINDOW_HEIGHT / 4 * 3;

        private String OPTION_ENTRANCE = "Set as an Entrance";
        private String OPTION_EXIT = "Set as an Exit";


        // The exact column and row of map
        // All starts with 0
        private int cCol;
        private int cRow;


        public MapArea(){
            this.setPreferredSize(new Dimension(MAPAREA_WIDTH, MAPAREA_HEIGHT));


            // Set Listener for the map area panel
            addMouseListener(new MapAdapter());


        }

        @Override
        public void actionPerformed(ActionEvent e) {


            if(e.getSource() instanceof JMenuItem){

                // If the signal is from MenuItem of PopupMenu
                JMenuItem source = (JMenuItem)(e.getSource());
                if(source.getText().equals(OPTION_ENTRANCE)){
                    cellList.set(cCol + (cRow * getMapCols()), CellState.ENTRANCE);
                } else if (source.getText().equals(OPTION_EXIT)){
                    cellList.set(cCol + (cRow * getMapCols()), CellState.EXIT);
                }
                repaint();

            } else if (e.getSource() instanceof JComboBox){

                // If the signal is from JComboBox
                JComboBox cb = (JComboBox)e.getSource();
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
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Image imageGrass = new ImageIcon("res/grass.png").getImage();
            Image imagePath = new ImageIcon("res/path.png").getImage();
            Image imageEntrance = new ImageIcon("res/entrance.png").getImage();
            Image imageExit = new ImageIcon("res/exit.png").getImage();

            for(int i = 0; i < getMapCols() * CELL_SIZE; i = i + imageGrass.getWidth(null)){
                for(int j = 0; j < getMapRows() * CELL_SIZE; j = j + imageGrass.getWidth(null)){

                    switch (cellList.get(coordinateConverter(i,j))){
                        case GRASS:
                            g2d.drawImage(imageGrass, i, j, this);
                            break;
                        case PATH:
                            g2d.drawImage(imagePath, i, j, this);
                            break;
                        case ENTRANCE:
                            g2d.drawImage(imageEntrance, i, j, this);
                            break;
                        case EXIT:
                            g2d.drawImage(imageExit, i, j, this);
                            break;
                    }
                }
            }
        }

        // input: coordinate(x,y)(pixels)
        // output: nth cell in whole map
        private int coordinateConverter(int x, int y) {
            return x / CELL_SIZE + (y / CELL_SIZE) * getMapCols();
        }

        public void clearMap(){

            cellList.clear();
            for(int i = 0; i < getMapRows() * getMapCols(); i ++)

                cellList.add(CellState.GRASS);

            repaint();
        }

        class MapAdapter extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                cCol = x / CELL_SIZE;
                cRow = y / CELL_SIZE;
                int index = cCol + (cRow * getMapCols());

                if(e.getButton() == MouseEvent.BUTTON1){// Left Click to set map path
                    if ((x < getMapCols() * CELL_SIZE) && (y < getMapRows() * CELL_SIZE)) {

                        cellList.set(index, CellState.PATH);
                        repaint();

                        System.out.println("x:" + cCol + "; y:" + cRow);
                    } else {
                        System.out.println("OutSide the Map Area!");
                    }
                }
//                else if (e.getButton() == MouseEvent.BUTTON3){ // Right Click to set map exit and entrance
//                    if(cellList.get(cCol + (cRow * getMapCols())) == CellState.PATH) {
//                        // cCol + (cRow * getMapCols()) is the exact index of arraylist.
////                        dialog -> choose which is entrance and exit;
////                        add flags to these;
//                        System.out.println("Right Click!");
//
//                    }
//                }
                else if(e.isPopupTrigger()){
                    if(cellList.get(cCol + (cRow * getMapCols())) == CellState.PATH) {
                        JPopupMenu popup = new JPopupMenu();
                        JMenuItem menuItem;
                        menuItem = new JMenuItem(OPTION_ENTRANCE);
                        menuItem.addActionListener(map);
                        popup.add(menuItem);
                        menuItem = new JMenuItem(OPTION_EXIT);
                        menuItem.addActionListener(map);
                        popup.add(menuItem);
                        popup.show(e.getComponent(), x, y);

                    }
                }

            }
        }

    }

    class SpecificationArea extends JPanel {

        private GridLayout layout = new GridLayout(0,1);

        private String note1 = "First, Choose the width and height of the map<br><br>";
        private String note2 = "Second, Left click the cells to specify the path<br><br>";
        private String note3 = "Third, Right click the cells to decide the entrance and the exit<br><br>";

        public SpecificationArea(){
            this.setPreferredSize(new Dimension(WINDOW_WIDTH - getMaxValueFrom(widthStrings) * CELL_SIZE, WINDOW_HEIGHT / 4 * 3));

            this.setBackground(Color.BLACK);

            this.setLayout(layout);

            JPanel specify = new JPanel();
            specify.setBorder(BorderFactory.createLineBorder(Color.black));
            specify.setLayout(new BoxLayout(specify, BoxLayout.PAGE_AXIS));

            JLabel jText = new JLabel("<html> " + note1 + note2 + note3 + "</html>");
            jText.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 0));
            specify.add(jText);

            JPanel buttons = new JPanel();
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkPathValidate()){
                        saveDataToFile();
                    } else {

//                        Dialog!!! -> what went wrong?
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
                        map.clearMap();
                        MapEditorWindow.this.setVisible(false);
                        new MainMenuWindow().setVisible(true);
                    } else {} // User select "no"

                }
            });

            buttons.add(saveButton);
            buttons.add(discardButton);

            this.add(specify);
            this.add(buttons);
        }

        private BufferedImage mapCaptureShot() {
            BufferedImage image = new BufferedImage(map.getWidth(), map.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            map.print(g);
            g.dispose();
            return image;
        }

        private void saveDataToFile(){
            String mapName = (String) JOptionPane.showInputDialog(MapEditorWindow.this,
                    "Type in the map name:",
                    "Save map to file",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "map1");

            try {
                if(mapName != null)
                ImageIO.write(mapCaptureShot(), "png", new File("maparchive/" + mapName + ".png"));
            } catch (IOException error) {
                error.printStackTrace();
            }

            GameMap aMap = new GameMap(mapRows, mapCols, cellList, mapName);
            JsonFileProcess.writeToJson(aMap);

            map.clearMap();
            MapEditorWindow.this.setVisible(false);
            new MainMenuWindow().setVisible(true);
        }


    }


    boolean checkPathValidate(){
        return true;
    }




}

enum CellState {
    GRASS,
    PATH,
    ENTRANCE,
    EXIT;
}