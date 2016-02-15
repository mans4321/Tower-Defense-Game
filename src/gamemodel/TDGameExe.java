package gamemodel;
import javax.swing.*;
import java.awt.*;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class TDGameExe {

    public static void main(String[] args){


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MainMenuWindow().setVisible(true);

            }
        });
    }
}
