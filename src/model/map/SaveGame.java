package model.map;

import java.util.ArrayList;

import utility.FileProcessing;

public class SaveGame {

	private static String JSON_FILE = "Games.json";
	ArrayList<SavedGamesCollection> games;
	
	public SaveGame() {
		
		games = new ArrayList<SavedGamesCollection>();
	}
	
	
	
	 public ArrayList<SavedGamesCollection> getGames() {
	        return games;
	    }

	    public void addGames(SavedGamesCollection game) {
	        this.games.add(game);
	    }

	    public void deleteGames(int index) {
	        this.games.remove(index);
	    }

	public static boolean saveMapsToFile(SaveGame games) {
		return FileProcessing.sharedInstance().writeToJsonFile(JSON_FILE, games);

}
	   public static SaveGame loadMapsFromFile() {
		return FileProcessing.sharedInstance().readFromJsonFile(JSON_FILE, SaveGame.class);
}

}
