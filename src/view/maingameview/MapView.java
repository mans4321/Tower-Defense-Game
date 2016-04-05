package view.maingameview;

import model.critter.Critter;
import model.critter.CritterCollection;
import view.map.Drawing;
import model.tower.Tower;
import protocol.DrawingMapInGameDelegate;
import model.map.GameMap;
import model.tower.TowerCollection;
import view.map.GameMapDrawing;

import javax.swing.*;
import java.awt.*;


/**
 * Created by yongpinggao on 3/13/16.
 */
public class MapView extends JPanel {

    public MapPanel mapPanel;

    public MapView() {
        mapPanel = new MapPanel();
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapPanel, c);
    }


    public class MapPanel extends JPanel implements DrawingMapInGameDelegate {

        private GameMap gameMap = new GameMap();
        private TowerCollection towerCollection = new TowerCollection();
        private CritterCollection critterCollection = new CritterCollection();


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GameMapDrawing.CELL_SIZE * gameMap.getmCols(), GameMapDrawing.CELL_SIZE * gameMap.getmRows());
        }


        @Override
        public void refreshMap(GameMap map, TowerCollection towerCollection) {
            this.gameMap = map;
            this.towerCollection = towerCollection;
            repaint();
        }

        @Override
        public void refreshMap(GameMap map) {
            this.gameMap = map;
            mapPanel.revalidate();
            repaint();
        }


        @Override
        public void refreshCrittersInMap(CritterCollection critterCollection) {
            this.critterCollection = critterCollection;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            GameMapDrawing.drawGameMap(g, gameMap);
            drawTowers(g);
            drawCritters(g);
            drawHealthBar(g);
            drawTowerShootingRange(g);
            drawShootingView(g);
        }

        private void drawTowers(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            for (Tower tower: towerCollection.getTowers().values()) {
                g2d.drawImage(tower.getTowerView().getTowerImage(), tower.getPosition().getX(), tower.getPosition().getY(), null);
            }
        }

        private void drawTowerShootingRange(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            for (Tower tower: towerCollection.getTowers().values()) {
                g2d.draw(tower.getTowerShootingRangeView().getTowerRangeCircle());
            }
        }

        private void drawCritters(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            for (Critter c : critterCollection.getCritters()) {
                if (c.isVisible() && !c.isKilled() && !c.getMovingBehavior().isArrivedAtExit()) {
                    g2d.drawImage(c.getCritterView().getCritterImage(), c.getMovingBehavior().getCurrentPosition().getX(), c.getMovingBehavior().getCurrentPosition().getY(), null);
                }
            }
            g2d.dispose();
        }

        public void drawHealthBar(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            for (Critter c : critterCollection.getCritters()) {
                if (c.isVisible() && !c.isKilled() && !c.getMovingBehavior().isArrivedAtExit()) {
                    if (c.getHealthBarLength() > 0.6) {
                        g2d.setColor(Color.GREEN);
                    } else if (c.getHealthBarLength() > 0.3 && c.getHealthBarLength() < 0.6) {
                        g2d.setColor(Color.YELLOW);
                    } else g2d.setColor(Color.RED);
                    g2d.fillRect(c.getMovingBehavior().getCurrentPosition().getX(), c.getMovingBehavior().getCurrentPosition().getY() - 5, (int)(c.getHealthBarLength() * Drawing.CELL_SIZE), 3);
                    g2d.drawString(c.getCurrentHealth() + "",c.getMovingBehavior().getCurrentPosition().getX() - 5, c.getMovingBehavior().getCurrentPosition().getY() - 5);
                }
            }
            g2d.dispose();
        }

        public void drawShootingView(Graphics g) {
            for (Tower tower: towerCollection.getTowers().values()) {
                if (tower.getTowerShootingBehavior().isShooting() && tower.getTowerShootingBehavior().isTimeToShoot()) {
                    tower.getTowerShootingView().drawShootingEffect(g);
                    tower.getTowerShootingBehavior().setTimeToShoot(false);
                }
            }
        }
    }
}