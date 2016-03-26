package model.map;

import java.util.ArrayList;
import java.util.HashMap;

import model.tower.Tower;
import model.tower.TowerCollection;
import utility.FileProcessing;

public class StoredGames {

	
	
	private ArrayList<Tower> towers;
	private double gold;
	private int waveNum;
	private int coins;
	private String gameName;
	private String mapName;
	
	public StoredGames(ArrayList<Tower> towers, String gameName,String mapName ,int coins
			, double balance, int currentWaveNum ){
		
		this.towers = towers;
		this.gold = balance;
		this.gameName = gameName;
		this.mapName = mapName;
		this.coins = coins;
		this.waveNum = currentWaveNum;
		
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
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