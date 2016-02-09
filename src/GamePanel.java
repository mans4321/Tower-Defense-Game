import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class GamePanel extends JPanel {

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

    public static final int level = Tower.level;
    private TowerLibrary towerLibrary;

    private BankAccout account;
    private final int INITIAL_BALANCE = 50;




    public GamePanel(int panelWidth, int panelHeight, int mapNum){
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
        this.mapNum = mapNum;

        topPanel = new TopPanel();
        mapPanel = new MapPanel(mapNum);
        endPanel = new EndPanel();


        account = new BankAccout(INITIAL_BALANCE);
        topPanel.getDataPanel().setBalance(account.getBalance());

        towerLibrary = new TowerLibrary();

        setPreferredSize(new Dimension(panelWidth, panelHeight));
        initPanel();



        topPanel.getTowerSelectionPanel().addTowerSelectionListener(new TowerSelectionListener() {
            @Override
            public void placeTower(TowerID id) {
                topPanel.getDataPanel().setWarningMsg("");
                ArrayList<CellState> cells = mapPanel.getCellList();

                if(account.getBalance() >= towerLibrary.getTowerCollection().get(id).getBuyPrice()){
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i) == CellState.GRASS){
                            cells.set(i, CellState.TOPLACETOWER);
                        } else if(cells.get(i) == CellState.CHOSEN){
                            cells.set(i, CellState.TOWER);
                        }
                    }
                    mapPanel.getMapArea().repaint();
                    mapPanel.setCellList(cells);

                    mapPanel.setCurrentTowerID(id);

                    topPanel.getDataPanel().setBalance(account.getBalance());
                } else {
                    // TODO: Data Panel
                    topPanel.getDataPanel().setWarningMsg("Need more gold!");
                }


            }
        });

        mapPanel.getMapArea().addTowerChosenListener(new TowerChosenListener() {
            @Override
            public void updateInfo(TowerID id) {
                endPanel.setCurrentChosenTowerID(id);
                updateInfoOfTower(id);
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
                        ArrayList<TowerID> towerIDList = mapPanel.getTowerIDList();
                        TowerID id = towerIDList.get(i);
                        account.setBalance(account.getBalance() + towerLibrary.getTowerCollection().get(id).getSellPrice());
                        topPanel.getDataPanel().setBalance(account.getBalance());

                        towerIDList.set(i, TowerID.TOWERNULL);
                        mapPanel.setTowerIDList(towerIDList);
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
                ArrayList<TowerID> towerIDList = mapPanel.getTowerIDList();
                for(int i = 0; i < cells.size(); i++){
                    if(cells.get(i) == CellState.CHOSEN){
                        // TODO: if you can afford
                        TowerID oldId = towerIDList.get(i);
                        String name = oldId.getName();
                        String[] arr = name.split("_");
                        if(arr.length >0){
                            int l = Integer.parseInt(arr[1]);
                            if(l < level){
                                l++;

                            } else {
                                topPanel.getDataPanel().setWarningMsg("It is in its highest level!");
                            }
                            String newName = arr[0] + "_" + l;
                            TowerID newId = towerIDList.get(i).getTowerIDFrom(newName);
                            double updatePrice = towerLibrary.getTowerCollection().get(newId).getBuyPrice() -
                                    towerLibrary.getTowerCollection().get(oldId).getBuyPrice();
                            if(account.getBalance() < updatePrice) {
                                // if balance is not enough, go back
                                l--;
                                newName = arr[0] + "_" + l;
                                newId = oldId;
                                topPanel.getDataPanel().setWarningMsg("Need more gold to upgrade!");
                            } else {
                                account.setBalance(account.getBalance() - updatePrice);
                                topPanel.getDataPanel().setBalance(account.getBalance());


                            }


                            towerIDList.set(i, newId);
                            updateInfoOfTower(newId);
                            mapPanel.setTowerIDList(towerIDList);
                            endPanel.setCurrentChosenTowerID(towerIDList.get(i).getTowerIDFrom(newName));
                            mapPanel.getMapArea().repaint();
                        }

                    }
                }

            }
        });

        // get msg from map panel to change the account in case tower is place accurately
        mapPanel.getMapArea().addAccountChangeListener(new AccountChangeListener() {
            @Override
            public void accountShouldChange(TowerID id) {
                account.setBalance(account.getBalance() - towerLibrary.getTowerCollection().get(id).getBuyPrice());
                topPanel.getDataPanel().setBalance(account.getBalance());
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
        Tower tower = towerLibrary.getTowerCollection().get(id);
        endPanel.getTowerSpecificationPanel().setBuyPrice(tower.getBuyPrice());
        endPanel.getTowerSpecificationPanel().setSpecification(tower.getSpecification());
        endPanel.getTowerSpecificationPanel().setSellPrice(tower.getSellPrice());
        endPanel.getTowerSpecificationPanel().setPower(tower.getPower());
        endPanel.getTowerSpecificationPanel().setRange(tower.getRange());
        endPanel.getTowerSpecificationPanel().setRateOfFire(tower.getRateOfFire());
    }





}
