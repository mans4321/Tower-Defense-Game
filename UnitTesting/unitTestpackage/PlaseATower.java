package unitTestpackage;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import viewcontroller.GamePanel;
import viewcontroller.Listener;


public class PlaseATower {

	
    private GamePanel gamePanel ;
    private Listener listener;
    @Before
    public void setValues(){

    	gamePanel = new GamePanel(0, 0, 0);
    	listener =  new Listener();
    	ActionEvent e = null; 
    	e.setSource("sellTower");
    	listener.actionPerformed(e);
    	
    }
    
	 
	@Test
	public void test() {
	
	}

}
