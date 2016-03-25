package model.map;

import java.util.ArrayList;

import model.tower.Tower;
import model.tower.TowerCollection;
import utility.FileProcessing;

public class SavedGamesCollection {

	
	
	private TowerCollection towers;
	private GameMap map;
	private double gold;
	private int waveNum;
	private int coins;
	private String gameName;
	
	public SavedGamesCollection(TowerCollection towers, GameMap map , String gameName ,int coins
			, double balance, int currentWaveNum ){
		
		this.towers = towers;
		this.map =map;
		this.gold = balance;
		this.gameName = gameName;
		this.coins = coins;
		this.waveNum = currentWaveNum;
		
	}
	

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public TowerCollection getTowers() {
		return towers;
	}
	public void setTowers(TowerCollection towers) {
		this.towers = towers;
	}
	public GameMap getMaps() {
		return map;
	}
	public void setMaps(GameMap map) {
		this.map = map;
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
	
	
}