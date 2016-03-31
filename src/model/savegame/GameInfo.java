package model.savegame;

import com.google.gson.annotations.Expose;
import model.gamelog.Log;
import model.bankaccount.BankAccount;
import model.critter.CritterCollection;
import model.tower.TowerCollection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by yongpinggao on 3/29/16.
 */
public class GameInfo {

    @Expose
    private String mapName;
    @Expose
    private TowerCollection towerCollection;
    @Expose
    private CritterCollection critterCollection;
    @Expose
    private int currentCritterIndex;
    @Expose
    private int currentWaveNum;
    @Expose
    private BankAccount account;
    @Expose
    private int coins;
    @Expose
    private boolean preWavePhase;
    @Expose
    private ArrayList<Log> logs;
    @Expose
    private ArrayList<String> savedTimeList = new ArrayList<>();
    @Expose
    private ArrayList<String> playedTimeList = new ArrayList<>();
    @Expose
    private HashMap<String, String> resultMap = new HashMap<>();


    public GameInfo(String mapName, ArrayList<Log> logs, TowerCollection towerCollection, CritterCollection critterCollection, int currentCritterIndex, int currentWaveNum, BankAccount account, int coins, boolean preWavePhase) {
        this.mapName = mapName;
        this.currentCritterIndex = currentCritterIndex;
        this.towerCollection = towerCollection;
        this.critterCollection = critterCollection;
        this.currentWaveNum = currentWaveNum;
        this.account = account;
        this.coins = coins;
        this.preWavePhase = preWavePhase;
        this.logs = logs;
    }

    public String getMapName() {
        return mapName;
    }

    public TowerCollection getTowerCollection() {
        return towerCollection;
    }

    public CritterCollection getCritterCollection() {
        return critterCollection;
    }

    public int getCurrentCritterIndex() {
        return currentCritterIndex;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public int getCurrentWaveNum() {
        return currentWaveNum;
    }

    public BankAccount getAccount() {
        return account;
    }

    public int getCoins() {
        return coins;
    }

    public boolean isPreWavePhase() {
        return preWavePhase;
    }

    public ArrayList<String> getPlayedTimeList() {
        return playedTimeList;
    }

    public void addPlayedTime(Date playedTime) {
        this.playedTimeList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(playedTime));
    }

    public String getLastPlayedTime() {
        return playedTimeList.get(playedTimeList.size() - 1);
    }

    public ArrayList<String> getSavedTimeList() {
        return savedTimeList;
    }

    public void addSavedTime(Date savedTime) {
        this.savedTimeList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(savedTime));
    }

    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public void addResultToMap(String result) {
        resultMap.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), result);
    }
}
