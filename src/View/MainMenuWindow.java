package View;
import javax.swing.*;

import gamemodel.gamemap.FileProcessing;
import viewcontroller.MapChooseWindow;
import viewcontroller.MapEditorWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Class that draws the window selection between mapeditor and game
 * @author yongpinggao
 *
 */
public class MainMenuWindow extends JFrame {

    private final static int WINDOW_WIDTH = 400;
    // 22: the height of bar
    private final static int WINDOW_HEIGHT = 222;

    private String menuTitle = "Defence of the Tower";
    
    /**
     * Starts window
     */
    public MainMenuWindow() {
        initMenuWindow();
    }
    
    /**
     * Sets events and information to initiate window with default values
     */
    private void initMenuWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(menuTitle);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

        addComponents();
    }

    /**
     * Add buttons to the window
     */
    private void addComponents() {

        JButton b1 = new JButton("Map Editor");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MapEditorWindow().setVisible(true);
            }
        });


        JButton b2 = new JButton("Start Game");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
//                new GameWindow().setVisible(true);
                if (FileProcessing.readMapFromJsonFile() == null) {
                    JOptionPane.showMessageDialog(MainMenuWindow.this, "No Saved Maps, please go to the Map editor", "Error", JOptionPane.YES_OPTION);
                    setVisible(false);
                    new MapEditorWindow().setVisible(true);
                } else {
                    new MapChooseWindow().setVisible(true);
                }

            }
        });

        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        c.add(b1, new GridBagConstraints());
        c.add(b2, new GridBagConstraints());
    }

}
