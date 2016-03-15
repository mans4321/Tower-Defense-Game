package View;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gamemodel.gamemap.FileProcessing;
import viewcontroller.MapChooseWindow;
import viewcontroller.MapEditorWindow;


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

    
    	
        JButton mapEditor = new JButton("Map Editor");
        mapEditor.setActionCommand("MapEditor");
        mapEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
                new MapEditorWindow().setVisible(true);
            }
        });


        JButton startGame = new JButton("Start Game");
        startGame.setActionCommand("StartGame");
        startGame.addActionListener(new ActionListener() {
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
        c.add(mapEditor, new GridBagConstraints());
        c.add(startGame, new GridBagConstraints());
    }

}
