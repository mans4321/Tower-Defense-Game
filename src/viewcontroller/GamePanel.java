package viewcontroller;
import javax.swing.*;

import gamemodel.bankaccount.*;
import gamemodel.critter.*;
import gamemodel.gamemap.*;
import gamemodel.tower.*;
import gamemodel.wave.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class GamePanel extends JPanel implements ActionListener{

    private int panelWidth;
    private int panelHeight;
    private int topAreaWidth;
    private int topAreaHeight;
    private int endAreaWidth;
    private int endAreaHeight;
    private int mapAreaWidth;
    private int mapAreaHeight;


    private int mapNum;
    // Panel
    private TopPanel topPanel;
    private EndPanel endPanel;
    private MapPanel mapPanel;

    private int coins;

    private BankAccout account;
    private final int INITIAL_BALANCE = 50;


    private Timer wavePrepareTimer;
    private final int PREPARE_DELAY = 5000;

    private int waveNum;

    private boolean isGameOver = false;

    public GamePanel(int panelWidth, int panelHeight, int mapNum) {

        this.mapNum = mapNum;
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;


        topPanel = new TopPanel();
        mapPanel = new MapPanel(mapNum);
        endPanel = new EndPanel();

        account = new BankAccout(INITIAL_BALANCE);
        topPanel.getDataPanel().setBalance(account.getBalance());

        coins = 5;
        topPanel.getDataPanel().setCoins(coins);

        waveNum = 1;
        topPanel.getDataPanel().setTotalWaveNum(WaveStore.waves.size());


        setPreferredSize(new Dimension(panelWidth, panelHeight));
        initPanel();


        wavePrepareTimer = new Timer(PREPARE_DELAY,this);
        wavePrepareTimer.start(); // 5s



        topPanel.getTowerSelectionPanel().addTowerSelectionListener(new TowerSelectionListener() {
            @Override
            public void placeTower(TowerId id) {
                topPanel.getDataPanel().setWarningMsg("");
                updateInfoOfTower(id);
                ArrayList<CellState> cells = mapPanel.getCellList();

                if (account.getBalance() >= TowerFactory.getInstance().getTower(id).getBuyPrice()) {
                    for(int i = 0; i < cells.size(); i++) {
                        if (cells.get(i) == CellState.GRASS) {
                            cells.set(i, CellState.TOPLACETOWER);
                        } else if (cells.get(i) == CellState.CHOSEN) {
                            cells.set(i, CellState.TOWER);
                        }
                    }

                } else {
                    topPanel.getDataPanel().setWarningMsg("Need more gold!");
                    for(int i = 0; i < cells.size(); i++) {
                        if (cells.get(i) == CellState.TOPLACETOWER) {
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
            public void updateInfo(TowerId id) {
                endPanel.setCurrentChosenTowerID(id);
                updateInfoOfTower(id);
            }
        });

        mapPanel.getMapArea().addTowerChosenListener(new TowerChosenListener() {
            @Override
            public void updateInfo(TowerId id) {

                endPanel.setCurrentChosenTowerID(id);

                if (id == TowerId.TOWERNULL) {
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
                for(int i = 0; i < cells.size(); i++) {
                    if (cells.get(i) == CellState.CHOSEN) {
                        cells.set(i, CellState.GRASS);
                        HashMap<Integer, Tower> towerMap = mapPanel.getTowerMap();

                        account.setBalance(account.getBalance() + towerMap.get(i).getSellPrice());
                        topPanel.getDataPanel().setBalance(account.getBalance());

                        towerMap.remove(i);
                        mapPanel.setTowerMap(towerMap);
                        mapPanel.getMapArea().repaint();
                        // clear chosen state -> draw null image in end panel
                        endPanel.setCurrentChosenTowerID(TowerId.TOWERNULL);

                    }
                }

            }

            @Override
            public void upgradeTower() {
                topPanel.getDataPanel().setWarningMsg("");


                ArrayList<CellState> cells = mapPanel.getCellList();

                for(int i = 0; i < cells.size(); i++) {
                    if (cells.get(i) == CellState.CHOSEN) {
                        Tower oldTower = mapPanel.getTowerMap().get(i);
                        double oldTowerBuyPrice = oldTower.getBuyPrice();
                        int level = oldTower.getLevel();
                        String oldName = oldTower.getTid().getName();

                        if (level < Tower.LEVEL) {
                            level ++;
                            String newName = oldName.split("_")[0] + "_" + level;

                            TowerId newID = TowerId.getTowerIdFrom(newName);
                            Tower newTower = TowerFactory.getInstance().getTower(newID);
                            double newTowerBuyPrice = newTower.getBuyPrice();
                            double updatePrice = newTowerBuyPrice - oldTowerBuyPrice;
                            if (account.getBalance() < updatePrice) {
                                topPanel.getDataPanel().setWarningMsg("Need more gold to upgrade!");
                            } else {
                                account.setBalance(account.getBalance() - updatePrice);
                                topPanel.getDataPanel().setBalance(account.getBalance());
                                newTower.setPosX(oldTower.getPosX());
                                newTower.setPosY(oldTower.getPosY());
                                mapPanel.getTowerMap().put(i, newTower);

                                updateInfoOfTower(newID);
                                endPanel.setCurrentChosenTowerID(newID);

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
            public void accountShouldChange(TowerId id) {
                account.setBalance(account.getBalance() - TowerFactory.getInstance().getTower(id).getBuyPrice());
                topPanel.getDataPanel().setBalance(account.getBalance());
            }

            @Override
            public void placeTowerFinished(int index) {
                // shoot
            }
        });

        topPanel.getDataPanel().getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearGame();
                SwingUtilities.getWindowAncestor(GamePanel.this).setVisible(false);
                new MainMenuWindow().setVisible(true);
            }
        });

        mapPanel.getMapArea().addStealCoinListener(new StealCoinListener() {
            @Override
            public synchronized void coinGotStolen() {
                coins --;
                topPanel.getDataPanel().setCoins(coins);

                if (coins == 0) {
                    isGameOver = true;

                    Object[] options = {"Back to main menu",  "Play again!"};
                    int n = JOptionPane.showOptionDialog(GamePanel.this,
                            "Sorry, Game over...",
                            "Oops!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,     //do not use a custom Icon
                            options, //the titles of buttons
                            options[0]); //default button title
                    if (n == 0) {
                        clearGame();
                        SwingUtilities.getWindowAncestor(GamePanel.this).setVisible(false);
                        new MainMenuWindow().setVisible(true);
                    } else {
                        clearGame();
                        SwingUtilities.getWindowAncestor(GamePanel.this).setVisible(false);
                        new GameWindow(GamePanel.this.mapNum).setVisible(true);
                    }


                }
            }

            @Override
            public void noCritterLeft() {
                waveNum++;
                wavePrepareTimer.start();
                // just in case
                CritterStore.critters.clear();
                if (waveNum > WaveStore.waves.size()) {
                    // User Win
                    Object[] options = {"Back to main menu"};
                    int n = JOptionPane.showOptionDialog(GamePanel.this,
                            "Nice Work! You win!",
                            "Congrats!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,     //do not use a custom Icon
                            options, //the titles of buttons
                            options[0]); //default button title
                    if (n == 0) {
                        clearGame();
                        SwingUtilities.getWindowAncestor(GamePanel.this).setVisible(false);
                        new MainMenuWindow().setVisible(true);
                    }
                }


            }
        });

        mapPanel.getMapArea().addCritterGotKilledListener(new CritterGotKilledListener() {
            @Override
            public void critterGotKilled(Critter c) {
                if (!c.isAleadyDonated()) {
                    double balance = account.getBalance() + c.getWorth();
                    account.setBalance(balance);
                    topPanel.getDataPanel().setBalance(balance);
                    c.setAleadyDonated(true);
                }
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

    private void updateInfoOfTower(TowerId id) {
        Tower tower = TowerFactory.getInstance().getTower(id);
        endPanel.getTowerSpecificationPanel().setBuyPrice(tower.getBuyPrice());
        endPanel.getTowerSpecificationPanel().setSpecification(tower.getSpecification());
        endPanel.getTowerSpecificationPanel().setSellPrice(tower.getSellPrice());
        endPanel.getTowerSpecificationPanel().setPower(tower.getPower());
        endPanel.getTowerSpecificationPanel().setRange(tower.getRange());
        endPanel.getTowerSpecificationPanel().setRateOfFire(tower.getRateOfFire());
    }

    private void clearGame() {
    	CritterStore.critters.clear();
        mapPanel.getMapArea().getRepaintMapTimer().stop();
        wavePrepareTimer.stop();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (!isGameOver) {
            wavePrepareTimer.stop();
            if (waveNum <= WaveStore.waves.size()) {
                // wave start!
                topPanel.getDataPanel().setWaveNum(waveNum);
                int[] num = WaveStore.waves.get(waveNum);
                new Wave.Builder().critterA(num[0]).critterB(num[1]).critterC(num[2]).critterD(num[3])
                        .build()
                        .addWaveStartListener(new WaveStartListener() {
                        @Override
                        public void initCritterPos(Critter c) {
                            c.setVisible(true);
                            c.setPosX(mapPanel.getExtrancePos()[0]);
                            c.setPosY(mapPanel.getExtrancePos()[1]);
                            c.setNextPosX(mapPanel.getExtrancePos()[0]);
                            c.setNextPosY(mapPanel.getExtrancePos()[1]);
                            // clone: As pathList is passed by reference
                            c.setPathList((ArrayList<Integer>) mapPanel.getPathList().clone());
                        }
                    });
            }
        } else {

        }

    }
}
