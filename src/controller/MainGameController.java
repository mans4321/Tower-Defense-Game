package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import model.bankaccount.BankAccount;
import model.critter.Critter;
import model.critter.CritterCollection;
import model.drawing.GameMapDrawing;
import model.map.CellState;
import model.map.GameMap;
import model.tower.shootingstrategy.TargetBasedOnWeakest;
import model.tower.shootingstrategy.TargetBasedOnStrongest;
import model.tower.shootingstrategy.TargetBasedOnNearest;
import model.tower.shootingstrategy.TowerShootingStrategy;
import model.tower.Tower;
import model.tower.TowerCollection;
import model.tower.TowerFactory;
import model.tower.TowerName;
import model.wave.WaveFactory;
import protocol.DrawingDataPanelDelegate;
import protocol.DrawingMapInGameDelegate;
import protocol.DrawingPanelDelegate;
import view.maingameview.MainGameView;

/**
 * This controller will start all the logic for the view elements and start the models.
 * 
 * @author yongpinggao
 * @see model.map.GameMap
 * @see model.critter.Critter
 * @see model.bankaccount.BankAccount
 * @see model.critter.Critter
 * @see model.critter.CritterCollection
 * @see model.drawing.GameMapDrawing
 * @see model.map.CellState
 * @see model.map.GameMap
 * @see model.tower.shootingstrategy.TargetBasedOnWeakest
 * @see model.tower.shootingstrategy.TargetBasedOnStrongest
 * @see model.tower.shootingstrategy.TargetBasedOnNearest
 * @see model.tower.shootingstrategy.TowerShootingStrategy
 * @see model.tower.Tower
 * @see model.tower.TowerCollection
 * @see model.tower.TowerFactory
 * @see model.tower.TowerName
 * @see model.wave.WaveFactory
 * @see protocol.DrawingDataPanelDelegate
 * @see protocol.DrawingMapInGameDelegate
 * @see protocol.DrawingPanelDelegate
 * @see view.maingameview.MainGameView
 */
public class MainGameController {

    MainGameView mainGameView;

    GameMap gameMap = new GameMap();
    TowerCollection towerCollection = new TowerCollection();
    Tower currentTower = new Tower();
    int currentIndex = -1;
    int currentWaveNum = 0;
    BankAccount account;
    TowerShootingStrategy currentStrategy = new TargetBasedOnWeakest();

    Timer critterGeneratorTimer;

    DrawingMapInGameDelegate drawingMapInGameDelegate;
    DrawingPanelDelegate drawingSpecificationPanelDelegate;
    DrawingPanelDelegate drawingSellUpgradePanelDelegate;
    DrawingDataPanelDelegate drawingDataPanelDelegate;

    private final int REFRESH_RATE = 100;
    private final int CRITTER_GENERATE_TIME = 1000;

    private int coins = 10;

    /**
     * Contructor method, will set up internal properties and call internal initializator methods
     * @param  gameMap The select map by the player
     */
    public MainGameController(GameMap gameMap) {
        mainGameView = new MainGameView();
        this.gameMap = gameMap;
        drawingMapInGameDelegate = mainGameView.mapView.mapPanel;
        drawingSpecificationPanelDelegate = mainGameView.endView.towerSpecificationPanel;
        drawingSellUpgradePanelDelegate = mainGameView.endView.towerUpgradeSellPanel;
        drawingDataPanelDelegate = mainGameView.topView.gameDataPanel;
        drawingMapInGameDelegate.refreshMap(gameMap);
        drawingDataPanelDelegate.reloadCoinDataView(coins);

        initBankAccount();
        initPaintingTimers();
        initWaveTimers();
        initTowerButtons();
        initMapArea();
        initSellUpgradeButtons();
        initFunctionalButtonsInTopPanel();
    }

    /**
     * Instantiates the bank account model and set the initial balance
     * Also updates the panel that shows the balance
     */
    private void initBankAccount() {
        account = new BankAccount();
        account.setBalance(BankAccount.INITIAL_BALANCE);
        drawingDataPanelDelegate.reloadBalanceDataView(account.getBalance());
    }

