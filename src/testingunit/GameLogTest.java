package testingunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.gamelog.Log;
import model.gamelog.LogType;
import model.gamelog.LoggerCollection;

/**
 * test game log.
 * 
 * @author m_lzahra
 * @version 1.0
 * @since 14/3/2016
 */
public class GameLogTest {

    Log waveLog;
    Log firstTowerLog;
    Log secondTowerLog;
    Log mapLog;
    String waveContent;
    String firstTowerContent;
    String secondTowerContent;
    String mapContent;
    int firstTowerId;
    int secondTowerId;
    
    /**
     * Test Setting values.
     */
    @Before
    public void testSetValus() {
        LoggerCollection.getInstance().clearAllLogs();
        firstTowerId = 1;
        secondTowerId = 2;
        waveLog = new Log(LogType.Wave,"critter is moving");
        waveContent = waveLog.toString();
        firstTowerLog = new Log(LogType.Tower,firstTowerId,"fist Tower");
        firstTowerContent = firstTowerLog.toString();
        secondTowerLog = new Log(LogType.Tower,secondTowerId,"second Tower");
        secondTowerContent =secondTowerLog.toString() ;
        mapLog = new Log(LogType.Map,"map has played");
        mapContent = mapLog.toString();
        LoggerCollection.getInstance().addLog(waveLog);
        LoggerCollection.getInstance().addLog(firstTowerLog);
        LoggerCollection.getInstance().addLog(secondTowerLog);
        LoggerCollection.getInstance().addLog(mapLog);
    }
    
    /**
     * Test getting wave content.
     */
    @Test
    public void testGetWaveContent() {
        String waveContentFromLogCollection = LoggerCollection.getInstance().showWaveLog();
        assertTrue(waveContentFromLogCollection.equals(waveContent));
    }
    
    /**
     * Test getting first tower content.
     */
    @Test
    public void testGetFristTowerContent() {
        String fristTowerContentFromLogCollection = LoggerCollection.getInstance().showTowerLogAtIndex(firstTowerId);
        assertTrue(fristTowerContentFromLogCollection.equals(firstTowerContent));
    }
    
    /**
     * Test getting all towers' contents.
     */
    @Test
    public void testGetAllTowersContent() {
        String allTowersContentFromLogCollection = LoggerCollection.getInstance().showAllTowerLog();
        String firstTowerAndSecondTower = firstTowerContent + secondTowerContent;
        assertTrue(allTowersContentFromLogCollection.equals(firstTowerAndSecondTower));
    }
    
    /**
     * Test getting map contents.
     */
    @Test
    public void testGetMapContent() {
        String mapContenetFromLogCollection = LoggerCollection.getInstance().showMapLog();
        assertTrue(mapContenetFromLogCollection.equals(mapContent));
    }
    
    /**
     * Test getting all logs.
     */
    @Test
    public void testGetAllLogs() {
        String allLogFromLogCollection = LoggerCollection.getInstance().showAllLog();
        String allLogs = waveContent + firstTowerContent + secondTowerContent + mapContent;
        assertTrue(allLogFromLogCollection.equals(allLogs));
    }
}