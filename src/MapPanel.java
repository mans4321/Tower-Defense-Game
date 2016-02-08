import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class MapPanel extends JPanel {

    private MapArea mapArea;

    private int mapPanelWidth;
    private int mapPaneHeight;

    private int rows;
    private int cols;
    private GameMap map;
    private ArrayList<CellState> cellList;

    private ArrayList<TowerID> towerIDList;

    private TowerID currentTowerID;
    private TowerID currentChosenID;
    private boolean isChosen = false;


    public void setCurrentTowerID(TowerID currentTowerID) {
        this.currentTowerID = currentTowerID;
    }

    public ArrayList<CellState> getCellList() {
        return cellList;
    }

    public void setCellList(ArrayList<CellState> cellList) {
        this.cellList = cellList;
    }

    public ArrayList<TowerID> getTowerIDList() {
        return towerIDList;
    }

    public void setTowerIDList(ArrayList<TowerID> towerIDList) {
        this.towerIDList = towerIDList;
    }

    public MapPanel(int mapNum){

        mapArea = new MapArea();

        setBackground(Color.BLACK);


        GameMapCollection mapCollection = JsonFileProcess.readFromJson();
        map = mapCollection.getMaps().get(mapNum);
        cellList = map.getCells();
        cols = map.getmCols();
        rows = map.getmRows();

        towerIDList = new ArrayList<TowerID>();
        for(int i = 0; i < cols * rows; i++){
            towerIDList.add(TowerID.TOWERNULL);
        }

        currentTowerID = TowerID.TOWERNULL;
        currentChosenID = TowerID.TOWERNULL;



        // set MapArea to the center
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapArea, c);

    }



    public class MapArea extends JPanel {

        private TowerChosenListener listener;
        private AccountChangeListener accountListener;


        public MapArea(){

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                    int x = e.getX();
                    int y = e.getY();

                    int index = DrawMap.coordinateConverter(x, y, cols);
                    if (e.getButton() == MouseEvent.BUTTON1) { // User left click map cells

                        // 1. if it is "toPlaceTower" state:  toPlaceTower -> Tower state
                        if(cellList.get(index) == CellState.TOPLACETOWER){

                            cellList.set(index, CellState.TOWER);
                            // current Tower ID is set by topPanel
                            towerIDList.set(index, currentTowerID);

                            accountListener.accountShouldChange(currentTowerID);

                            // Change back to Grass state
                            for(int i = 0; i < cellList.size(); i++){
                                if(cellList.get(i) == CellState.TOPLACETOWER){
                                    cellList.set(i, CellState.GRASS);
                                }
                            }
                            repaint();
                            System.out.println("1");
                        }
                        // 2. if it is "Tower" state:  Tower state -> Chosen state
                        else if (cellList.get(index) == CellState.TOWER) {
                            for(int i = 0; i < cellList.size(); i++) {
                                if (cellList.get(i) == CellState.TOPLACETOWER) {
                                    cellList.set(i, CellState.GRASS);
                                }
                            }
                            if(isChosen){
                                for(int i = 0; i < cellList.size(); i++){
                                    if (cellList.get(i) == CellState.CHOSEN){
                                        cellList.set(i, CellState.TOWER);
                                    }
                                }
                                isChosen = false;
                            }
                            isChosen = true;
                            cellList.set(index, CellState.CHOSEN);
                            currentChosenID = towerIDList.get(index);
                            listener.updateInfo(currentChosenID);
                            repaint();
                            System.out.println("2");
                        }
                        // 3. if it is "Chosen" state: Chosen state -> Tower State
                        else if (cellList.get(index) == CellState.CHOSEN){
                            cellList.set(index, CellState.TOWER);
                            currentChosenID = TowerID.TOWERNULL;
                            System.out.println("3");
                        }

                        // 4. Other Cells: Chosen state -> Tower state.
                        // ToPlaceTower state -> Grass state
                        else {
                            // if the user press the wrong cells, aka path, etc.
                            // set state back to grass
                            for(int i = 0; i < cellList.size(); i++){
                                if (cellList.get(i) == CellState.CHOSEN){
                                    cellList.set(i, CellState.TOWER);
                                    currentChosenID = TowerID.TOWERNULL;
                                } else if (cellList.get(i) == CellState.TOPLACETOWER){
                                    cellList.set(i, CellState.GRASS);
                                }
                            }
                            System.out.println("4");
                            repaint();
                        }
                        currentTowerID = TowerID.TOWERNULL;
                    }

                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            DrawMap.drawMap(g, cols, rows, cellList, this);
            DrawMap.drawTower(g, cols, rows, towerIDList, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DrawMap.CELL_SIZE * cols, DrawMap.CELL_SIZE * rows);
        }

        public void addTowerChosenListener(TowerChosenListener listener){
            this.listener = listener;
        }

        public void addAccountChangeListener(AccountChangeListener listener){
            this.accountListener = listener;
        }




    }

    public MapArea getMapArea() {
        return mapArea;
    }

}
