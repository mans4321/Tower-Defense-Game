import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class TowerSelectionPanel extends JPanel {

    private GridLayout layout;
    private int tRows;
    private int tCols;
    private TowerSelectionListener listener;
    private ImageCollection imageCollection;

    public TowerSelectionPanel(){
        tRows = 1;
        tCols = 3;
        layout = new GridLayout(tRows, tCols);
        setBackground(Color.BLUE);
        setLayout(layout);
        imageCollection = new ImageCollection();
        initComponents();

    }

    void initComponents(){
        // Starts with the first level of the tower
        TowerButton buttonTowerA = new TowerButton(imageCollection.getImageIcon(TowerID.TOWERAH.getName()));
        buttonTowerA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.placeTower(TowerID.TOWERA1);
            }
        });


        TowerButton buttonTowerB = new TowerButton((imageCollection.getImageIcon(TowerID.TOWERBH.getName())));
        buttonTowerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.placeTower(TowerID.TOWERB1);
            }
        });

        TowerButton buttonTowerC = new TowerButton((imageCollection.getImageIcon(TowerID.TOWERCH.getName())));
        buttonTowerC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.placeTower(TowerID.TOWERC1);
            }
        });

        add(buttonTowerA);
        add(buttonTowerB);
        add(buttonTowerC);

    }

    public void addTowerSelectionListener(TowerSelectionListener listener){
        this.listener = listener;
    }


    private class TowerButton extends JButton {
        private ImageIcon towerImageIcon;

        public TowerButton(ImageIcon towerImageIcon){
            super("", towerImageIcon);
            this.towerImageIcon = towerImageIcon;
        }
    }
}
