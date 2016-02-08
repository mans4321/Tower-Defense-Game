package concordia.comp6441.Controller;
import javax.swing.*;

import concordia.comp6441.View.MainMenuWindow;


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
