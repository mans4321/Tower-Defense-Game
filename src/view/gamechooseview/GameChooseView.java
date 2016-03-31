package view.gamechooseview;

import java.awt.*;
import javax.swing.*;
import view.BaseWindowView;

/**
 * Class for the map selection menu
 * @author yongpinggao
 * @version 1.0 3/12/16
 */
public class GameChooseView extends BaseWindowView {

    public JButton startGameButton;
    public JScrollPane pane;
    public JList list;

    /**
     * Constructs the list of options for games.
     * @param  listModel list of game options
     */
    public GameChooseView(DefaultListModel listModel) {
        super(260, 200, "Load a Game");
        startGameButton = new JButton("Start this Game");
        list = new JList<>(listModel);
        list.setSelectedIndex(0);
        pane = new JScrollPane(list);

        setLayout(new BorderLayout());
        add(pane, BorderLayout.PAGE_START);
        add(startGameButton, BorderLayout.LINE_END);
    }
}