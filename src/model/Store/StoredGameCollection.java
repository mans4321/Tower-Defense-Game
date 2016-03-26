package model.Store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import utility.FileProcessing;

public class StoredGameCollection {

	private static String JSON_FILE = "Games.json";
	private ArrayList<StoredGames> games;
	
	public StoredGameCollection() {
		
		this.games = new ArrayList<>();
	}
	
	
	
	 public ArrayList<StoredGames> getGames() {
	        return games;
	    }

	    public void addGames(StoredGames game) {
	        this.games.add(game);
	    }

	    public void deleteGames(int index) {
	        this.games.remove(index);
	    }

	public static boolean saveGamesToFile(StoredGameCollection games) {
		return FileProcessing.sharedInstance().writeToJsonFile(JSON_FILE, games);

}
	   public static StoredGameCollection loadGamesFromFile() {
		return FileProcessing.sharedInstance().readFromJsonFile(JSON_FILE, StoredGameCollection.class);
}

}
