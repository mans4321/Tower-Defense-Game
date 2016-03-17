package view.maingameview;

import java.awt.*;
import javax.swing.*;
import model.drawing.CritterDrawing;
import model.drawing.GameMapDrawing;
import model.tower.TowerCollection;
import model.map.GameMap;
import protocol.DrawingMapInGameDelegate;

/**
 * Class for the map view, main game play view.
 * @author yongpinggao 
 * @version  1.0 3/13/16.
 */
public class MapView extends JPanel {

    public MapPanel mapPanel;

    /**
     * Contructor creates basic view options for the map view.
     */
    public MapView() {
        mapPanel = new MapPanel();
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapPanel, c);
    }

    /**
     * Internal class for map panel.
     */
    public class MapPanel extends JPanel implements DrawingMapInGameDelegate {

        private GameMap gameMap = new GameMap();
        private TowerCollection towerCollection = new TowerCollection();

        /**
         * Function to get the preferred size of panel.
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GameMapDrawing.CELL_SIZE * gameMap.getmCols(), GameMapDrawing.CELL_SIZE * gameMap.getmRows());
        }

        /**
         * Function to paint the map on the view.
         * @param map game map object
         */
        @Override
        public void refreshMap(GameMap map) {
            this.gameMap = map;
            repaint();
        }

        /**
         * Function to paint the map and towers on the view.
         * @param map             game map object
         * @param towerCollection list of towers 
         */
        @Override
        public void refreshMap(GameMap map, TowerCollection towerCollection) {
            this.gameMap = map;
            this.towerCollection = towerCollection;
            repaint();
        }

        /**
         * Function that will display critters.
         */
        @Override
        public void refreshCrittersInMap() {
            repaint();
        }

        /**
         * Function to display the missiles on the map.
         * @param towerCollection list of towers
         */
        @Override
        public void refreshShootingEffectInMap(TowerCollection towerCollection) {
            this.towerCollection = towerCollection;
            repaint();
        }

        /**
         * Function to call the draw method on critters and gamemap.
         * @param g graphics object
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            GameMapDrawing.drawMapAndTower(g, gameMap, towerCollection, this);
            CritterDrawing.drawCritters(g, this);
            CritterDrawing.drawHealthBar(g);
            GameMapDrawing.drawTowerRange(g, towerCollection, gameMap, this);
            towerCollection.drawShootingEffect(g);
        }
    }
}
