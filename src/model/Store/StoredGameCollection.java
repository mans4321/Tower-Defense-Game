package model.Store;

import utility.FileProcessing;

import java.util.ArrayList;

import model.map.GameMap;

/**
 * GameMapCollection class
 * store all game map that user created
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class StoredGameCollection {

	
    private static String JSON_FILE = "Games.json";

    private ArrayList<StoredGames> games;

    /**
     * constructor
     * create a new arraylist
     */
    public StoredGameCollection(){
        this.games = new ArrayList<>();
    }

    /**
     * g
     * @return
     */
    public ArrayList<StoredGames> getGames() {
        return games;
    }

    public void addGames(StoredGames games) {
        this.games.add(games);
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
