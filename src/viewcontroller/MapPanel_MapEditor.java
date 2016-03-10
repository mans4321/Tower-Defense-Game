package viewcontroller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import View.MainMenuWindow;
import gamemodel.gamemap.CellState;
import gamemodel.gamemap.FileProcessing;
import gamemodel.gamemap.GameMap;
import gamemodel.gamemap.GameMapCollection;
	

/**
 * Create the map based on the places where the user clicks
 * @author yongpinggao
 *
 */
public class MapPanel_MapEditor extends JPanel implements ActionListener {


	private final String OPTION_ENTRANCE = "Set as an Entrance";
    private final String OPTION_EXIT = "Set as an Exit";
    
    private int index;
    private int mapRows;
    private int mapCols;
    
    private ArrayList<CellState> cellList;
    
    /**
     * Constructor, uses mouse listeners to track places where user is clicking
     * Turns the click into different types of tiles for the map and display the new images
     */
    public MapPanel_MapEditor(int mapRows, int mapCols, ArrayList<CellState>cellList ) {
    	
    	this.mapRows = mapRows;
    	this.mapCols = mapCols;
    	this.cellList = cellList;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                int x = e.getX();
                int y = e.getY();

                index = DrawMap.coordinateConverter(x, y, mapCols);

                if (e.getButton() == MouseEvent.BUTTON1) {
                    // Left Click to set maps path
                    if (cellList.get(index) == CellState.GRASS) {
                        cellList.set(index, CellState.PATH);
                    } else if (cellList.get(index) == CellState.PATH) {
                        cellList.set(index, CellState.GRASS);
                    } else if (cellList.get(index) == CellState.ENTRANCE || cellList.get(index) == CellState.EXIT) {
                        cellList.set(index, CellState.PATH);
                    }

                    repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (cellList.get(index) == CellState.PATH) {
                        JPopupMenu popup = new JPopupMenu();
                        JMenuItem menuItem1, menuItem2;
                        menuItem1 = new JMenuItem(OPTION_ENTRANCE);
                        menuItem1.addActionListener(MapPanel_MapEditor.this);
                        popup.add(menuItem1);
                        menuItem2 = new JMenuItem(OPTION_EXIT);
                        menuItem2.addActionListener(MapPanel_MapEditor.this);
                        popup.add(menuItem2);
                        popup.show(e.getComponent(), x, y);
                    }
                }
            }
        });
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawMap.drawMap(g, mapCols, mapRows, cellList, this);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JMenuItem) {
            // If the signal is from MenuItem of PopupMenu
            JMenuItem source = (JMenuItem)(e.getSource());
            if (source.getText().equals(OPTION_ENTRANCE)) {
                cellList.set(index, CellState.ENTRANCE);
            } else if (source.getText().equals(OPTION_EXIT)) {
                cellList.set(index, CellState.EXIT);
            }
            repaint();

        } else if (e.getSource() instanceof JComboBox) {

            // If the signal is from JComboBox
            JComboBox cb = (JComboBox)(e.getSource());
            String string = (String)cb.getSelectedItem();
            if (e.getActionCommand().equals("width")) {
                mapCols = Integer.parseInt(string);
            } else if (e.getActionCommand().equals("height")) {
                mapRows = Integer.parseInt(string);
            }
            clearMap();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DrawMap.CELL_SIZE * mapCols, DrawMap.CELL_SIZE * mapRows);
    }
    
    /**
     * Clean the map so the user can start a new map
     */
    public void clearMap() {
        // it will let layout manager run again!
        revalidate();
        cellList.clear();
        for(int i = 0; i < mapCols * mapRows; i++)
            cellList.add(CellState.GRASS);
        repaint();
    }
    
    /**
     * Saves an image of the map
     * @return
     */
    public BufferedImage mapCaptureShot() {
        BufferedImage image = new BufferedImage(DrawMap.CELL_SIZE * mapCols, DrawMap.CELL_SIZE * mapRows, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        print(g);
        g.dispose();
        return image;
    }
}
