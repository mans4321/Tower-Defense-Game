package viewcontroller;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class GameWindow extends BaseWindow {

    private GameController gamePanel;

    public GameWindow(int mapNum){
        super("Tower Defence Game");
        gamePanel = new GameController(WINDOW_WIDTH,WINDOW_HEIGHT,mapNum);

        Container c = this.getContentPane();
        c.add(gamePanel);


    }


}
