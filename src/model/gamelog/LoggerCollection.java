package model.gamelog;


import com.google.gson.annotations.Expose;
import model.map.GameMap;
import model.savegame.GameInfo;

import java.util.ArrayList;

/**
 * Created by yongpinggao on 3/25/16.
 */
public class LoggerCollection {


    private static LoggerCollection sharedInstance = new LoggerCollection();

    public static LoggerCollection getInstance() {
        return sharedInstance;
    }

    private LoggerCollection() {}
    @Expose
    private ArrayList<Log> logList = new ArrayList<>();

    public void addLog(Log log) {
        logList.add(log);

    }

    public void clearAllLogs() {
        logList.clear();
    }

    public ArrayList<Log> getLogList() {
        return logList;
    }

    public ArrayList<Log> getGameLogList() {
        ArrayList<Log> gamelogs = new ArrayList<>();
        for(Log log: logList) {
            if (log.getLogType() != LogType.Map) {
                gamelogs.add(log);
            }
        }
        return gamelogs;
    }

    public String showAllLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Log log: logList) {
            stringBuilder.append(log.toString());
        }
        return stringBuilder.toString();
    }

    public String showAllTowerLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Log log: logList) {
            if(log.getLogType() == LogType.Tower) {
                stringBuilder.append(log.toString());
            }
        }
        return stringBuilder.toString();
    }

    public String showTowerLogAtIndex(int index) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Log log: logList) {
            if(log.getLogType() == LogType.Tower) {
                if(index == log.getId()) {
                    stringBuilder.append(log.toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    public String showWaveLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Log log: logList) {
            if(log.getLogType() == LogType.Wave) {
                stringBuilder.append(log.toString());
            }
        }
        return stringBuilder.toString();
    }

    public String showMapLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Log log: logList) {
            if(log.getLogType() == LogType.Map) {
                stringBuilder.append(log.toString());
            }
        }
        return stringBuilder.toString();
    }

    public void addAllMapLog(GameMap gameMap) {
        addLog(new Log(LogType.Map, "Player created this Map at: " + gameMap.getCreateTime()));

        String editedTime = gameMap.getAllEditTime();
        if(!editedTime.equals(""))
        addLog(new Log(LogType.Map, "Player edited this Map at: \n" + editedTime));


        String results = gameMap.getAllResults();
        if(!results.equals(""))
        addLog(new Log(LogType.Map, "The result of each play: \n" + results));

    }



}
