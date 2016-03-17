package view.maingameview;

import java.awt.*;
import javax.swing.*;
import protocol.DrawingPanelDelegate;
import model.tower.Tower;

/**
 * Class for the representation of tower specification.
 * @author yongpinggao
 * @version 1.0 3/13/16
 */
public class TowerSpecificationPanel extends JPanel implements DrawingPanelDelegate {
    public JLabel specificationLabel;
    public JLabel buyPriceLabel;
    public JLabel sellPriceLabel;
    public JLabel rangeLabel;
    public JLabel powerLabel;
    public JLabel rateOfFireLabel;

    /**
     * Default constructor. Sets all information to empty.
     */
    public TowerSpecificationPanel() {
        setBackground(Color.white);
        specificationLabel = new JLabel("");
        buyPriceLabel = new JLabel("");
        sellPriceLabel = new JLabel("");
        rangeLabel = new JLabel("");
        powerLabel = new JLabel("");
        rateOfFireLabel = new JLabel("");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(specificationLabel);
        add(buyPriceLabel);
        add(sellPriceLabel);
        add(rangeLabel);
        add(powerLabel);
        add(rateOfFireLabel);
    }

    /**
     * Method that will display the information of a certain tower.
     * @param tower selected tower placed in the map
     */
    @Override
    public void reloadPanelBasedOnTower(Tower tower) {
        if (tower != null) {
            specificationLabel.setText(tower.getSpecification());
            buyPriceLabel.setText("Buy Price: " + tower.getBuyPrice()+"");
            sellPriceLabel.setText("Sell Price: " + tower.getSellPrice() + "");
            rangeLabel.setText("Shooting Range: " + tower.getRange());
            powerLabel.setText("Shooting Power: " + tower.getPower());
            rateOfFireLabel.setText("Shooting Rate: " + tower.getRateOfFire());
        } else {
            specificationLabel.setText("");
            buyPriceLabel.setText("");
            sellPriceLabel.setText("");
            rangeLabel.setText("");
            powerLabel.setText("");
            rateOfFireLabel.setText("");
        }

    }
}
