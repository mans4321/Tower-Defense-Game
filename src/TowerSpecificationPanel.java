
import javax.swing.*;

/**
 * Created by yongpinggao on 1/24/16.
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

    public TowerSpecificationPanel(){
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

    public void setSpecification(String specification) {
        this.specification = specification;
        this.specificationLabel.setText(specification);
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
        this.buyPriceLabel.setText("buyPrice: " + buyPrice + "");
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
        this.sellPriceLabel.setText("sellPrice: " + sellPrice + "");
    }

    public void setRange(int range) {
        this.range = range;
        this.rangeLabel.setText("range: " + range + "");
    }

    public void setPower(int power) {
        this.power = power;
        this.powerLabel.setText("power: " +power + "");
    }

    public void setRateOfFire(int rateOfFire) {
        this.rateOfFire = rateOfFire;
        this.rateOfFireLabel.setText("rateOfFire: " + rateOfFire + "");
    }
}


