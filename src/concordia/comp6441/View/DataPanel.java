package concordia.comp6441.View;
import javax.swing.*;
import java.awt.*;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class DataPanel extends JPanel {

    private JLabel balanceLabel;
    private JLabel warningLabel;
    private double balance;
    private String warningMsg;

    public DataPanel(){

        setLayout(new BorderLayout());
        balance = 0;
        warningMsg = "";

        balanceLabel = new JLabel("");
        warningLabel = new JLabel(warningMsg);
        add(balanceLabel, BorderLayout.LINE_START);
        add(warningLabel,BorderLayout.PAGE_END);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        balanceLabel.setText("Balance: " + balance + "");
    }

    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg;
        this.warningLabel.setText(warningMsg);
    }
}
