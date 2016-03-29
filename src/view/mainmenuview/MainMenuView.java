package view.mainmenuview;

import java.awt.*;
import javax.swing.*;

/**
 * Class to represent the main menu.
 * @author yongpinggao 
 * @version 1.0 3/12/16
 */
public class MainMenuView extends JFrame {

    private final static int WINDOW_WIDTH = 400;
    private final static int WINDOW_HEIGHT = 222;
    private final String MENU_TITLE = "Defence of the Tower";
    public JButton editorButton;
    public JButton startGameButton;
    public JButton loadGame;

    /**
     * Default constructor, calls init.
     */
    public MainMenuView() {
        initMenuWindow();
    }

    /**
     * Creates the menu with default info.
     */
    private void initMenuWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(MENU_TITLE);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        editorButton = new JButton("Map Editor");
        startGameButton = new JButton("Start Game");
        loadGame = new JButton("Load Game");
        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        c.add(editorButton, new GridBagConstraints());
        c.add(loadGame, new GridBagConstraints());
        c.add(startGameButton, new GridBagConstraints());
    }
}