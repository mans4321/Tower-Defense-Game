package View;


import viewcontroller.GamePanel;

import java.awt.*;

/**
 * Class for the whole app windows used for the game section
 * @author yongpinggao
 * @since 1/24/16
 *
 */
public class GameWindow extends BaseWindow {

    private GamePanel gamePanel;
    
    /**
     * Constructor receives map number
     * @param mapNum number of the selected map
     */
    public GameWindow(int mapNum) {
        super("Tower Defence Game");
        gamePanel = new GamePanel(WINDOW_WIDTH,WINDOW_HEIGHT,mapNum);

        Container c = this.getContentPane();
        c.add(gamePanel);


    }
   /**
    * getter for gmaePanel
    * @return gmaePanel
    */
	public GamePanel getGamePanel() {
		return gamePanel;
	}


}