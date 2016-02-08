package concordia.comp6441.View;
import javax.swing.*;
import java.awt.*;

/**
 * Created by yongpinggao on 1/28/16.
 */
public class BaseWindow extends JFrame {

    public final static int WINDOW_WIDTH = 1200;
    // 22: the height of bar
    public final static int WINDOW_HEIGHT = 722;

    private int width;
    private int height;

    private String titleName;



    public BaseWindow(String titleName){
        width = WINDOW_WIDTH;
        height = WINDOW_HEIGHT;
        this.titleName = titleName;
        initWindow();
    }

    public BaseWindow(int width, int height, String titleName){
        this.width = width;
        this.height = height;
        this.titleName = titleName;
        initWindow();
    }

    private void initWindow() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(titleName);
        this.setPreferredSize(new Dimension(width,height));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }



}
