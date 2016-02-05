import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class GamePanel extends JPanel implements ActionListener{

    private int mapNum;
    private int panelWidth;
    private int panelHeight;
    private int topAreaWidth;
    private int topAreaHeight;
    private int endAreaWidth;
    private int endAreaHeight;
    private int mapAreaWidth;
    private int mapAreaHeight;

    // Panel
    private TopPanel topPanel;
    private EndPanel endPanel;
    private MapPanel mapPanel;

    private BankAccout account;
    private final int INITIAL_BALANCE = 50;

    private Timer timer;

    private final int DELAY = 100;

    private ArrayList<Integer> pathList;

    private int[] critterPositionArr;

    public GamePanel(int panelWidth, int panelHeight, int mapNum){

        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
        this.mapNum = mapNum;

        topPanel = new TopPanel();
        mapPanel = new MapPanel(mapNum);
        endPanel = new EndPanel();

        account = new BankAccout(INITIAL_BALANCE);
        topPanel.getDataPanel().setBalance(account.getBalance());
        pathList =  mapPanel.getPathList();

        //TODO
        critterPositionArr = new int[]{mapPanel.critter.getPosX(), mapPanel.critter.getPosY()};

        setPreferredSize(new Dimension(panelWidth, panelHeight));
        initPanel();


        timer = new Timer(DELAY, this);
        timer.start();

        topPanel.getTowerSelectionPanel().addTowerSelectionListener(new TowerSelectionListener() {
            @Override
            public void placeTower(TowerID id) {
                topPanel.getDataPanel().setWarningMsg("");
                updateInfoOfTower(id);
                ArrayList<CellState> cells = mapPanel.getCellList();

                if(account.getBalance() >= TowerFactory.getInstance().getTower(id).getBuyPrice()){
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i) == CellState.GRASS){
                            cells.set(i, CellState.TOPLACETOWER);
                        } else if(cells.get(i) == CellState.CHOSEN){
                            cells.set(i, CellState.TOWER);
                        }
                    }

                } else {
                    topPanel.getDataPanel().setWarningMsg("Need more gold!");
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i) == CellState.TOPLACETOWER){
                            cells.set(i, CellState.GRASS);
                        }
                    }
                }
                mapPanel.getMapArea().repaint();
                mapPanel.setCellList(cells);
                mapPanel.setCurrentTowerID(id);
                topPanel.getDataPanel().setBalance(account.getBalance());
            }
        });

        topPanel.getTowerSelectionPanel().addTowerChosenListener(new TowerChosenListener() {
            @Override
            public void updateInfo(TowerID id) {
                endPanel.setCurrentChosenTowerID(id);
                updateInfoOfTower(id);
            }
        });

        mapPanel.getMapArea().addTowerChosenListener(new TowerChosenListener() {
            @Override
            public void updateInfo(TowerID id) {

                endPanel.setCurrentChosenTowerID(id);

                if(id == TowerID.TOWERNULL){
                    endPanel.getTowerSpecificationPanel().clearPanel();
                } else {
                    updateInfoOfTower(id);
                }
            }
        });

        endPanel.getTowerUpgradeSellPanel().addTowerManipulationListener(new TowerManipulationListener() {
            @Override
            public void sellTower() {
                topPanel.getDataPanel().setWarningMsg("");
                ArrayList<CellState> cells = mapPanel.getCellList();
                for(int i = 0; i < cells.size(); i++){
                    if(cells.get(i) == CellState.CHOSEN){
                        cells.set(i, CellState.GRASS);
                        HashMap<Integer, Tower> towerMap = mapPanel.getTowerMap();

                        account.setBalance(account.getBalance() + towerMap.get(i).getSellPrice());
                        topPanel.getDataPanel().setBalance(account.getBalance());

                        towerMap.remove(i);
                        mapPanel.setTowerMap(towerMap);
                        mapPanel.getMapArea().repaint();
                        // clear chosen state -> draw null image in end panel
                        endPanel.setCurrentChosenTowerID(TowerID.TOWERNULL);

                    }
                }

            }

            @Override
            public void upgradeTower() {
                topPanel.getDataPanel().setWarningMsg("");


                ArrayList<CellState> cells = mapPanel.getCellList();

                for(int i = 0; i < cells.size(); i++){
                    if(cells.get(i) == CellState.CHOSEN){
                        Tower oldTower = mapPanel.getTowerMap().get(i);
                        double oldTowerBuyPrice = oldTower.getBuyPrice();
                        int level = oldTower.getLevel();
                        String oldName = oldTower.getTid().getName();

                        if(level < Tower.LEVEL){
                            level ++;
                            String newName = oldName.split("_")[0] + "_" + level;

                            TowerID newID = TowerID.getTowerIDFrom(newName);
                            Tower newTower = TowerFactory.getInstance().getTower(newID);
                            double newTowerBuyPrice = newTower.getBuyPrice();
                            double updatePrice = newTowerBuyPrice - oldTowerBuyPrice;
                            if(account.getBalance() < updatePrice) {
                                topPanel.getDataPanel().setWarningMsg("Need more gold to upgrade!");
                            } else {
                                account.setBalance(account.getBalance() - updatePrice);
                                topPanel.getDataPanel().setBalance(account.getBalance());
                                mapPanel.getTowerMap().put(i, newTower);

                                updateInfoOfTower(newID);
                                endPanel.setCurrentChosenTowerID(newID);

                                int[] arr = DrawMap.indexConverter(i, mapPanel.getCols());
                                newTower.shoot(arr[0], arr[1]);

                            }
                        } else {
                            topPanel.getDataPanel().setWarningMsg("It is in its highest level!");
                        }
                    }
                }

                mapPanel.getMapArea().repaint();

            }


        });
        // get msg from map panel to change the account in case tower is place accurately
        mapPanel.getMapArea().addPlaceTowerFinishedListener(new PlaceTowerFinishedListener() {
            @Override
            public void accountShouldChange(TowerID id) {
                account.setBalance(account.getBalance() - TowerFactory.getInstance().getTower(id).getBuyPrice());
                topPanel.getDataPanel().setBalance(account.getBalance());
            }

            @Override
            public void placeTowerFinished(int index) {
                Tower tower = mapPanel.getTowerMap().get(index);
                int[] arr = DrawMap.indexConverter(index, mapPanel.getCols());
                tower.shoot(arr[0], arr[1]);

            }
        });

    }

    private void initPanel() {

        setLayout(null);
        topAreaWidth = panelWidth;
        topAreaHeight = panelHeight / 5;
        endAreaWidth = panelWidth/ 5;
        endAreaHeight =  panelHeight - topAreaHeight;
        mapAreaWidth = panelWidth - endAreaWidth;
        mapAreaHeight = panelHeight - topAreaHeight;

        // Debug:
        System.out.println("topAreaWidth: " + topAreaWidth); //1200
        System.out.println("topAreaHeight: " + topAreaHeight); //144
        System.out.println("endAreaWidth: " + endAreaWidth); //240
        System.out.println("endAreaHeight: " + endAreaHeight); //578
        System.out.println("mapAreaWidth: " + mapAreaWidth); //960
        System.out.println("mapAreaHeight: " + mapAreaHeight); //578



        add(topPanel);
        add(mapPanel);
        add(endPanel);

        Insets insets = this.getInsets();

        topPanel.setBounds(insets.left, insets.top, topAreaWidth, topAreaHeight);
        mapPanel.setBounds(insets.left, insets.top + topAreaHeight, mapAreaWidth, mapAreaHeight);
        endPanel.setBounds(insets.left + mapAreaWidth, insets.top + topAreaHeight, endAreaWidth, endAreaHeight);


    }

    private void updateInfoOfTower(TowerID id){
        Tower tower = TowerFactory.getInstance().getTower(id);
        endPanel.getTowerSpecificationPanel().setBuyPrice(tower.getBuyPrice());
        endPanel.getTowerSpecificationPanel().setSpecification(tower.getSpecification());
        endPanel.getTowerSpecificationPanel().setSellPrice(tower.getSellPrice());
        endPanel.getTowerSpecificationPanel().setPower(tower.getPower());
        endPanel.getTowerSpecificationPanel().setRange(tower.getRange());
        endPanel.getTowerSpecificationPanel().setRateOfFire(tower.getRateOfFire());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // critter move along the path step by step
        if(mapPanel.critter.moveToPosition(critterPositionArr[0], critterPositionArr[1])){
            // return next cell
            if(mapPanel.critter.isVisible)
            critterPositionArr = mapPanel.getMapArea().getDestination(critterPositionArr[0], critterPositionArr[1]);
        }

        for(Tower t: mapPanel.getTowerMap().values()){
            for(Missile m : t.getMissiles()){
                m.move();
            }
        }
        mapPanel.getMapArea().repaint();

    }


}
