package viewcontroller;
import javax.swing.*;

/**
 * Class that describes the tower specification side panel 
 * @author yongpinggao
 * @since 1/24/16
 */
public class TowerSpecificationPanel extends JPanel {

    private JLabel specificationLabel;
    private JLabel buyPriceLabel;
    private JLabel sellPriceLabel;
    private JLabel rangeLabel;
    private JLabel powerLabel;
    private JLabel rateOfFireLabel;

    private String specification;
    private double buyPrice;
    private double sellPrice;
    private int range;
    private int power;
    private int rateOfFire;
    
    /**
     * Creates labels and fills with the information from the tower
     */
    public TowerSpecificationPanel() {
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
     * Setter for tower specification
     * @param specification type of tower
     */
    public void setSpecification(String specification) {
        this.specification = specification;
        this.specificationLabel.setText(specification);
    }
    
    /**
     * Setter for tower buy price
     * @param buyPrice price to buy tower
     */
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
        this.buyPriceLabel.setText("Buy Price: " + buyPrice + "");
    }
    
    /**
     * Setter for the sell price
     * @param sellPrice price to sell a tower
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
        this.sellPriceLabel.setText("Sell Price: " + sellPrice + "");
    }

    /**
     * Setter for the tower range
     * @param range range of the tower
     */
    public void setRange(int range) {
        this.range = range;
        this.rangeLabel.setText("Range: " + range + "");
    }
    
    /**
     * Setter for the power of a tower
     * @param power power of the tower
     */
    public void setPower(int power) {
        this.power = power;
        this.powerLabel.setText("Power: " +power + "");
    }
    
    /**
     * Setter for the rate of fire 
     * @param rateOfFire rate of fire
     */
    public void setRateOfFire(int rateOfFire) {
        this.rateOfFire = rateOfFire;
        this.rateOfFireLabel.setText("Rate Of Fire: " + rateOfFire + "");
    }
    
    /**
     * Clears all the information displayed when inspecting a tower
     */
    public void clearPanel() {
        this.specificationLabel.setText("");
        this.buyPriceLabel.setText("");
        this.sellPriceLabel.setText("");
        this.rangeLabel.setText("");
        this.powerLabel.setText("");
        this.rateOfFireLabel.setText("");
    }
}


