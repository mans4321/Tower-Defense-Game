package viewcontroller;

import javax.swing.*;

import View.BaseWindow;
import View.GameWindow;
import View.MapImagePanel;
import gamemodel.gamemap.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Window for selecting the game map
 * @author yongpinggao
 * @since 1/26/16
 */
public class MapChooseWindow extends BaseWindow {

    // Read from Json File
    private GameMapCollection mapCollection;

    // The maximum map for one page;
    public static final int nRows = 2;
    public static final int nCols = 2;

    private int mapNum;
    
    /**
     * Constructor, will get a list of the 4 last created maps and display as option for the player to select
     */
    public MapChooseWindow() {

        super("Choose Game Map");

        this.setLayout(new GridLayout(nRows,nCols));
        Container c = this.getContentPane();

        mapCollection = FileProcessing.readMapFromJsonFile();

        // TODO: Now it's no more than nRows * nCols maps. We need to add more.
        if (mapCollection != null) {
            if (mapCollection.getMaps().size() <= nRows * nCols) {
                for(int i = 0; i < nRows * nCols; i++) {
                    if (i < mapCollection.getMaps().size()) {


                        String mapName = mapCollection.getMaps().get(i).getImageName();
                        final MapImagePanel imagePanel = new MapImagePanel(mapName);
                        // save i to mapNum;
                        imagePanel.putClientProperty("mapNum", i);
                        imagePanel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                super.mousePressed(e);

                                imagePanel.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                                // read i from mapNum
                                mapNum = (Integer) imagePanel.getClientProperty("mapNum");

                                repaint();

                                String[] options = {"cancel",
                                        "start game",
                                        "edit this map"};

                                int n = JOptionPane.showOptionDialog(MapChooseWindow.this,
                                        "Would you like to start game with this map or edit this map?",
                                        "Question",
                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        options,
                                        options[0]);

                                if (n == 1) {// User choose start game
                                    setVisible(false);
                                    // start game with No. mapNum map.
                                    new GameWindow(mapNum).setVisible(true);
                                } else if (n == 2) {// User choose edit map
                                    imagePanel.setBorder(BorderFactory.createLineBorder(Color.black));
                                    setVisible(false);
                                    // start game with No. mapNum map.
                                    new MapEditorWindow(mapNum).setVisible(true);
                                } else {
                                    imagePanel.setBorder(BorderFactory.createLineBorder(Color.black));
                                }
                            }
                        });

                        c.add(imagePanel);
                        continue;
                    }
                    // Just a placeholder to keep gird size fixed :)
                    c.add(new MapImagePanel(""));
                }
            }
        }



    }
    
   
}
