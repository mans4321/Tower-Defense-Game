package gamemodel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by yongpinggao on 1/26/16.
 */
public class MapChooseWindow extends BaseWindow {

    // Read from Json File
    private GameMapCollection mapCollection;

    // The maximum map for one page;
    private int nRows = 2;
    private int nCols = 2;

    private int mapNum;

    public MapChooseWindow(){

        super("Choose Game Map");

        this.setLayout(new GridLayout(nRows,nCols));
        Container c = this.getContentPane();

        mapCollection = JsonFileProcess.readFromJson();

        // TODO: Now it's no more than 4 maps. We need to add more.

        if (mapCollection.getMaps().size() <= nRows * nCols) {
            for(int i = 0; i < nRows * nCols; i++) {
                if(i < mapCollection.getMaps().size()){
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
                            int answer = JOptionPane.showConfirmDialog(MapChooseWindow.this,
                                    "You sure want to use this map?","Map Selection",
                                    JOptionPane.YES_NO_OPTION);
                            if(answer == 0){// User choose yes
                                setVisible(false);
                                // start game with No. mapNum map.
                                new GameWindow(mapNum).setVisible(true);
                            } else {// User choose no
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

    private class MapImagePanel extends JPanel {



        private String imageName;
        private JLabel label;

        public MapImagePanel(String imageName){

            this.imageName = imageName;
            this.setPreferredSize(new Dimension(GameWindow. WINDOW_WIDTH / nCols, GameWindow. WINDOW_HEIGHT / nRows));
            this.setLayout(new BorderLayout());
            this.setBackground(Color.GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.black));

            label = new JLabel(imageName);
            this.add(label, BorderLayout.PAGE_END);
            this.add(new ImagePanel(), BorderLayout.CENTER);


        }

        private class ImagePanel extends JPanel {
            public ImagePanel(){
                this.setPreferredSize(new Dimension(GameWindow. WINDOW_WIDTH / nCols, GameWindow. WINDOW_HEIGHT / nRows - label.getHeight()));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("maparchive/" + imageName + ".png").getImage();
                Graphics2D g2 = (Graphics2D)g;
                g2.drawImage(image, 5, 5, getWidth(), getHeight(), this);

            }

        }


    }




}
