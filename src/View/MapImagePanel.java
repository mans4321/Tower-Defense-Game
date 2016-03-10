package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gamemodel.gamemap.FileProcessing;
import utility.Utility;
import viewcontroller.MapChooseWindow;



	 /**
     * Class to define each image that will be displayed in the map selection window
     * @author yongpinggao
     *
     */
    public class MapImagePanel extends JPanel {

        private JLabel label;
        private ImagePanel imagePanel;
        
        /**
         * Constructor, creates a panel with image to take over a section of the selection window
         * @param imageName
         */
        public MapImagePanel(String imageName) {

            this.setPreferredSize(new Dimension(GameWindow. WINDOW_WIDTH / MapChooseWindow.nCols, 
            		GameWindow. WINDOW_HEIGHT / MapChooseWindow.nRows));
            this.setLayout(new BorderLayout());
            this.setBackground(Color.GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.black));


            label = new JLabel(imageName);
            imagePanel = new ImagePanel(imageName);

            this.add(label, BorderLayout.PAGE_END);
            this.add(imagePanel, BorderLayout.CENTER);



        }
        
        /**
         * The images that will be placed in the map selection window
         * @author yongpinggao
         *
         */
        private class ImagePanel extends JPanel {
            private ImageIcon imageIcon;
            
            /**
             * Creates an icon from map archive
             * @param name
             */
            public ImagePanel(String name) {
                this.setPreferredSize(new Dimension(GameWindow. WINDOW_WIDTH / MapChooseWindow.nCols, 
                		GameWindow. WINDOW_HEIGHT / MapChooseWindow.nRows - label.getHeight()));

                if (!name.equals("")) {
                    imageIcon = FileProcessing.readFromMapArchive(name);
                }

            }
            
            /**
             * {@inheritDoc}
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;


                if (imageIcon != null) {
                    Dimension d = Utility.getScaledDimension(new Dimension(imageIcon.getIconWidth(), 
                    		imageIcon.getIconHeight()), new Dimension(getWidth(),getHeight()));
                    
                    g2.drawImage(imageIcon.getImage(), 5, 5, d.width , d.height, this);
                }
            }
        }
    }

