import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class MapPanel extends JPanel {

    private MapArea mapArea;

    private int mapPanelWidth;
    private int mapPaneHeight;

    private int rows;

    public int getCols() {
        return cols;
    }

    private int cols;
    private GameMap map;
    private ArrayList<CellState> cellList;
    private HashMap<Integer, Tower> towerMap;
    //TODO
    public CritterA critter;
    //TODO
    private ArrayList<Integer> pathList;



    private TowerID currentTowerID;
    private TowerID currentChosenID;

    private boolean isChosen = false;
    private int indexEntrance;
    private int indexExit;





    public void setCurrentTowerID(TowerID currentTowerID) {
        this.currentTowerID = currentTowerID;
    }

    public ArrayList<CellState> getCellList() {
        return cellList;
    }

    public void setCellList(ArrayList<CellState> cellList) {
        this.cellList = cellList;
    }

    public HashMap<Integer, Tower> getTowerMap() {
        return towerMap;
    }

    public void setTowerMap(HashMap<Integer, Tower> towerMap) {
        this.towerMap = towerMap;
    }

    public ArrayList<Integer> getPathList() {
        return pathList;
    }


    public MapPanel(int mapNum){

        mapArea = new MapArea();
        setBackground(Color.BLACK);


        GameMapCollection mapCollection = FileProcessing.readMapFromJsonFile();
        map = mapCollection.getMaps().get(mapNum);
        cellList = map.getCells();
        cols = map.getmCols();
        rows = map.getmRows();


        pathList = new ArrayList<>();
        //Find the path, entrance and exit cell
        for(int i = 0; i < cellList.size() ; i++){
            if(cellList.get(i) == CellState.ENTRANCE){ // Entrance -> indexEntrance
                indexEntrance = i;
            } else if(cellList.get(i) == CellState.PATH){ // PATH -> pathList
                pathList.add(i);
            } else if (cellList.get(i) == CellState.EXIT){ // Exit -> indexExit
                indexExit = i;
            }
        }

        int[] arr = DrawMap.indexConverter(indexEntrance, cols);
        // critter critters based on entrance index.
        critter = new CritterA(arr[0], arr[1]);

        towerMap = new HashMap<>();

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
        private PlaceTowerFinishedListener placeTowerFinishedListener;
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
                            towerMap.put(index,TowerFactory.getInstance().getTower(currentTowerID));

                            placeTowerFinishedListener.accountShouldChange(currentTowerID);


                            placeTowerFinishedListener.placeTowerFinished(index);

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

                            currentChosenID = towerMap.get(index).getTid();
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

                                } else if (cellList.get(i) == CellState.TOPLACETOWER){
                                    cellList.set(i, CellState.GRASS);
                                }
                            }
                            currentChosenID = TowerID.TOWERNULL;
                            listener.updateInfo(currentChosenID);
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
            DrawMap.drawTower(g, cols, towerMap, this);
            if(critter.isVisible()){
                DrawMap.drawCritters(g, critter.getPosX(), critter.getPosY(),this);
            }
        }

        @Override

        public Dimension getPreferredSize() {
            return new Dimension(DrawMap.CELL_SIZE * cols, DrawMap.CELL_SIZE * rows);
        }

        public void addTowerChosenListener(TowerChosenListener listener){
            this.listener = listener;
        }

        public void addPlaceTowerFinishedListener(PlaceTowerFinishedListener listener){
            this.placeTowerFinishedListener = listener;
        }

        public int[] getDestination(int x, int y) {

            int index = DrawMap.coordinateConverter(x, y, cols);

            int iLeft = index - 1;
            int iRight = index + 1;
            int iDown = index + cols;
            int iUp = index - cols;
            // TODO when critter gone, it should stop
            int[] destArr = new int[2];
            if (cellList.get(iLeft) == CellState.PATH && pathList.contains(iLeft)) {
                destArr[0] = x - DrawMap.CELL_SIZE;
                destArr[1] = y;
            } else if (cellList.get(iRight) == CellState.PATH && pathList.contains(iRight)) {
                destArr[0] = x + DrawMap.CELL_SIZE;
                destArr[1] = y;
            } else if (cellList.get(iDown) == CellState.PATH && pathList.contains(iDown)) {
                destArr[0] = x;
                destArr[1] = y + DrawMap.CELL_SIZE;
            } else if (cellList.get(iUp) == CellState.PATH && pathList.contains(iUp)) {
                destArr[0] = x;
                destArr[1] = y - DrawMap.CELL_SIZE;
            } else {
                // critter arrive at exit point
                critter.setVisible(false);
            }
            // In case it will go back from the old path
            pathList.remove(new Integer(index));
//            System.out.println("next cell: " + destArr[0] + "," +  destArr[1]);
            return destArr;
        }

    }

    public MapArea getMapArea() {
        return mapArea;
    }

}