    /**
     * Adds the logic functionality for each button in the top panel
     * @see  java.awt.event.ActionListener
     */
    private void initFunctionalButtonsInTopPanel() {
        
        /**
         * Creates Action listener for the wave start button
         */
        mainGameView.topView.gameDataPanel.waveStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentWaveNum == WaveFactory.MAX_WAVE_NUM) {
                    currentWaveNum = 0;
                }
                initCrittersForWave(++currentWaveNum);
                drawingDataPanelDelegate.reloadWaveDataView(currentWaveNum);
            }
        });

        /**
         * Creates Action listener for strategy selection for towers. 
         * This sets tower strategies to target based on weakest
         */
        mainGameView.topView.gameDataPanel.TargetBasedOnWeakestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStrategy = new TargetBasedOnWeakest();
                for (Tower t : towerCollection.getTowers().values()) {
                    t.setShootingStrategy(currentStrategy);
                }
            }
        });

        /**
         * Creates Action listener for strategy selection for towers. 
         * This sets tower strategies to target based on strongest
         */
        mainGameView.topView.gameDataPanel.TargetBasedOnStrongestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStrategy = new TargetBasedOnStrongest();
                for (Tower t : towerCollection.getTowers().values()) {
                    t.setShootingStrategy(currentStrategy);
                }
            }
        });

        /**
         * Creates Action listener for strategy selection for towers. 
         * This sets tower strategies to target based on nearest
         */
        mainGameView.topView.gameDataPanel.TargetBasedOnNearestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStrategy = new TargetBasedOnNearest();
                for (Tower t : towerCollection.getTowers().values()) {
                    t.setShootingStrategy(currentStrategy);
                }
            }
        });

        /**
         * Creates Action listener for exit button
         */
        mainGameView.topView.gameDataPanel.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearGame();
                mainGameView.setVisible(false);
                new MainMenuController().mainMenuView.setVisible(true);
            }
        });

    }

    /**
     * Initiates the needed values of critters for the wave
     * @param waveNum index for a preexistent type of wave specified in the factory
     */
    private void initCrittersForWave(int waveNum) {
        CritterCollection.clearAllCritters();
        for (Tower t: towerCollection.getTowers().values()) {
            t.getCrittersInRange().clear();
        }
        WaveFactory.sharedInstance().getWave(waveNum);
        CritterCollection.setGameMapForCritters(gameMap);
    }

    /**
     * Adds the logic functionality for each button in the side panel
     * @see  java.awt.event.ActionListener
     */
    private void initSellUpgradeButtons() {
        
        /**
         * Creates action listener for sell tower button on the side panel
         */
        mainGameView.endView.towerUpgradeSellPanel.upgradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentTower != null){
                    int level = currentTower.getLevel();
                    if (level < Tower.MAX_LEVEL) {
                        double oldPrice = currentTower.getBuyPrice();
                        currentTower.setLevel(++level);
                        double newPrice = currentTower.getBuyPrice();
                        if (newPrice - oldPrice > account.getBalance()) {
                            drawingDataPanelDelegate.reloadInfoDataView("Need more gold");
                            currentTower.setLevel(--level);
                        } else {
                            account.withDraw(newPrice - oldPrice);
                            drawingDataPanelDelegate.reloadBalanceDataView(account.getBalance());
                        }
                        refreshGamePanelsView();
                    } else { // warning!
                        drawingDataPanelDelegate.reloadInfoDataView("Max Level of tower is " + Tower.MAX_LEVEL);
                    }
                }
            }
        });

        /**
         * Creates action listener for upgrade tower button on the side panel
         */
        mainGameView.endView.towerUpgradeSellPanel.sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentTower != null) {
                    account.deposit(currentTower.getSellPrice());
                    drawingDataPanelDelegate.reloadBalanceDataView(account.getBalance());
                    currentTower = null;
                    towerCollection.removeTowerAtIndex(currentIndex);
                    gameMap.getCells().set(currentIndex, CellState.Grass);
                    currentIndex = -1;
                    refreshGamePanelsView();
                }
            }
        });
    }

    /**
     * Reloads the side panel
     */
    private void refreshGamePanelsView() {
        drawingMapInGameDelegate.refreshMap(gameMap, towerCollection);
        drawingSpecificationPanelDelegate.reloadPanelBasedOnTower(currentTower);
        drawingSellUpgradePanelDelegate.reloadPanelBasedOnTower(currentTower);
    }

    /**
     * Initializes Map creating Mouse listeners for placing/select towers
     */
    private void initMapArea() {
        mainGameView.mapView.mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                {
                    super.mousePressed(e);

                    int x = e.getX();
                    int y = e.getY();

                    int index = GameMapDrawing.coordinateToIndexConverter(x, y, gameMap.getmCols());
                    ArrayList<CellState> cellList = gameMap.getCells();

                    if (e.getButton() == MouseEvent.BUTTON1) { // User left click map cells

                        // 1. if it is "toPlaceTower" state:  toPlaceTower -> Tower state
                        if (cellList.get(index) == CellState.ToPlaceTower) {
                            account.withDraw(currentTower.getBuyPrice());
                            drawingDataPanelDelegate.reloadBalanceDataView(account.getBalance());
                            cellList.set(index, CellState.Tower);
                            Tower tower = TowerFactory.sharedInstance().getTower(currentTower.getTowerName());
                            tower.setShootingStrategy(currentStrategy);
                            tower.setPosition(GameMapDrawing.indexToCoordinateConverter(index, gameMap.getmCols()));
                            towerCollection.addTowerAtIndex(index, tower);
                            gameMap.setToGrassState();
                            refreshGamePanelsView();
                            System.out.println("1");
                        }
                        // 2. if it is "Tower" state:  Tower state -> Chosen state
                        else if (cellList.get(index) == CellState.Tower) {
                            gameMap.setToGrassState();
                            gameMap.toggleChosenState(index);
                            currentTower = towerCollection.getTowers().get(index);
                            currentIndex = index;
                            refreshGamePanelsView();
                            System.out.println("2");
                        }
                        // 3. if it is "Chosen" state: Chosen state -> Tower State
                        else if (cellList.get(index) == CellState.Chosen){
                            cellList.set(index, CellState.Tower);
                            currentTower = null;
                            currentIndex = -1;
                            refreshGamePanelsView();
                            System.out.println("3");
                        }
                        // 4. Other Cells: Chosen state -> Tower state.
                        // ToPlaceTower state -> Grass state
                        else {
                            // if the user press the wrong cells, aka path, etc.
                            // set state back to grass
                            gameMap.clearState();
                            currentTower = null;
                            currentIndex = -1;
                            refreshGamePanelsView();
                            System.out.println("4");
                        }
                    }
                }
            }
        });

    }

    /**
     * Creates buttons for buying towers
     */
    private void initTowerButtons() {
        mainGameView.topView.towerSelectionPanel.towerAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTower = TowerFactory.sharedInstance().getTower(TowerName.TowerA1);
                currentTower.setShootingStrategy(currentStrategy);
                if (currentTower.getBuyPrice() <= account.getBalance()) {
                    gameMap.setToPlaceTowerState();
                    refreshGamePanelsView();
                } else {
                    gameMap.setToGrassState();
                    currentTower = null;
                    drawingDataPanelDelegate.reloadInfoDataView("Need more gold");
                }
            }
        });
        mainGameView.topView.towerSelectionPanel.towerBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTower = TowerFactory.sharedInstance().getTower(TowerName.TowerB1);
                currentTower.setShootingStrategy(currentStrategy);
                if (currentTower.getBuyPrice() <= account.getBalance()) {
                    gameMap.setToPlaceTowerState();
                    refreshGamePanelsView();
                } else {
                    gameMap.setToGrassState();
                    currentTower = null;
                    drawingDataPanelDelegate.reloadInfoDataView("Need more gold");
                }
            }
        });
        mainGameView.topView.towerSelectionPanel.towerCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTower = TowerFactory.sharedInstance().getTower(TowerName.TowerC1);
                currentTower.setShootingStrategy(currentStrategy);
                if (currentTower.getBuyPrice() <= account.getBalance()) {
                    gameMap.setToPlaceTowerState();
                    refreshGamePanelsView();
                } else {
                    gameMap.setToGrassState();
                    currentTower = null;
                    drawingDataPanelDelegate.reloadInfoDataView("Need more gold");
                }
            }
        });
    }

    /**
     * 
     */
    private void initPaintingTimers(){
        Timer paintingTimer = new Timer(REFRESH_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CritterCollection.crittersMoving();
                drawingMapInGameDelegate.refreshCrittersInMap();
                detectingCrittersInRange();
                drawingMapInGameDelegate.refreshShootingEffectInMap(towerCollection);
                detectingCrittersStoleCoins();

            }
        });
        paintingTimer.start();
    }

    /**
     * Detects if a critter was able to hit the end point and subtracts a coin.
     * If coins have ended sets the handler to finalize game
     */
    private void detectingCrittersStoleCoins() {
        for (Critter c : CritterCollection.critters) {
            if (c.isSucceed()) {
                coins --;
                drawingDataPanelDelegate.reloadCoinDataView(coins);
                if(coins == 0) {
                    gameOverHandler();  
                }
                c.setSucceed(false);
            }
        }
    }

    /**
     * 
     */
    private void initWaveTimers() {
        critterGeneratorTimer = new Timer(CRITTER_GENERATE_TIME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CritterCollection.currentIndex < CritterCollection.critters.size()) {
                    CritterCollection.critters.get(CritterCollection.currentIndex++).setVisible(true);    
                }
            }
        });
        critterGeneratorTimer.start();
    }

    /**
     * Detects critter range and veriies if it is in tower range
     * Also checks if critter is dead and hides it and add money to account
     */
    private void detectingCrittersInRange() {
        for (Tower t: towerCollection.getTowers().values()) {
            for (Critter c : CritterCollection.critters) {
                if (c.isVisible()) {
                    if (c.getBound().intersects(t.getBound())) {
                        t.getCrittersInRange().add(c);
                    } else {
                        t.getCrittersInRange().remove(c);
                    }
                    if (c.getCurrentHealth() <= 0) {
                        c.setKilled(true);
                        account.deposit(c.getWorth());
                        drawingDataPanelDelegate.reloadBalanceDataView(account.getBalance());
                        c.setVisible(false);
                    }
                }
            }
        }
    }

    /**
     * Clears game view and displays a dialog to select if player wants to play again or go back to main menu
     */
    private void gameOverHandler() {
        clearGame();
        Object[] options = {"Back to main menu",  "Play again!"};
        int n = JOptionPane.showOptionDialog(mainGameView,
                "Sorry, Game over...",
                "Oops!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            mainGameView.setVisible(false);
            new MainMenuController().mainMenuView.setVisible(true);
        } else {
            mainGameView.setVisible(false);
            new MapChooseController().mapChooseView.setVisible(true);
        }
    }

    /**
     * Clears the critter wave and stop critter generator
     */
    private void clearGame() {
        CritterCollection.clearAllCritters();
        critterGeneratorTimer.stop();
    }
}