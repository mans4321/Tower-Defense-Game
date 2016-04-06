package view.mapeditorview;

import java.awt.*;
import javax.swing.*;
import model.drawing.GameMapDrawing;
import model.map.GameMap;
import protocol.DrawingMapDelegate;
import view.BaseWindowView;

/**
 * Class for the map view.
 * @author yongpinggao 
 * @version  1.0 3/12/16
 */
public class MapView extends JPanel {

    public MapPanel mapPanel;

    /**
     * Default constructor sets size and defult properties.
     */
    public MapView() {
        setPreferredSize(new Dimension(BaseWindowView.WINDOW_WIDTH, BaseWindowView.WINDOW_HEIGHT / 10 * 9));
        mapPanel = new MapPanel();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        add(mapPanel, c);
    }

    /**
     * Inner class for the map panel
     */
    public class MapPanel extends JPanel implements DrawingMapDelegate {

        private GameMap map = new GameMap();

        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GameMapDrawing.CELL_SIZE * map.getmCols(), GameMapDrawing.CELL_SIZE * map.getmRows());
        }

        /**
         * {@inheritDoc}
         * @param g graphic object
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            GameMapDrawing.drawMapAndTower(g, map, null, this);
        }

        /**
         * {@inheritDoc}
         * @param map game map
         */
        @Override   
        public void refreshMap(GameMap map) {
            this.map = map;
            mapPanel.revalidate();
            repaint();
        }
    }
}