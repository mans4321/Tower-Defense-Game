package viewcontroller;

import javax.swing.*;
import java.awt.*;

/**
 * Base window class for the game
 * Extends JFrame
 * @author yongpinggao
 * @see Jframe
 *
 */
public class BaseWindow extends JFrame {

    public final static int WINDOW_WIDTH = 1200;
    // 22: the height of bar
    public final static int WINDOW_HEIGHT = 722;

    private int width;
    private int height;

    private String titleName;
    
    /**
     * Constructor starts window and applies title, uses default dimensions
     * @param titleName title to be used in the window
     */
    public BaseWindow(String titleName) {
        width = WINDOW_WIDTH;
        height = WINDOW_HEIGHT;
        this.titleName = titleName;
        initWindow();
    }
    
    /**
     * Constructor starts window and applies title, uses custom dimensions
     * @param width window width
     * @param height window height
     * @param titleName title to be used
     */
    public BaseWindow(int width, int height, String titleName) {
        this.width = width;
        this.height = height;
        this.titleName = titleName;
        initWindow();
    }

    /**
     * starts the JFrame window
     */
    private void initWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(titleName);
        this.setPreferredSize(new Dimension(width,height));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }



}
