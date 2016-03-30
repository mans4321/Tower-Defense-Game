package model.svaeGame;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.gamelog.Log;
import model.tower.Tower;
import model.tower.TowerCollection;

public class GameInfo{
	
//private ArrayList<Log> gameLog;
private double balance;
private int waveNum;
private int coins;
private String gameName;
private String mapName;
private HashMap<Integer, Tower> towerCollection;
private ArrayList<Log> logList;
	public GameInfo( HashMap<Integer, Tower> towerCollection,ArrayList<Log> logList, double balance,int coins,int waveNum, String gameName,String mapName ){
	
	this.towerCollection = towerCollection;
	this.logList = logList;
	this.balance = balance;
	this.gameName = gameName;
	this.mapName = mapName;
	this.coins = coins;
	this.waveNum = waveNum;
}



	public HashMap<Integer, Tower> getTowerCollection() {
		return towerCollection;
	}


	public void setTowerCollection(HashMap<Integer, Tower> towerCollection) {
		this.towerCollection = towerCollection;
	}


	public ArrayList<Log> getLogList() {
		return logList;
	}


	public void setLogList(ArrayList<Log> logList) {
		this.logList = logList;
	}


public HashMap<Integer, Tower> getTowers() {
		return this.towerCollection;
}
public void setTowers(HashMap<Integer, Tower> towerCollection) {
	this.towerCollection = towerCollection;
}

public double getGold() {
	return balance;
}

public void setGold(double balance) {
	this.balance = balance;
}

public int getWaveNum() {
	return waveNum;
}

public void setWaveNum(int waveNum) {
	this.waveNum = waveNum;
}

public int getCoins() {
	return coins;
}

public void setCoins(int coins) {
	this.coins = coins;
}

public String getGameName() {
	return gameName;
}

public void setGameName(String gameName) {
	this.gameName = gameName;
}

public String getMapName() {
	return mapName;
}

public void setMapName(String mapName) {
	this.mapName = mapName;
}
}