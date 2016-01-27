import javax.swing.*;
import java.awt.*;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class GameWindow extends JFrame {

    protected final static int WINDOW_WIDTH = 1200;
    // 22: the height of bar
    protected final static int WINDOW_HEIGHT = 722;

    private int wWidth = WINDOW_WIDTH;
    private int wHeight = WINDOW_HEIGHT;


    private final String gameTitle = "Defence of the Tower";

    public GameWindow(){
        initWindow();
    }

    private void initWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(gameTitle);
        this.setPreferredSize(new Dimension(wWidth,wHeight));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

        // Add Game JPanel
        // It has to be done before or during the construction
//        this.add(new GamePanel());

        Container c = this.getContentPane();
        c.add(new TopArea(), BorderLayout.PAGE_START);
        c.add(new EndArea(), BorderLayout.LINE_END);
        c.add(new MapPanel(), BorderLayout.LINE_START);


    }

    private class MapPanel extends JPanel {


        private final int WIDTH = WINDOW_WIDTH / 5 * 4;
        private final int HEIGHT = WINDOW_HEIGHT ;

        public MapPanel(){

            this.setBackground(Color.GRAY);
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }

    private class TopArea extends JPanel {

        private final int WIDTH = WINDOW_WIDTH;
        private final int HEIGHT = WINDOW_HEIGHT / 5;

        private GridLayout layout = new GridLayout(1,2);

        public TopArea(){
            this.setBackground(Color.RED);
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setLayout(layout);

            TowerSelectionPanel towerSelectionPanel = new TowerSelectionPanel();
            towerSelectionPanel.setBackground(Color.BLUE);



            DataPanel dataPanel = new DataPanel();
            dataPanel.setBackground(Color.CYAN);

            this.add(towerSelectionPanel);
            this.add(dataPanel);


        }
    }

    private class EndArea extends JPanel {


        private final int WIDTH = WINDOW_WIDTH / 5;
        private final int HEIGHT = WINDOW_HEIGHT ;

        private GridLayout layout = new GridLayout(2,1);


        public EndArea(){

            this.setBackground(Color.BLACK);
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setLayout(layout);

            TowerUpgradeSellPanel towerUpgradeSellPanel= new TowerUpgradeSellPanel();
            towerUpgradeSellPanel.setBackground(Color.RED);

            TowerSpecificationPanel towerSpecificationPanel = new TowerSpecificationPanel();
            towerSpecificationPanel.setBackground(Color.PINK);


            this.add(towerUpgradeSellPanel);
            this.add(towerSpecificationPanel);

        }
    }

}
