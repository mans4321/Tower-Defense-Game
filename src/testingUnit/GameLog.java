package testingUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.gamelog.Log;
import model.gamelog.LogType;
import model.gamelog.LoggerCollection;

public class GameLog {

	Log waveLog,FirstTowerLog,secondTowerLog,mapLog,gameLog;
	String waveContent ;
	String firstTowerContent ;
	String secondTowerContent ;
	String mapContent ;
	int firstTowerId;
	int secondTowerId;
	
	
	  /**
     * Setting values for testing.
     */
    @Before
    public void setValus() {
    	LoggerCollection.getInstance().clearAllLogs();
    	firstTowerId = 1;
    	secondTowerId = 2;
    	waveLog = new Log(LogType.Wave,"critter is moving");
    	waveContent = waveLog.toString();
    	FirstTowerLog = new Log(LogType.Tower,firstTowerId,"fist Tower");
    	firstTowerContent = FirstTowerLog.toString();
    	secondTowerLog = new Log(LogType.Tower,secondTowerId,"second Tower");
    	secondTowerContent =secondTowerLog.toString() ;
    	mapLog = new Log(LogType.Map,"map has played");
    	mapContent = mapLog.toString();
    	LoggerCollection.getInstance().addLog(waveLog);
    	LoggerCollection.getInstance().addLog(FirstTowerLog);
        LoggerCollection.getInstance().addLog(secondTowerLog);
    	LoggerCollection.getInstance().addLog(mapLog);
    	
    	 
    }
    
    /**
     * 
     */
    @Test
    public void getWaveContent() {
    	 String waveContentFromLog = LoggerCollection.getInstance().showWaveLog();
    	 assertTrue(waveContentFromLog.equals(waveContent));
    }
    
    /**
     * 
     */
    @Test
    public void getFristTowerContent() {
    	 String fristTowerContentFromLog = LoggerCollection.getInstance().showTowerLogAtIndex(firstTowerId);
    	 assertTrue(fristTowerContentFromLog.equals(firstTowerContent));
    }
    /**
     * 
     */
    @Test
    public void getAllTowersContent() {
    	String allTowersContentFromLog = LoggerCollection.getInstance().showAllTowerLog();
    	String firstTowerAndSecondTower = firstTowerContent + secondTowerContent;
   	    assertTrue(allTowersContentFromLog.equals(firstTowerAndSecondTower));
    }
    
    /**
     * 
     */
    @Test
    public void getMapContent() {
    	String mapContenetFromLog = LoggerCollection.getInstance().showMapLog();
    	assertTrue(mapContenetFromLog.equals(mapContent));
    }
    /**
     * 
     */
    @Test
    public void getAllLogs() {
    	String allLogFromLog = LoggerCollection.getInstance().showAllLog();
    	String allLogs = waveContent + firstTowerContent + secondTowerContent + mapContent;
    	System.out.println(allLogFromLog);
    	assertTrue(allLogFromLog.equals(allLogs));
    	
    }
    
}