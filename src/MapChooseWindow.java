import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by yongpinggao on 1/26/16.
 */
public class MapChooseWindow extends JFrame {

    // Read from Json File
    private GameMapCollection maps;

    private String WINDOW_TITLE = "Choose Game Map";

    // The maximum maps for one page;
    private int nRows = 2;
    private int nCols = 2;

    public MapChooseWindow(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(WINDOW_TITLE);
        this.setPreferredSize(new Dimension(GameWindow.WINDOW_WIDTH,GameWindow.WINDOW_HEIGHT));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(nRows,nCols));
        Container c = this.getContentPane();

        maps = JsonFileProcess.readFromJson();

        // TODO: Now it's no more than 4 maps. We need to add more.

        if (maps.getMaps().size() <= nRows * nCols) {
            for(int i = 0; i < nRows * nCols; i++) {
                if(i < maps.getMaps().size()){
                    String mapName = maps.getMaps().get(i).getImageName();
                    MapImagePanel imagePanel = new MapImagePanel(mapName);
                    imagePanel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            super.mousePressed(e);
                            imagePanel.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                            repaint();
                            int answer = JOptionPane.showConfirmDialog(MapChooseWindow.this,
                                    "You sure want to use this map?","Map Selection",
                                    JOptionPane.YES_NO_OPTION);
                            if(answer == 0){// User choose yes
                                setVisible(false);
                                new GameWindow().setVisible(true);
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

    class MapImagePanel extends JPanel {

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

        class ImagePanel extends JPanel {
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
