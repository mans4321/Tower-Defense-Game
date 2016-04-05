package model.gamelog;


import model.map.GameMap;

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

    private ArrayList<Log> logList = new ArrayList<>();

    public ArrayList<Log> getLogList() {
        return logList;
    }

    public void setLogList(ArrayList<Log> logList) {
        this.logList = logList;
    }

    public void addLog(Log log) {
        logList.add(log);

    }

    public void clearAllLogs() {
        logList.clear();
    }

    public String showAllLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Log log: logList) {
            stringBuilder.append(log.toString());
        }
        return stringBuilder.toString();
    }

    public String showAllTowerLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Log log: logList) {
            if (log.getWho() == LogType.Tower) {
                stringBuilder.append(log.toString());
            }
        }
        return stringBuilder.toString();
    }

    public String showTowerLogAtIndex(int index) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Log log: logList) {
            if (log.getWho() == LogType.Tower) {
                if (index == log.getId()) {
                    stringBuilder.append(log.toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    public String showWaveLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Log log: logList) {
            if (log.getWho() == LogType.Wave) {
                stringBuilder.append(log.toString());
            }
        }
        return stringBuilder.toString();
    }

    public String showMapLog() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Log log: logList) {
            if (log.getWho() == LogType.Map) {
                stringBuilder.append(log.toString());
            }
        }
        return stringBuilder.toString();
    }

    public void addAllMapLog(GameMap gameMap) {
        addLog(new Log(LogType.Map, "Player created this Map at: " + gameMap.getCreateTime()));

        String editedTime = gameMap.getAllEditTime();
        if (!editedTime.equals("")) {
            addLog(new Log(LogType.Map, "Player edited this Map at: \n" + editedTime));
        }


        String results = gameMap.getAllResults();
        if (!results.equals("")) {
            addLog(new Log(LogType.Map, "The result of each play: \n" + results));
        }

    }
}