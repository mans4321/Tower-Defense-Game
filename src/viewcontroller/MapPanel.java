package viewcontroller;
import gamemodel.critter.*;
import gamemodel.gamemap.*;
import gamemodel.tower.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by yongpinggao on 1/30/16.
 */
public class MapPanel extends JPanel {

    private MapArea mapArea;
    private int rows;
    private int cols;
    private GameMap map;
    private ArrayList<CellState> cellList;
    private HashMap<Integer, Tower> towerMap;
    private ArrayList<Integer> pathList;
    private TowerID currentTowerID;
    private TowerID currentChosenID;

    private boolean isChosen = false;

    private int[] extrancePos;
    private int[] exitPos;





    public int getCols() {
        return cols;
    }

    public int[] getExtrancePos() {
        return extrancePos;
    }

    public int[] getExitPos() {
        return exitPos;
    }

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

    public MapArea getMapArea() {
        return mapArea;
    }



    public MapPanel(int mapNum) {

        // read data from saved files
        GameMapCollection mapCollection = FileProcessing.readMapFromJsonFile();
        map = mapCollection.getMaps().get(mapNum);
        cellList = map.getCells();
        cols = map.getmCols();
        rows = map.getmRows();

        pathList = new ArrayList<>();
        towerMap = new HashMap<>();

        //Find the path, entrance and exit cell
        for(int i = 0; i < cellList.size() ; i++) {
            if (cellList.get(i) == CellState.ENTRANCE) { // Entrance -> indexEntrance
                extrancePos = DrawMap.indexConverter(i, cols);
            } else if (cellList.get(i) == CellState.PATH) { // PATH -> pathList
                pathList.add(i);
            } else if (cellList.get(i) == CellState.EXIT) { // Exit -> indexExit
                exitPos = DrawMap.indexConverter(i, cols);
            }
        }

        currentTowerID = TowerID.TOWERNULL;
        currentChosenID = TowerID.TOWERNULL;

        initComponent();

    }

    private void initComponent() {
        mapArea = new MapArea();
        setBackground(Color.BLACK);
        // set MapArea to the center
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapArea, c);
    }

    // inner class
    public class MapArea extends JPanel implements ActionListener {

        private TowerChosenListener listener;
        private PlaceTowerFinishedListener placeTowerFinishedListener;
        private StealCoinListener stealCoinListener;
        private CritterGotKilledListener critterGotKilledListener;

        private Timer repaintMapTimer;

        public Timer getRepaintMapTimer() {
            return repaintMapTimer;
        }

        public MapArea() {
            repaintMapTimer = new Timer(100, this);
            repaintMapTimer.start();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                    int x = e.getX();
                    int y = e.getY();

                    int index = DrawMap.coordinateConverter(x, y, cols);
                    if (e.getButton() == MouseEvent.BUTTON1) { // User left click map cells

                        // 1. if it is "toPlaceTower" state:  toPlaceTower -> Tower state
                        if (cellList.get(index) == CellState.TOPLACETOWER) {

                            cellList.set(index, CellState.TOWER);
                            // current Tower ID is set by topPanel

                            Tower tower = TowerFactory.getInstance().getTower(currentTowerID);
                            int[] posArr = DrawMap.indexConverter(index, cols);

                            // center of the cell
                            tower.setPosX(posArr[0] + DrawMap.CELL_SIZE / 2);
                            tower.setPosY(posArr[1] + DrawMap.CELL_SIZE / 2);
                            towerMap.put(index,tower);

                            placeTowerFinishedListener.accountShouldChange(currentTowerID);
                            placeTowerFinishedListener.placeTowerFinished(index);

                            // Change back to Grass state
                            for(int i = 0; i < cellList.size(); i++) {
                                if (cellList.get(i) == CellState.TOPLACETOWER) {
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
                            if (isChosen) {
                                for(int i = 0; i < cellList.size(); i++) {
                                    if (cellList.get(i) == CellState.CHOSEN) {
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
                        else if (cellList.get(index) == CellState.CHOSEN) {
                            cellList.set(index, CellState.TOWER);
                            currentChosenID = TowerID.TOWERNULL;
                            System.out.println("3");
                        }

                        // 4. Other Cells: Chosen state -> Tower state.
                        // ToPlaceTower state -> Grass state
                        else {
                            // if the user press the wrong cells, aka path, etc.
                            // set state back to grass
                            for(int i = 0; i < cellList.size(); i++) {
                                if (cellList.get(i) == CellState.CHOSEN) {
                                    cellList.set(i, CellState.TOWER);

                                } else if (cellList.get(i) == CellState.TOPLACETOWER) {
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
        public Dimension getPreferredSize() {
            return new Dimension(DrawMap.CELL_SIZE * cols, DrawMap.CELL_SIZE * rows);
        }

        public void addTowerChosenListener(TowerChosenListener listener) {
            this.listener = listener;
        }

        public void addPlaceTowerFinishedListener(PlaceTowerFinishedListener listener) {
            this.placeTowerFinishedListener = listener;
        }

        public void addStealCoinListener(StealCoinListener listener) {
            this.stealCoinListener = listener;
        }

        public void addCritterGotKilledListener(CritterGotKilledListener listener) {
            this.critterGotKilledListener = listener;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            DrawMap.drawMap(g, cols, rows, cellList, this);

            for(Critter c : CritterStore.critters) {
                if (c.isVisible()) {
                    DrawMap.drawCritters(g, c,this);
                }
                if (!c.isKilled()) DrawMap.drawHealthBar(g, c.getHealthBar(), c);
            }

            for(Tower tower: towerMap.values()) {
                if (tower.isShooting()) {
                    Critter c = tower.shoot();// c is being attacked
                    if (c != null) {
                        DrawMap.drawMissiles(g, tower, c);
                    }
                }
            }

            DrawMap.drawTowerRange(g, towerMap, this);

            DrawMap.drawTower(g, cols, towerMap, this);


        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // critter move along the path step by step
            if (CritterStore.critters.size() != 0) {
                for(Critter c : CritterStore.critters) {
                    if (c.isVisible()) {
                        c.move(cols);
                    }
                    if (c.isSuccess()) {
                        c.setSuccess(false);
                        c.setKilled(true);
                        c.setAleadyDonated(true);
                        stealCoinListener.coinGotStolen();
                    }



                }

                for(Tower t: getTowerMap().values()) {
                    for(Critter c : CritterStore.critters) {
                        if (c.getBound().intersects(t.getBounds())) {
                            t.getCrittersInRange().add(c);
                        } else {
                            t.getCrittersInRange().remove(c);
                        }

                        if (c.isKilled()) {
                            t.getCrittersInRange().remove(c);
                            critterGotKilledListener.critterGotKilled(c);
                        }

                    }
                    if (t.getCrittersInRange().size() > 0) {
                        t.setShooting(true);
                    } else {
                        t.setShooting(false);
                    }
                }


                // To check if this wave is finished
                // If all the critters either got killed(even it is in success state) next wave starts!
                for(int i = 0; i < CritterStore.critters.size(); i++) {
                    if (CritterStore.critters.get(i).isKilled()) {
                        if (i ==  CritterStore.critters.size() - 1) stealCoinListener.noCritterLeft();
                        continue;
                    } else break;

                }



            }

            repaint();
        }



    }



}
